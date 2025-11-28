package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserConnection {
    
    private Connection connection;

    public UserConnection() {
        this.connection = ConnectionPostgres.Connection();
    }

    public UserDAO getAllUsers(){

         String sql = "SELECT * FROM usuarios";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDAO user = new UserDAO();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setLastName(rs.getString("apellido"));
                user.setPassword(rs.getString("password"));
                user.setTypeLevel(rs.getString("tipo_nivel"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error en buscarPorNombre: " + e.getMessage());
        }
        return null;

    }

    public UserDAO getUserByName(String name) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDAO user = new UserDAO();
                System.out.println("Encontrado usuario: " + name);
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setLastName(rs.getString("apellido"));
                user.setPassword(rs.getString("clave"));
                user.setTypeLevel(rs.getString("tipo_nivel"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error en getUserByName: " + e.getMessage());
        }
        return null;
    }
    

    public UserDAO getUserByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDAO user = new UserDAO();
                System.out.println("Encontrado usuario con email: " + email);
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setLastName(rs.getString("apellido"));
                user.setPassword(rs.getString("clave"));
                user.setTypeLevel(rs.getString("tipo_nivel"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error en getUserByEmail: " + e.getMessage());
        }
        return null;
    }

    public UserDAO addUser(UserDAO user) {
        String sql = "INSERT INTO usuarios (nombre, apellido, email, clave, tipo_nivel) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(4, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(5, user.getTypeLevel());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            return user;
        } catch (SQLException e) {
            System.out.println("Error en addUser: " + e.getMessage());
        }
        return null;
    }

}
