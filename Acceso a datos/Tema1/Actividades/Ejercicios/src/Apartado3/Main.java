package Apartado3;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Apartado 3: ejercicios de lectura de ficheros CSV y de ficheros de objetos
 * serializados ({@link ObjectInputStream}).
 */
public class Main {
    /** Punto de entrada del apartado 3. Ejecuta los ejercicios 1 al 4. */
    public static void main(){
        System.out.println("----- COMIENZO PAQUETE 3 -----");
        ej1("Directorio/Apartado3/personas.csv");
        ej2("Directorio/Apartado3/personas.csv");
        ej3("Directorio/Apartado3/personas.dat");
        ej4("Directorio/Apartado3/personas.dat");
        System.out.println("------ FIN DE PAQUETE 3 ------\n\n\n");

    }

    /**
     * Ejercicio 1: lee un CSV de personas con formato {@code nombre,edad,email}
     * y muestra sus campos separados por espacios.
     *
     * @param ruta ruta del fichero CSV
     */
    public static void ej1(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        try (BufferedReader br = Files.newBufferedReader(dir)) {
            for (String linea : br.readAllLines()){
                    String[] registro = linea.split(",");
                    System.out.println(registro[0]+" "+registro[1]+" "+registro[2]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    /**
     * Ejercicio 2: lee un CSV de personas con formato {@code nombre,edad,email}
     * y carga cada línea en un objeto {@link Persona}, mostrando la lista completa.
     *
     * @param ruta ruta del fichero CSV
     */
    public static void ej2(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        ArrayList<Persona> personas = new ArrayList<>();
        Path dir = Paths.get(ruta);
        try (BufferedReader br = Files.newBufferedReader(dir)) {
            for (String linea : br.readAllLines()){
                String[] registro = linea.split(",");
                personas.add(new Persona(registro[0],Integer.parseInt(registro[1]),registro[2]));
            }
            System.out.println("Personas: ");
            System.out.println(personas.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    /**
     * Ejercicio 3: lee objetos {@link Persona} de un fichero serializado
     * y los muestra por pantalla hasta alcanzar el final del fichero.
     *
     * @param ruta ruta del fichero binario de objetos
     */
    public static void ej3(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        Path dir = Paths.get(ruta);
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir.toFile()));) {
            while (true) {
                Persona p = (Persona) ois.readObject();
                System.out.println(p);
            }
        } catch (EOFException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    /**
     * Ejercicio 4: lee los objetos {@link Persona} de un fichero serializado,
     * los ordena por edad de forma ascendente y los muestra por pantalla.
     *
     * @param ruta ruta del fichero binario de objetos
     */
    public static void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        ArrayList<Persona> personas = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir.toFile()));) {
            while (true) {
                Persona p = (Persona) ois.readObject();
                personas.add(p);
            }
        } catch (EOFException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        personas.sort(Comparator.comparing(Persona::getEdad));
        for (Persona p : personas) System.out.println(p);
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }
}
