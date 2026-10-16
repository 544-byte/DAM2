package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba01_mysql","root","123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
