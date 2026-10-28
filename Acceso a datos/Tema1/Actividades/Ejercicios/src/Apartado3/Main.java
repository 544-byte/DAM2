package Apartado3;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(){
        System.out.println("----- COMIENZO PAQUETE 3 -----");
        ej1("Directorio/Apartado3/personas.csv");
        ej2("Directorio/Apartado3/personas.csv");
        ej3("Directorio/Apartado3/personas.dat");
        ej4("Directorio/Apartado3/personas.dat");
        System.out.println("------ FIN DE PAQUETE 3 ------\n\n\n");

    }

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
