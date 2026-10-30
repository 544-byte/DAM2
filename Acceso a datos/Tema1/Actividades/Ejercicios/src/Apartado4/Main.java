package Apartado4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
/**
 * Apartado 4: ejercicios de escritura y lectura de ficheros con
 * {@link BufferedWriter}/{@link FileWriter}, {@link DataOutputStream}/
 * {@link DataInputStream}, serialización de objetos y compresión GZIP.
 */
public class Main {
    /** Punto de entrada del apartado 4. Prepara las listas de datos y ejecuta los ejercicios 1 al 4.
     *
     * @throws IOException si falla alguna operación de ficheros implicada
     */
    public static void main() throws IOException {
        System.out.println("----- COMIENZO PAQUETE 4 -----");
        List<Producto> productList = List.of(
                new Producto(1,"product1",4.99),
                new Producto(2,"product2",9.99),
                new Producto(3,"product3",14.99),
                new Producto(4,"product4",99.99)
        );
        ej1("Directorio/Apartado4/Productos.csv",productList);
        ej2("Directorio/Apartado4/Productos.dat",productList);
        List<Alumno> alumnoList = List.of(
                new Alumno("Marco","Aurelio","1º Bachiller"),
                new Alumno("Antonio","Pérez","2º año de Medicina"),
                new Alumno("María","de la O","FPM de Cocina"),
                new Alumno("Juana","de Arco","Curso de tiro con Arco")
        );
        ej3("Directorio/Apartado4/Alumnos.dat",alumnoList);
        ej4("Directorio/Apartado4/CompressedProductos.dat",productList);
        System.out.println("------ FIN DE PAQUETE 4 ------\n\n\n");
    }

    /**
     * Ejercicio 1: escribe una lista de productos en un fichero CSV,
     * una línea por producto.
     *
     * @param ruta         ruta del fichero CSV de destino
     * @param productList  lista de productos a escribir
     */
    public static void ej1(String ruta, List<Producto> productList){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dir.toFile()))) {
            for (Producto p : productList) {
                bw.write(p.toString());
                bw.newLine();
                System.out.println("Escrito nueva linea en " + dir.getFileName() +": " + p.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    /**
     * Ejercicio 2: escribe la lista de productos en un fichero binario con
     * {@link DataOutputStream} (id, longitud del nombre, caracteres del nombre y
     * precio) y a continuación los lee de vuelta con {@link DataInputStream}.
     *
     * @param ruta        ruta del fichero binario de destino
     * @param productList lista de productos a escribir
     */
    public static void ej2(String ruta, List<Producto> productList) {
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        Path dir = Paths.get(ruta);
        try(DataOutputStream dos = new DataOutputStream(Files.newOutputStream(dir))
        ) {
            for (Producto p : productList) {
                dos.writeInt(p.getId());
                dos.writeInt(p.getName().length());
                dos.writeChars(p.getName());
                dos.writeDouble(p.getPrice());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(DataInputStream dis = new DataInputStream(Files.newInputStream(dir))
        ) {
            System.out.println("Leyendo con data input stream los datos escritos: ");
            while (true) {
                int id = dis.readInt();
                int chars = dis.readInt();
                String nombre = "";
                int i;
                for (i = 0; i < chars; i++) {
                    nombre = nombre.concat(String.valueOf(dis.readChar()));
                }
                double price = dis.readDouble();
                System.out.println(id + "," + nombre + "," + price);
            }
        } catch (EOFException e){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    /**
     * Ejercicio 3: serializa una lista de alumnos en un fichero con
     * {@link ObjectOutputStream} y después los lee y muestra con {@link ObjectInputStream}.
     *
     * @param ruta       ruta del fichero binario de destino
     * @param alumnoList lista de alumnos a serializar
     */
    public static void ej3(String ruta, List<Alumno> alumnoList){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        Path dir = Paths.get(ruta);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dir.toFile()))) {
            for (Alumno a : alumnoList){
                oos.writeObject(a);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir.toFile()))) {
            System.out.println("Leyendo los Alumnos escritos:");
            while (true){
                Alumno alumno = (Alumno) ois.readObject();
                System.out.println(alumno.toString());
            }
        } catch (EOFException e){
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    /**
     * Ejercicio 4: escribe la lista de productos en un fichero binario comprimido
     * con GZIP y lo lee tres veces: una sin descomprimir (datos ilegibles desde el
     * fichero comprimido) y otra descomprimiendo con {@link GZIPInputStream}.
     *
     * @param ruta        ruta del fichero comprimido de destino
     * @param productList lista de productos a escribir
     */
    public static void ej4(String ruta, List<Producto> productList){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        try(DataOutputStream dos = new DataOutputStream(new GZIPOutputStream(Files.newOutputStream(dir)))
        ) {
            for (Producto p : productList) {
                dos.writeInt(p.getId());
                dos.writeInt(p.getName().length());
                dos.writeChars(p.getName());
                dos.writeDouble(p.getPrice());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(DataInputStream dis = new DataInputStream(Files.newInputStream(dir))
        ) {
            System.out.println("Leyendo con data input stream los datos escritos: ");
            while (true) {
                int id = dis.readInt();
                int chars = dis.readInt();
                String nombre = "";
                int i;
                for (i = 0; i < chars; i++) {
                    nombre = nombre.concat(String.valueOf(dis.readChar()));
                }
                double price = dis.readDouble();
                System.out.println(id + "," + nombre + "," + price);
            }
        } catch (EOFException e){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(DataInputStream dis = new DataInputStream(new GZIPInputStream(Files.newInputStream(dir)))
        ) {
            System.out.println("\nLeyendo con GZIP input stream los datos escritos con GZIP: ");
            while (true) {
                int id = dis.readInt();
                int chars = dis.readInt();
                String nombre = "";
                int i;
                for (i = 0; i < chars; i++) {
                    nombre = nombre.concat(String.valueOf(dis.readChar()));
                }
                double price = dis.readDouble();
                System.out.println(id + "," + nombre + "," + price);
            }
        } catch (EOFException e){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

}
