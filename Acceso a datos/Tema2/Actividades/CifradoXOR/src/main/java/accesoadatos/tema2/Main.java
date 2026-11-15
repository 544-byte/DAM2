package accesoadatos.tema2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final byte ID1 = 0x00;
    private static final byte ID2 = 0x77;

    void main(String[] args) {
        //final Path archivo = Paths.get(args[0]);
        //final byte firma = (byte) Integer.parseInt(args[1],2);
        final Path archivo = Paths.get("archivo.bin");
        final byte firma = (byte) Integer.parseInt("11001010",2);

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEJECUCIÓN " + (i + 1));

            System.out.printf("Byte a byte: %.4f ms%n",
                    medirTiempo(() -> encriptacionv1(archivo, firma)));

            System.out.printf("Buffer 1024: %.4f ms%n",
                    medirTiempo(() -> encriptacionv2(archivo, firma, 1024)));

            System.out.printf("Buffer 2048: %.4f ms%n",
                    medirTiempo(() -> encriptacionv2(archivo, firma, 2048)));

            System.out.printf("Buffer 4096: %.4f ms%n",
                    medirTiempo(() -> encriptacionv2(archivo, firma, 4096)));

            System.out.printf("Buffer 8192: %.4f ms%n",
                    medirTiempo(() -> encriptacionv2(archivo, firma, 8192)));
        }
    }

    private double medirTiempo(Runnable proceso) {
        long inicio = System.nanoTime();
        proceso.run();
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0;
    }

    private byte xor (byte original, byte firma){
        return (byte) (original ^ firma);
    }

    private String leerArchivo(Path archivo) {
        try (FileInputStream fis = new FileInputStream(archivo.toFile())) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((b = fis.read()) != -1) {
                baos.write(b);
            }
            return baos.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }

    private boolean encriptacionv1(Path archivo,byte firma){
        try (
                FileInputStream fis = new FileInputStream(archivo.toFile());
                FileOutputStream fos = new FileOutputStream(archivo.toString().concat(".criptv1"))
        ) {
            int b;
            while ((b = fis.read()) != -1){
                fos.write(xor((byte) b,firma));
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean encriptacionv2(Path archivo,byte firma, int bufferSize){
        try (
                FileInputStream fis = new FileInputStream(archivo.toFile());
                FileOutputStream fos = new FileOutputStream(archivo.toString().concat(".criptv2"))
        ) {
            byte[] buffer = new byte[bufferSize];
            int bytesLeidos;
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesLeidos; i++) {
                    buffer[i] = xor(buffer[i], firma);
                }
                fos.write(buffer, 0, bytesLeidos);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean encriptacionv3(Path archivo, byte firma, int bufferSize) {
        if (bufferSize <= 0) return false;

        boolean esCript = archivo.toString().endsWith(".criptv3");
        try (
                DataInputStream fis = new DataInputStream(Files.newInputStream(archivo))
        ) {
            if (esCript) {
                if (fis.readUnsignedByte() != (ID1 & 0xFF) ||
                        fis.readUnsignedByte() != (ID2 & 0xFF)) {
                    return false;
                }
                CabeceraArchivo cabecera = leerCabecera(fis);
                firma = cabecera.firma();
                Path destino = archivo.getParent() == null
                        ? Path.of(cabecera.nombre() + cabecera.extension())
                        : archivo.getParent().resolve(
                        cabecera.nombre() + cabecera.extension()
                );
                try (FileOutputStream fos = new FileOutputStream(destino.toFile())) {
                    byte[] buffer = new byte[bufferSize];
                    int bytesLeidos;
                    long totalLeido = 0;
                    while ((bytesLeidos = fis.read(buffer)) != -1) {
                        for (int i = 0; i < bytesLeidos; i++) {
                            buffer[i] = xor(buffer[i], firma);
                        }
                        fos.write(buffer, 0, bytesLeidos);
                        totalLeido += bytesLeidos;
                    }
                    return totalLeido == cabecera.tamaño();
                }
            } else {
                String nombreCompleto = archivo.getFileName().toString();
                int punto = nombreCompleto.lastIndexOf('.');
                String nombre = punto > 0
                        ? nombreCompleto.substring(0, punto)
                        : nombreCompleto;
                String extension = punto > 0
                        ? nombreCompleto.substring(punto)
                        : "";
                long tamano = Files.size(archivo);
                CabeceraArchivo cabecera = new CabeceraArchivo(
                        nombre,
                        extension,
                        tamano,
                        firma
                );
                Path destino = Path.of(archivo.toString() + ".criptv3");
                try (DataOutputStream fos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(destino.toFile())
                        )
                )) {
                    fos.writeByte(ID1);
                    fos.writeByte(ID2);
                    escribirCabecera(fos, cabecera);
                    byte[] buffer = new byte[bufferSize];
                    int bytesLeidos;
                    while ((bytesLeidos = fis.read(buffer)) != -1) {

                        for (int i = 0; i < bytesLeidos; i++) {
                            buffer[i] = xor(buffer[i], firma);
                        }

                        fos.write(buffer, 0, bytesLeidos);
                    }
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    private void escribirCabecera(DataOutputStream fos, CabeceraArchivo cabecera) {
        byte[] nombre = cabecera.nombre().getBytes(StandardCharsets.UTF_8);
        byte[] extension = cabecera.extension().getBytes(StandardCharsets.UTF_8);
        try {
            fos.writeByte(cabecera.firma());
            fos.writeShort(nombre.length);
            fos.write(nombre);
            fos.writeShort(extension.length);
            fos.write(extension);
            fos.writeLong(cabecera.tamaño());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CabeceraArchivo leerCabecera(DataInputStream fis) {
        try {
            byte firma = fis.readByte();
            int longitudNombre = fis.readUnsignedShort();
            byte[] nombre = new byte[longitudNombre];
            fis.readFully(nombre);
            int longitudExtension = fis.readUnsignedShort();
            byte[] extension = new byte[longitudExtension];
            fis.readFully(extension);
            long tamaño = fis.readLong();

            return new CabeceraArchivo(
                    new String(nombre, StandardCharsets.UTF_8),
                    new String(extension, StandardCharsets.UTF_8),
                    tamaño,
                    firma
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
