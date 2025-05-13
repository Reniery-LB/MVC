package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthModel {
    private Connection conn;
    
    public AuthModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean login(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registrarUsuario(String nombre, String email, String usuario, String password, String empresa) {
        String query = "INSERT INTO users (name, email, username, password, company) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, usuario);
            stmt.setString(4, password);
            stmt.setString(5, empresa);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, name, email, username, company FROM users";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("company")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    public void close() {
        try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}