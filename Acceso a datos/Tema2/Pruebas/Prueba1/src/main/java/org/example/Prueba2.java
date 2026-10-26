package org.example;

import java.io.*;
import java.nio.file.Path;
import java.sql.*;

public class Prueba2 {
    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba01_mysql", "root", "123456");
    Statement stmt = conexion.createStatement();

    public Prueba2() throws SQLException {
    }

    void main() {
        try {
            String sql;
            stmt.executeUpdate("DROP TABLE if exists banco");
            stmt.executeUpdate("CREATE TABLE banco (id INT PRIMARY KEY, saldo INT)");

            //stmt.executeUpdate("insert into alumno values (1,'Pedro'),(2,'Mario')");
            PreparedStatement ps = conexion.prepareStatement("insert into banco values (?,?)");
            File datos = new File("src/main/java/org/example/banco.csv");
            try (
                    BufferedReader br = new BufferedReader(new FileReader(datos))
            ) {
                for (String linea : br.readAllLines()) {
                    ps.setInt(1, Integer.parseInt(linea.split(",")[0]));
                    ps.setString(2, linea.split(",")[1]);
                    ps.addBatch();
                }
                ps.executeBatch();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            ResultSet rs = stmt.executeQuery("select * from banco");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("saldo")
                );
            }

            rs.close();

            transferencia(1,2,100);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void transferencia(int id1, int id2, int saldo) {
        try {
            PreparedStatement consultarDinero = conexion.prepareStatement("select saldo from banco where id = ?");
            consultarDinero.setInt(1,1);
            ResultSet saldoTotal = consultarDinero.executeQuery();
            saldoTotal.next();
            if ((saldoTotal.getInt(1) - saldo) < 0){
                System.out.println("no hay lana");
            }
            else
            {
                PreparedStatement restar =
                        conexion.prepareStatement("UPDATE banco " +
                                "SET saldo = saldo - ? " +
                                "WHERE id = ?");
                PreparedStatement sumar =
                        conexion.prepareStatement("UPDATE banco " +
                                "SET saldo = saldo + ? " +
                                "WHERE id = ?");
                try {
                    conexion.setAutoCommit(false);
                    conexion.setAutoCommit(false);
                    restar.setDouble(1, 100);
                    restar.setInt(2, 1);
                    restar.executeUpdate();
                    sumar.setDouble(1, 100);
                    sumar.setInt(2, 2);
                    sumar.executeUpdate();
                    conexion.commit();
                } catch (SQLException e) {
                    conexion.rollback();
                    throw e;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}