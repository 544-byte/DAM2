package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        
        List<ArrayList> mensajeCompleto = prepararMensaje("src/main/resources/msSg.csv");
        if (!mensajeCompleto.isEmpty()) {
            lodeconexion(mensajeCompleto.get(0), mensajeCompleto.get(1), mensajeCompleto.get(2));
        } else {
            System.out.println("El mensaje no está en un formato correcto.");
        }
    }

    private static void lodeconexion(ArrayList<Integer>desplazamiento,ArrayList<String>mensaje,ArrayList<String>mensajeCifrado){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba01_mysql", "root", "123456");
            conexion.setAutoCommit(false);
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate("drop table if exists mensajes_cesar");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS mensajes_cesar (" +
                    "desplazamiento INT NOT NULL," +
                    "texto_normal VARCHAR(1000) NOT NULL," +
                    "texto_cifrado VARCHAR(1000) NOT NULL" +
                    ");");

            PreparedStatement ps = conexion.prepareStatement("insert into mensajes_cesar values (?,?,?)");
            int i;
            for (i = 0 ; i < desplazamiento.size(); i++){
                ps.setInt(1,desplazamiento.get(i));
                ps.setString(2, mensaje.get(i));
                ps.setString(3, mensajeCifrado.get(i));
                ps.addBatch();
            }
            ps.executeBatch();
            conexion.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static ArrayList<String> cifrarMensaje(ArrayList<Integer> desplazamientos,ArrayList<String> mensajes){
        final String abecedario = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789 ";
        ArrayList<String> mensajeCifrado = new ArrayList<>();
        int i;
        for (i = 0 ; i < desplazamientos.size() ; i++){
            int desplazamiento = desplazamientos.get(i);
            String texto = mensajes.get(i);
            String lineaCifrada = "";
            for (char c : texto.toCharArray()){
                if (abecedario.indexOf(c) != -1) {
                    lineaCifrada += abecedario.charAt((abecedario.indexOf(c) + desplazamiento) % abecedario.length());
                } else {
                    lineaCifrada += c;
                }
            }
            mensajeCifrado.add(lineaCifrada);
        }
        return mensajeCifrado;
    }

    private static List<ArrayList> prepararMensaje(String archivo){
        ArrayList<String> texto = leerArchivo(archivo);
        if (!texto.isEmpty()) {
            ArrayList<Integer> desplazamientos = new ArrayList<>();
            ArrayList<String> mensajes = new ArrayList<>();
            for (String linea : texto) {
                int desplazamiento = Integer.valueOf(linea.split(";")[0]);
                if (desplazamiento < 1 || desplazamiento > 25) continue;

                String mensaje = linea.split(";")[1];
                int longitud = mensaje.length();
                if (longitud < 1 || longitud > 1000) continue;
                desplazamientos.add(desplazamiento);
                mensajes.add(mensaje);
            }
            return List.of(desplazamientos, mensajes, cifrarMensaje(desplazamientos,mensajes));
        } else {
            return List.of();
        }
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
        } catch (NoSuchFileException e){
            System.out.println("El archivo no existe.");
        }
        catch (Exception e){
            System.err.println(e);
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    private static boolean esLegible(List<String> lineas){
        for (String linea : lineas) {
            if (linea.split(";").length != 2) return false;
        }
        return true;
    }
}
