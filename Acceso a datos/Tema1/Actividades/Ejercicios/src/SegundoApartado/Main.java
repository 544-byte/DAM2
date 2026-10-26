package SegundoApartado;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    void main(){
        ej1("Directorio/Directorio 1.1/Archivo 1.1.1.txt","java");
    }

    public void ej1(String ruta, String clave){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        int cont = 0;
        try(BufferedReader br = Files.newBufferedReader(dir)) {
            String linea;
            while ((linea = br.readLine()) != null){
                if (linea.contains(clave)) cont++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Palabra clave " + clave + " encontrada en " + cont + " líneas.");
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    public void ej2(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        Path dir = Paths.get(ruta);
        try (RandomAccessFile raf = new RandomAccessFile(dir.toFile(),"rw")) {
            raf.writeInt(1);
            raf.writeInt(15);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    public void ej3(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    public void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

    public void ej5(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 5 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 5 -----\n");
    }

    public void ej6(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 6 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 6 -----\n");
    }
    
}
