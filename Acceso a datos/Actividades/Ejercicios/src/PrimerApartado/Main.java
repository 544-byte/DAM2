package PrimerApartado;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
public class Main {
    void main() throws IOException {
        ej1("Directorio");
        ej2("Directorio");
        ej3();
        ej4("Directorio/Directorio 1.3/Directorio 1.3.1/");
        ej5("Directorio/Directorio 1.2");
    }

    public void ej1(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        listarContenidoRecursivo(dir,0);
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    public void listarContenidoRecursivo(Path p,int t){
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

    public void ej2(String ruta) {
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

    public void ej3(){
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

    public void ej4(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 4 ----");
        Path dir = Paths.get(ruta);
        try {
            System.out.println(Files.createDirectories(dir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 4 -----\n");
    }

    public void ej5(String ruta){
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

    public void eliminarContenidoRecursivo(Path p){
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



}
