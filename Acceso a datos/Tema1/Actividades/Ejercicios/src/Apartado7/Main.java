package Apartado7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Path dir;
    public static void main() {
        interfaz();
    }

    private static void interfaz(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al programa.");
        System.out.println("Debes seleccionar un archivo y despues elegir si quieres leer o escribir en el.");
        System.out.printf("Selecciona un archivo: ");
        dir = Paths.get(scan.nextLine());
        if (dir.toFile().exists()){
            System.out.println("Archivo " + dir.getFileName() + " seleccionado correctamente.");
            leerOescribir();
        } else {
            System.out.println("\u001B[31mEl archivo seleccionado no existe.\u001B[0m");
            creadorArchivo();
        }


    }

    private static void leer(){
        if (dir.toFile().isFile()){
            try(BufferedReader br = Files.newBufferedReader(dir)) {
                String linea;
                System.out.println("-------- Inicio Fichero --------");
                while ((linea = br.readLine()) != null){
                    System.out.println(linea);
                }
                System.out.println("------- Final de Fichero -------");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (dir.toFile().isDirectory()) {
            listarContenidoRecursivo(dir,0);
        }
    }

    private static void listarContenidoRecursivo(Path p,int t){
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

    private static void escribir(){
        if (dir.toFile().isFile()){
            System.out.println("Para escribir simplemente escribe una línea y presiona enter.");
            System.out.println("Para dejar de escribir, escribe /salir");
            ArrayList<String> lineas = new ArrayList<>();
            String linea = "";
            Scanner scan = new Scanner(System.in);
            do {
                linea = scan.nextLine();
                if (!linea.equals("/salir")) lineas.add(linea);
            } while (!linea.equals("/salir"));
            try(BufferedWriter bw = Files.newBufferedWriter(dir)) {
                for (String s : lineas) {
                    bw.write(s);
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (dir.toFile().isDirectory()) {
            System.out.println(dir.getFileName() + " es un directorio.");
            System.out.println("¿Desea crear un archivo y escribir en este?");
            Scanner scan = new Scanner(System.in);
            char opt = ' ';
            do {
                System.out.printf("¿Desea crearlo? s/n: ");
                try {
                    opt = scan.nextLine().toLowerCase().toCharArray()[0];
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                if (opt != 'n' && opt != 's') {
                    System.out.println("\u001B[31mOpción no válida.\u001B[0m");
                }
            } while (opt != 'n' && opt != 's');
            switch (opt){
                case 's' -> {
                    String nombreArchivo = "";
                    do {
                        System.out.printf("Pongale un nombre al archivo: ");
                        nombreArchivo = scan.nextLine();
                        if (Files.exists(Path.of(dir.toFile().getAbsolutePath().concat("/" + nombreArchivo)))) {
                            System.out.println("\u001B[31mEl archivo ya existe, seleccione otro nombre.\u001B[0m");
                        } else {
                            dir = Path.of(dir.toFile().getAbsolutePath().concat("/" + nombreArchivo));
                            try {
                                dir.toFile().createNewFile();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            escribir();
                        }
                    } while (Files.exists(Path.of(dir.toFile().getAbsolutePath().concat("/" + nombreArchivo))));
                }
                case 'n' -> {
                    System.out.println("De acuerdo, ¡vuelva pronto!");
                }
            }
        }
    }

    private static void leerOescribir(){
        char opt = ' ';
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("¿Desea leer o escribir? l/e/n: ");

            try {
                opt = scan.nextLine().toLowerCase().toCharArray()[0];
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (opt != 'l' && opt != 'e' && opt != 'n') {
                System.out.println("\u001B[31mOpción no válida.\u001B[0m");
            }
        } while (opt != 'l' && opt != 'e' && opt != 'n');
        switch (opt){
            case 'l' -> {
                leer();
            }
            case 'e' -> {
                escribir();
            }
            case 'n' -> {
                System.out.println("De acuerdo, ¡vuelva pronto!");
            }
            default -> {
                System.out.println("Opción no válida");
            }
        }
    }

    private static void creadorArchivo(){
        char opt = ' ';
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("¿Desea crearlo? s/n: ");
            try {
                opt = scan.nextLine().toLowerCase().toCharArray()[0];
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            if (opt != 'n' && opt != 's') {
                System.out.println("\u001B[31mOpción no válida.\u001B[0m");
            }
        } while (opt != 'n' && opt != 's');
        switch (opt){
            case 's' -> {
                do {
                    System.out.printf("¿Desea crear archivo o directorio? a/d: ");
                    try {
                        opt = scan.nextLine().toLowerCase().toCharArray()[0];
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    if (opt != 'a' && opt != 'd') {
                        System.out.println("\u001B[31mOpción no válida.\u001B[0m");
                    }
                } while (opt != 'a' && opt != 'd');
                switch (opt){
                    case 'a' -> {
                        try {
                            dir.toFile().createNewFile();
                            System.out.println("Archivo " + dir.getFileName() + " creado correctamente.");

                        } catch (IOException e) {
                            System.out.println("\u001B[31mEl archivo " + dir.getFileName() + " no se ha podido crear correctamente. Error: " + e.getMessage() +"\u001B[0m");
                        }
                    }
                    case 'd' -> {
                        if (dir.toFile().mkdir()){
                            System.out.println("Directorio " + dir.getFileName() + " creado correctamente.");
                        } else {
                            System.out.println("\u001B[31mNo se ha podido crear el directorio " + dir.getFileName() + ".\u001B[0m");
                        }
                    }
                    default -> {
                        System.out.println("Opción no válida");
                    }
                }

            }
            case 'n' -> {
                System.out.println("De acuerdo, ¡vuelva pronto!");
            }
            default -> {
                System.out.println("Opción no válida");
            }
        }
    }

}
