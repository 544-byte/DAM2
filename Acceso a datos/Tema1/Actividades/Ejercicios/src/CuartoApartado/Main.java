package CuartoApartado;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
public class Main {
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
        System.out.println("------ FIN DE PAQUETE 4 ------\n");
    }

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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

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
