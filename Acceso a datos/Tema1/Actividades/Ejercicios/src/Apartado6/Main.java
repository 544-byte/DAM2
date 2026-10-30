package Apartado6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
/**
 * Apartado 6: ejercicios sobre gestión de excepciones al trabajar con ficheros
 * ({@link FileNotFoundException}, {@link NumberFormatException}, fin de fichero...).
 */
public class Main {
    /** Punto de entrada del apartado 6. Ejecuta los ejercicios 1 al 5.
     *
     * @throws IOException si falla alguna operación de ficheros implicada
     */
    public static void main() throws IOException {
        System.out.println("----- COMIENZO PAQUETE 6 -----");
        ej1("ArchivoInexistente");
        ej2();
        ej3("Directorio/Apartado6/ArchivoMalFormateado");
        ej4("Directorio/Apartado5/Productos.dat");
        ej5("DirectorioInexistente");
        System.out.println("------ FIN DE PAQUETE 6 ------\n\n\n");
    }

    /**
     * Ejercicio 1: intenta abrir un fichero que no existe y captura la
     * {@link FileNotFoundException} mostrando un mensaje de error en rojo.
     *
     * @param ruta ruta del fichero inexistente que se intenta abrir
     */
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

    /** Ejercicio 2: lanza y captura una {@link SecurityException} para simular un fichero con permiso denegado. */
    public static void ej2() {
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        try{
            throw new SecurityException();
        } catch (SecurityException e) {
            System.out.println("\u001B[31mEjercicio 2 Apartado 6: El archivo no es accesible\u001B[0m");
        }
        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    /**
     * Ejercicio 3: lee un fichero de enteros mal formateado; al encontrar una
     * línea no numérica se produce una {@link NumberFormatException} que se
     * captura y se muestra por pantalla.
     *
     * @param ruta ruta del fichero con contenido mal formateado
     */
    public static void ej3(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        File dir = new File(ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(dir))){
            int[] enteros = new int[10];
            int i = 0;
            String linea = "";
            while ((linea = br.readLine()) != null){
                enteros[i] = Integer.parseInt(linea);
                i++;
            }
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31m"+e+"\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    /**
     * Ejercicio 4: lee objetos de un fichero serializado hasta llegar al final,
     * capturando la {@link EOFException} de forma controlada.
     *
     * @param ruta ruta del fichero binario de objetos
     */
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

    /**
     * Ejercicio 5: intenta escribir en un directorio que no existe y captura
     * la {@link FileNotFoundException} que se genera al usarlo como destino.
     *
     * @param ruta ruta del directorio inexistente en el que se intenta escribir
     */
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
