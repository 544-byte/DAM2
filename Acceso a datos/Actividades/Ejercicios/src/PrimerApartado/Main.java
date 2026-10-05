package PrimerApartado;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
        ej4("Directorio/Directorio1.3");
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

}
