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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.UsersController;
import models.User;
import models.UsersModel;

public class UsersView {

	public UsersView() {
		
	}
	
	
	public void index(List usuarios)
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
		
		
		String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono","Create_At"};
	    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	    JTable tabla = new JTable(modelo);

	    for (Object user : usuarios) {
	        User usuario = (User) user;
	        Object[] fila = {
	            usuario.id,
	            usuario.name,
	            usuario.email,
	            usuario.role,
	            usuario.phone
	        };
	        modelo.addRow(fila);
	    }

	    JScrollPane scrollpane = new JScrollPane(tabla);
	    scrollpane.setBounds(50, 80, 800, 300); 	    panel.add(scrollpane);

	   
	    int y = 400;
	    for (Object obj : usuarios) {
	        User usuario = (User) obj;

	        JButton delete = new JButton("Eliminar ");
	        delete.setBounds(50, y, 200, 30);
	        delete.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                UsersModel um = new UsersModel();
	                um.remove(usuario.id);
	                ventana.dispose();
	                UsersController us = new UsersController();
	                us.index();
	            }
	        });
	        panel.add(delete);
	        
	    }
		
		 
		
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	



}
