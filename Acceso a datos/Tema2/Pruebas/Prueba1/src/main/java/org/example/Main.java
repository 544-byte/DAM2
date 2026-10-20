package org.example;

import java.io.*;
import java.nio.file.Path;
import java.sql.*;

public class Main {
    static void main() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba01_mysql","root","123456");
            //borrar tabla, crear la db dinamicamente, insertar 2 o 3 elementos
            Statement stmt = conexion.createStatement();
            String sql;
            stmt.executeUpdate("DROP TABLE if exists alumno");
            stmt.executeUpdate("CREATE TABLE alumno (id INT PRIMARY KEY, nombre VARCHAR (100))");

            //stmt.executeUpdate("insert into alumno values (1,'Pedro'),(2,'Mario')");
            PreparedStatement ps = conexion.prepareStatement("insert into alumno values (?,?)");
            File datos = new File("src/main/java/org/example/datos.csv");
            try (
                BufferedReader br = new BufferedReader(new FileReader(datos))
            ){
                for (String linea : br.readAllLines()){
                    ps.setInt(1, Integer.parseInt(linea.split(",")[0]));
                    ps.setString(2,linea.split(",")[1]);
                    ps.addBatch();
                }
                ps.executeBatch();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            ResultSet rs = stmt.executeQuery("select * from alumno");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("nombre")
                );
            }

            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
