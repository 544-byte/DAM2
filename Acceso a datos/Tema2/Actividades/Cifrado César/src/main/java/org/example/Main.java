package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

    }

    private static void lodeconexion(){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba01_mysql", "root", "123456");
            conexion.setAutoCommit(false);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static ArrayList<String> cifrarMensaje(ArrayList<String> mensaje){
        final String abecedario = "abcdefghijklmnopqrstuvwxyz"
    }

    private static ArrayList<String> leerArchivo(String ruta){
        Path dir = Paths.get(ruta);
        try (BufferedReader br = Files.newBufferedReader(dir)) {
            List<String> lineas = br.readAllLines();
            if (!esLegible(lineas)){
                System.out.println("El archivo introducido no es legible");
            } else {
                ArrayList<String> output = new ArrayList<>();
                for (String linea : lineas){
                    String desp = linea.split(";")[0];
                    String texto = linea.split(";")[1];
                    texto = texto.replace('á','a')
                            .replace('é','e')
                            .replace('í','i')
                            .replace('ó','o')
                            .replace('ú','u');
                    output.add(desp+";"+texto);
                }
                return output;
            }
        } catch (Exception e){
            return new ArrayList<String>();
        }
        return new ArrayList<String>();
    }

    private static boolean esLegible(List<String> lineas){
        for (String linea : lineas){
            if ((Integer.parseInt(linea.split(";")[0]) < 1) || (Integer.parseInt(linea.split(";")[0]) > 25)){
                return false;
            } else {
                return true;
            }
        }
        System.out.println("Algo no ha ido bien");
        return false;
    }
}
