package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.UsersController;
import models.User;
import models.UsersModel;

public class UsersView {

	public UsersView() {
		
	}
	
	
	public void index(List usuarios) {
	    JFrame ventana = new JFrame();
	    ventana.setVisible(true);
	    ventana.setSize(930, 600);
	    ventana.setLocationRelativeTo(null); 
	    ventana.setTitle("Gestión de Usuarios"); 
	    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    ventana.setResizable(true);  

	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 255, 255));
	    panel.setLayout(null);
	    panel.setSize(1000, 600); 

	    JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
	    lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
	    lblNewLabel.setBounds(107, 35, 210, 26);
	    lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
	    panel.add(lblNewLabel);

	    String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono", "Create_At"};
	    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	    JTable tabla = new JTable(modelo);

	    for (Object user : usuarios) {
	        User usuario = (User) user;
	        Object[] fila = {usuario.id, usuario.name, usuario.email, usuario.role, usuario.phone, usuario.create_at};
	        modelo.addRow(fila);
	    }

	    JScrollPane scrollpane = new JScrollPane(tabla);
	    scrollpane.setBounds(50, 80, 800, 300);
	    panel.add(scrollpane);

	    JButton btnAgregar = new JButton("Agregar Usuario");
	    btnAgregar.setBounds(50, 400, 200, 30);
	    btnAgregar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            agregarUsuario(ventana);
	        }
	    });
	    panel.add(btnAgregar);

	    int y = 450;
	    for (Object obj : usuarios) {
	        User usuario = (User) obj;
	       
	        JButton delete = new JButton("Eliminar " + usuario.id);
	        delete.setBounds(50, y, 100, 30);
	        delete.addActionListener(e -> {
	            UsersModel um = new UsersModel();
	            um.remove(usuario.id);
	            ventana.dispose();
	            new UsersController().index();
	        });
	        panel.add(delete);
	        
	        JButton edit = new JButton("Editar " + usuario.id);
	        edit.setBounds(160, y, 100, 30);
	        edit.addActionListener(e -> editarUsuario(ventana, usuario));
	        panel.add(edit);
	        
	        y += 40;
	    }

	    ventana.add(panel);
	    ventana.repaint();
	    ventana.revalidate();
	}

	private void agregarUsuario(JFrame parentFrame) {
	    JFrame formulario = new JFrame("Agregar Usuario");
	    formulario.setSize(400, 400);
	    formulario.setLocationRelativeTo(parentFrame);
	    formulario.setLayout(null);

	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setBounds(0, 0, 400, 400);

	    JLabel lblNombre = new JLabel("Nombre:");
	    lblNombre.setBounds(20, 20, 100, 25);
	    JTextField txtNombre = new JTextField();
	    txtNombre.setBounds(130, 20, 200, 25);

	    JLabel lblEmail = new JLabel("Email:");
	    lblEmail.setBounds(20, 60, 100, 25);
	    JTextField txtEmail = new JTextField();
	    txtEmail.setBounds(130, 60, 200, 25);

	    JLabel lblRol = new JLabel("Rol:");
	    lblRol.setBounds(20, 100, 100, 25);
	    JTextField txtRol = new JTextField();
	    txtRol.setBounds(130, 100, 200, 25);

	    JLabel lblTelefono = new JLabel("Teléfono:");
	    lblTelefono.setBounds(20, 140, 100, 25);
	    JTextField txtTelefono = new JTextField();
	    txtTelefono.setBounds(130, 140, 200, 25);

	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setBounds(150, 200, 100, 30);
	    btnGuardar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String nombre = txtNombre.getText();
	            String email = txtEmail.getText();
	            String rol = txtRol.getText();
	            String telefono = txtTelefono.getText();

	            UsersModel um = new UsersModel();
	            boolean exito = um.insert(nombre, email, rol, telefono);

	            if (exito) {
	                JOptionPane.showMessageDialog(formulario, "Usuario agregado correctamente");
	                formulario.dispose();
	                parentFrame.dispose();
	                new UsersController().index();
	            } else {
	                JOptionPane.showMessageDialog(formulario, "Error al agregar usuario", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    panel.add(lblNombre);
	    panel.add(txtNombre);
	    panel.add(lblEmail);
	    panel.add(txtEmail);
	    panel.add(lblRol);
	    panel.add(txtRol);
	    panel.add(lblTelefono);
	    panel.add(txtTelefono);
	    panel.add(btnGuardar);

	    formulario.add(panel);
	    formulario.setVisible(true);
	}
	
	private void editarUsuario(JFrame parentFrame, User usuario) {
	    JFrame formulario = new JFrame("Editar Usuario");
	    formulario.setSize(400, 400);
	    formulario.setLocationRelativeTo(parentFrame);
	    formulario.setLayout(null);

	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setBounds(0, 0, 400, 400);

	    JTextField txtNombre = new JTextField(usuario.name);
	    txtNombre.setBounds(130, 20, 200, 25);

	    JTextField txtEmail = new JTextField(usuario.email);
	    txtEmail.setBounds(130, 60, 200, 25);

	    JTextField txtRol = new JTextField(usuario.role);
	    txtRol.setBounds(130, 100, 200, 25);

	    JTextField txtTelefono = new JTextField(usuario.phone);
	    txtTelefono.setBounds(130, 140, 200, 25);

	    JButton btnGuardar = new JButton("Guardar Cambios");
	    btnGuardar.setBounds(150, 200, 150, 30);
	    btnGuardar.addActionListener(e -> {
	        String nombre = txtNombre.getText();
	        String email = txtEmail.getText();
	        String rol = txtRol.getText();
	        String telefono = txtTelefono.getText();

	        UsersModel um = new UsersModel();
	        boolean exito = um.update(usuario.id, nombre, email, rol, telefono); // UPDATE

	        if (exito) {
	            JOptionPane.showMessageDialog(formulario, "Usuario actualizado");
	            formulario.dispose();
	            parentFrame.dispose();
	            new UsersController().index();
	        }
	    });
	    panel.add(new JLabel("Nombre:")).setBounds(20, 20, 100, 25);
	    panel.add(txtNombre);
	    formulario.add(btnGuardar);
	    formulario.add(panel);
	    formulario.setVisible(true);
	}
	



}
