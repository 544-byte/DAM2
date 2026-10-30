package Apartado1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
    /** Cabecera de clase del apartado 1: ejercicios de manejo de ficheros y directorios con {@link java.io.File} y {@link java.nio.file.Files}. */
public class Main {
    /** Punto de entrada del apartado 1. Ejecuta los ejercicios 1 al 7 sobre el directorio de trabajo.
     *
     * @throws IOException si falla alguna operación de ficheros implicada
     */
    public static void main() throws IOException {
        System.out.println("----- COMIENZO PAQUETE 1 -----");
        ej1("Directorio");
        ej2("Directorio");
        ej3();
        ej4("Directorio/Directorio 1.3/Directorio 1.3.1/");
        ej5("Directorio/Directorio 1.2");
        ej6("Directorio/Directorio 1.1","Directorio/Directorio 1.1 Copia","txt");
        ej7("Directorio");
        System.out.println("------ FIN DE PAQUETE 1 ------\n\n\n");
    }

    /**
     * Ejercicio 1: lista recursivamente el contenido de un directorio
     * con sangría (tabuladores) según la profundidad.
     *
     * @param ruta ruta del directorio a listar
     */
    public static void ej1(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        listarContenidoRecursivo(dir,0);
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    /**
     * Lista de forma recursiva el contenido de una ruta.
     *
     * @param p ruta actual (directorio) que se está recorriendo
     * @param t nivel de profundidad actual; se usa para tabular la salida
     */
    public static void listarContenidoRecursivo(Path p,int t){
        File dir = new File(String.valueOf(p));
        if (dir.isDirectory()) {
            String[] archivos = dir.list();
            for (String archivo : archivos) {
                Path newP = Paths.get(p.toString() + "/" + archivo);
                String tabulacion = "";
                for (int i = 0; i < t ; i++){
                    tabulacion = tabulacion.concat("\t");
                }
                System.out.println(tabulacion + archivo);
                listarContenidoRecursivo(newP,t+1);
            }
        }
    }

    /**
     * Ejercicio 2: muestra por pantalla los ficheros con extensión {@code .txt}
     * de un directorio junto con su fecha de última modificación.
     *
     * @param ruta ruta del directorio donde buscar los ficheros .txt
     */
    public static void ej2(String ruta) {
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        File dir = new File(ruta);
        if (dir.isDirectory()) {
            String[] archivos = dir.list();
            try {
                for (String archivo: archivos) {
                    if (archivo.endsWith(".txt")) {
                        System.out.println(archivo + " - " + Files.getLastModifiedTime((new File(ruta + "/" + archivo)).toPath()));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    /**
     * Ejercicio 3: pide una ruta por teclado e indica si existe y
     * si se trata de un archivo o de un directorio.
     */
    public static void ej3(){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        System.out.printf("Introduce la ruta: ");
        String ruta = new Scanner(System.in).nextLine();
        Path dir = Paths.get(ruta);
        if (!Files.exists(dir)){
            System.out.println("El archivo no existe");
        } else {
            String tipo ="";
            if (Files.isDirectory(dir)) {
                tipo = "directorio";
            }
            else {
                tipo = "archivo";
            }
            System.out.println("El archivo es un " + tipo);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

    /**
     * Ejercicio 4: crea un árbol de directorios con {@link Files#createDirectories},
     * incluyendo los directorios intermedios que falten.
     *
     * @param ruta ruta completa del directorio a crear
     */
    public static void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        try {
            System.out.println(Files.createDirectories(dir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

    /**
     * Ejercicio 5: crea un fichero con fecha de modificación antigua (999 días atrás)
     * y elimina recursivamente todos los ficheros del directorio dado con más de 7 días de antigüedad.
     *
     * @param ruta ruta del directorio en el que se procesan los ficheros antiguos
     */
    public static void ej5(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 5 ----");
        try {
            Path archivoAntiguo = Path.of("Directorio/Directorio 1.2/Directorio 1.2.1/Archivo Antigüo");
            Files.createFile(archivoAntiguo);
            Files.setLastModifiedTime(archivoAntiguo, FileTime.from(Instant.now().minus(999,ChronoUnit.DAYS)));
            System.out.println("Archivo antiguo creado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path dir = Paths.get(ruta);
        eliminarContenidoRecursivo(dir);
        System.out.println("----- FIN DE EJERCICIO 5 -----\n");
    }

    /**
     * Recorre recursivamente una ruta y elimina los ficheros cuya fecha de
     * última modificación sea anterior a 7 días. Los subdirectorios se recorren
     * pero, si quedan vacíos, no se eliminan.
     *
     * @param p ruta actual que se está recorriendo
     */
    public static void eliminarContenidoRecursivo(Path p){
        File dir = new File(String.valueOf(p));
        if (dir.isDirectory()) {
            String[] archivos = dir.list();
            for (String archivo : archivos) {
                Path newP = Paths.get(p.toString() + "/" + archivo);
                System.out.println("Comprobando "+ archivo);
                eliminarContenidoRecursivo(newP);
            }
        } else if (dir.isFile()){
            try {
                if (Files.getLastModifiedTime(p).toInstant().isBefore(Instant.now().minus(7, ChronoUnit.DAYS))) {
                    dir.delete();
                    System.out.println("Se ha eliminado el archivo " + dir.getAbsolutePath());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Ejercicio 6: copia en un directorio destino todos los ficheros de otro
     * directorio que tengan una extensión dada. Antes de copiar restaura el
     * estado original de los ficheros mediante {@link Util.RestaurarArchivos}.
     *
     * @param ruta1 directorio origen del que se copian los ficheros
     * @param ruta2 directorio destino donde se copian
     * @param type  extensión de los ficheros a copiar (sin punto), por ejemplo {@code "txt"}
     */
    public static void ej6(String ruta1, String ruta2, String type){
        System.out.println("---- COMIENZO EJERCICIO 6 ----");
        Util.RestaurarArchivos.restaurarBackup();
        Path dir1 = Paths.get(ruta1);
        Path dir2 = Paths.get(ruta2);
        try {
            for (Path archivo : Files.list(dir1).toList()){
                if (archivo. toString().endsWith("." + type)){
                    Files.copy(archivo,dir2.resolve(archivo.getFileName()));
                    System.out.println("Copiado el archivo " + archivo.getFileName() + " en " + dir2);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 6 -----\n");
    }

    /**
     * Ejercicio 7: recorre los ficheros (no directorios) del directorio dado
     * y muestra su nombre y tamaño aproximado en MB.
     *
     * @param ruta ruta del directorio cuyo contenido se mide
     */
    public static void ej7(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 7 ----");
        Path dir1 = Paths.get(ruta);
        try {
            for (Path archivo : Files.list(dir1).toList()){
                if (!Files.isDirectory(archivo)){
                    System.out.println(archivo.getFileName() + " · " + Files.size(archivo)/2048 + "MB");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 7 -----\n");
    }
}
