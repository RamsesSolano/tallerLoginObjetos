package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgres {

    private static final String URL = "jdbc:postgresql://138.68.237.102:5432/login_java_prueba";
    private static final String USERNAME = "miusuario";
    private static final String PASSWORD = "mitokenSeguro";

    public static Connection Connection() {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión exitosa a PostgreSQL!");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de PostgreSQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;

    }

}