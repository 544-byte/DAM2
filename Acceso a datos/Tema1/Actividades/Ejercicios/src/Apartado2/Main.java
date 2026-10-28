package Apartado2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(){
        System.out.println("----- COMIENZO PAQUETE 2 -----");
        ej1("Directorio/Directorio 1.1/Archivo 1.1.1.txt","java");
        ej2("Directorio/Apartado2/Registro.dat");
        ej3("Directorio/Apartado2/Registro.dat",1,67);
        System.out.println("------- FIN PAQUETE 2 -------\n\n\n");
    }

    public static void ej1(String ruta, String clave){
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

    public static void ej2(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        Path dir = Paths.get(ruta);
        List<Registro> rList = List.of(
                new Registro(1,2),
                new Registro(2,3),
                new Registro(3,4),
                new Registro(4,5),
                new Registro(5,6)
        );
        writeRecords(rList,dir);

        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    private static void writeRecords(List<Registro> rList, Path dir){
        try (RandomAccessFile raf = new RandomAccessFile(dir.toFile(),"rw")) {
            for (Registro r : rList) {
                raf.writeInt(r.id());
                raf.writeInt(r.numero());
                System.out.println("se ha escrito el registro " + r.toString());
            }
            System.out.println("fichero completo:");
            leerFichero(dir);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerFichero(String ruta){
        Path dir = Paths.get(ruta);
        try(RandomAccessFile raf = new RandomAccessFile(dir.toFile(),"r")) {
            while (true){
                System.out.println(raf.readInt());
            }
        } catch (EOFException e) {
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerFichero(Path dir){
        try(RandomAccessFile raf = new RandomAccessFile(dir.toFile(),"r")) {
            while (true){
                System.out.println(raf.readInt());
            }
        } catch (EOFException e) {
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void ej3(String ruta,int id, int num){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        Path dir = Paths.get(ruta);
        try (RandomAccessFile raf = new RandomAccessFile(dir.toFile(),"rw")) {
            raf.skipBytes((id*8)-4);
            raf.writeInt(num);
            System.out.println("Se ha modificado el registro " + id + " cambiando su numero a " + num);
            leerFichero(ruta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    public static void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

    public static void ej5(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 5 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 5 -----\n");
    }

    public static void ej6(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 6 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 6 -----\n");
    }
    
}
