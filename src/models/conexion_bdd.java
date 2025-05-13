package models;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class conexion_bdd {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/world?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    private Connection connection;
    
    static {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver MySQL cargado correctamente");
        } catch (ClassNotFoundException e) {
            mostrarError("Error al cargar el driver: " + e.getMessage());
            throw new RuntimeException("No se pudo cargar el driver JDBC", e);
        }
    }
    
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    
    public void mostrarUsuarios() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Email");
        model.addColumn("Rol");
        model.addColumn("Teléfono");
        model.addColumn("Creado en");
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getString("phone"),
                    rs.getTimestamp("create_at")
                });
            }
            
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            
            JFrame frame = new JFrame("Lista de Usuarios");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.pack();
            frame.setSize(900, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
        } catch (SQLException e) {
            mostrarError("Error al obtener usuarios: " + e.getMessage());
        }
    }
    
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            mostrarError("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    private static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, 
            mensaje, 
            "Error de Base de Datos", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            conexion_bdd db = new conexion_bdd();
            try {
                db.mostrarUsuarios();
            } finally {
                db.close();
            }
        });
    }
}