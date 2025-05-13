package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controllers.UsersController;
import models.AuthModel;

public class HomeView {
	
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/world?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection connection;
    
	public HomeView() {
	}
	
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    
    private static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, 
            mensaje, 
            "Error de Base de Datos", 
            JOptionPane.ERROR_MESSAGE);
    }
    
	public void home()
	{
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Login"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		//this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		
		JButton btnNewButton2 = new JButton("Usuarios");
		btnNewButton2.setBackground(new Color(0, 0, 0));
		btnNewButton2.setOpaque(true);
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBounds(205, 190, 200, 200);
		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ventana.dispose(); 
				
				UsersController uc = new UsersController();
				uc.index();
				
				//e.getSource().
				 
				
			}});
		panel.add(btnNewButton2);
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

		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
}
