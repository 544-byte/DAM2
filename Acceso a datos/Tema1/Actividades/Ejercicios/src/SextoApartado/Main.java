package SextoApartado;

import QuintoApartado.Producto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
public class Main {
    public static void main() throws IOException {
        System.out.println("----- COMIENZO PAQUETE 6 -----");
        ej1("ArchivoInexistente");
        ej2();
        ej3("Directorio/Apartado6/ArchivoMalFormateado");
        ej4("Directorio/Apartado5/Productos.dat");
        ej5("DirectorioInexistente");
        System.out.println("------ FIN DE PAQUETE 6 ------\n\n\n");
    }

    public static void ej1(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(dir.toFile()))) {
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31mEjercicio 1 Apartado 6: El archivo " + dir.getFileName() + " no existe\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    public static void ej2() {
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        try{
            throw new SecurityException();
        } catch (SecurityException e) {
            System.out.println("\u001B[31mEjercicio 2 Apartado 6: El archivo no es accesible\u001B[0m");
        }
        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    public static void ej3(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        Path dir = Paths.get(ruta);

        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    public static void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(dir))) {
            while (true){
                ois.readObject();
            }
        } catch (EOFException e) {
            System.out.println("\u001B[31mfin de archivo\u001B[0m");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

    public static void ej5(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 5 ----");
        Path dir = Paths.get(ruta);
        try {
            if (!Files.exists(dir)) {
                throw new FileNotFoundException();
            } else {
                FileWriter fw = new FileWriter(dir.toString() + "/Sigma");
                fw.write("sigma");
                fw.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31mNo existe el directorio en el que se intenta escribir\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 5 -----\n");
    }
}
