package Apartado2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Apartado 2: ejercicios de lectura de ficheros de texto y ficheros de
 * acceso aleatorio (binarios) con {@link RandomAccessFile}.
 */
public class Main {
    /** Punto de entrada del apartado 2. Ejecuta los ejercicios 1 al 3. */
    public static void main(){
        System.out.println("----- COMIENZO PAQUETE 2 -----");
        ej1("Directorio/Directorio 1.1/Archivo 1.1.1.txt","java");
        ej2("Directorio/Apartado2/Registro.dat");
        ej3("Directorio/Apartado2/Registro.dat",1,67);
        System.out.println("------- FIN PAQUETE 2 -------\n\n\n");
    }

    /**
     * Ejercicio 1: cuenta en cuántas líneas de un fichero de texto aparece
     * una palabra clave dada.
     *
     * @param ruta  ruta del fichero de texto a examinar
     * @param clave palabra clave que se busca en cada línea
     */
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

    /**
     * Ejercicio 2: escribe una lista de {@link Registro} en un fichero binario
     * de acceso aleatorio (dos {@code int} por registro: id y número).
     *
     * @param ruta ruta del fichero binario de destino
     */
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

    /**
     * Escribe una lista de registros en un fichero de acceso aleatorio y
     * después muestra su contenido completo por pantalla.
     *
     * @param rList lista de registros que se van a escribir
     * @param dir   ruta del fichero binario de destino
     */
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

    /**
     * Lee un fichero binario de acceso aleatorio y muestra por pantalla
     * los enteros que contiene hasta llegar al final del fichero.
     *
     * @param ruta ruta del fichero binario a leer
     */
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

    /**
     * Lee un fichero binario de acceso aleatorio y muestra por pantalla
     * los enteros que contiene hasta llegar al final del fichero.
     *
     * @param dir ruta del fichero binario a leer
     */
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

    /**
     * Ejercicio 3: modifica el número de un registro concreto del fichero
     * binario de acceso aleatorio. Cada registro ocupa 8 bytes (id + número),
     * por lo que se salta {@code (id * 8) - 4} bytes para situarse sobre el número.
     *
     * @param ruta ruta del fichero binario
     * @param id   identificador del registro a modificar (el primer registro es 1)
     * @param num  nuevo valor del número del registro
     */
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

    /**
     * Ejercicio 4 del apartado 2 (pendiente de implementar).
     *
     * @param ruta ruta del fichero a procesar
     */
    public static void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

    /**
     * Ejercicio 5 del apartado 2 (pendiente de implementar).
     *
     * @param ruta ruta del fichero a procesar
     */
    public static void ej5(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 5 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 5 -----\n");
    }

    /**
     * Ejercicio 6 del apartado 2 (pendiente de implementar).
     *
     * @param ruta ruta del fichero a procesar
     */
    public static void ej6(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 6 ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO 6 -----\n");
    }
    
}
