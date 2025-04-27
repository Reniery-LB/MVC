package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AuthView{
	
	public AuthView() {
	}
	
	public void login() {
		JFrame ventana = new JFrame();
		
		ventana.setTitle("DISEÑO");
		ventana.setVisible(true);
		ventana.setSize(1000,1000);
		ventana.setLayout(null);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mipanel = new JPanel();
		Font fuente = new Font("Britannic",Font.BOLD,16);
		
		mipanel.setBackground(Color.decode("#EFF3EA"));
		mipanel.setOpaque(true);
		mipanel.setSize(1000,1000);
		mipanel.setLocation(0,0);
		mipanel.setLayout(null); //QUITA EL MOLDE
		
		mipanel.setPreferredSize(new Dimension(500,800));
		//-----------------------------
		//TITULO
		JLabel titulo = new JLabel("ACCEDER");
		titulo.setSize(200, 30);
		titulo.setOpaque(true);
		titulo.setBackground(Color.decode("#D9DFC6")); 
		titulo.setLocation(165, 64);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Britannic",Font.BOLD,24));
		
		mipanel.add(titulo);
		//-------------------
		//NOMBRE
		JLabel nombreLabel = new JLabel("Nombre de Usuario");
		nombreLabel.setSize(150, 30);
		nombreLabel.setOpaque(true);
		nombreLabel.setBackground(Color.decode("#F9F6E6")); 
		nombreLabel.setLocation(110, 144);
		nombreLabel.setFont(fuente);
		
		mipanel.add(nombreLabel);
		
		JTextField nombreField = new JTextField();
		nombreField.setSize(300, 30);
		nombreField.setLocation(110, 184);
		nombreField.setFont(fuente);
		
		mipanel.add(nombreField);
		//-----------------------
		//CONTRASEÑA
		
		JLabel contraLabel = new JLabel("Contraseña");
		contraLabel.setSize(150, 30);
		contraLabel.setOpaque(true);  
		contraLabel.setBackground(Color.decode("#F9F6E6")); 
		contraLabel.setLocation(110, 234);
		contraLabel.setFont(fuente);
		
		mipanel.add(contraLabel);	
		
		JPasswordField contraField = new JPasswordField();
		contraField.setBounds(110, 274, 300, 30);
		contraField.setFont(fuente);
		
		mipanel.add(contraField);
		
		//--------------------------
		//CHECKBOX
		JCheckBox check = new JCheckBox("Recordarme");
		check.setSize(150, 50);
		check.setLocation(106, 294);
		check.setOpaque(false);
		
		mipanel.add(check);
		//----------------------------
		

		JButton olvido = new JButton("¿Olvidó su contraseña?");
		olvido.setSize(150, 20);
		olvido.setLocation(273, 306);
		olvido.setBorder(BorderFactory.createLineBorder(Color.decode("#EFF3EA")));
		olvido.setBackground(Color.decode("#EFF3EA"));
		olvido.setOpaque(false);
		olvido.setFont(new Font("Britannic",Font.BOLD,12));
		
		mipanel.add(olvido);
		
		JLabel linea = new JLabel("------------------------------------");
		linea.setSize(150, 20);
		linea.setForeground(Color.decode("#B9B28A"));
		linea.setLocation(275, 315);
		linea.setOpaque(true);
		mipanel.add(linea);
		
		olvido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//-----------------------------
		//BOTON
		JButton ingresar = new JButton("INGRESAR");
		ingresar.setSize(150, 40);
		ingresar.setLocation(186, 384);
		ingresar.setFont(new Font("Britannic",Font.BOLD,18));
		ingresar.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		ingresar.setOpaque(true);
		ingresar.setBackground(Color.decode("#FBFFE4"));
		
		ingresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean flag1 = false, flag2 = false;
				String nombre = nombreField.getText();
				String password = new String(contraField.getPassword());
				
				if(nombre.equals("") && password.equals("")) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					JOptionPane.showMessageDialog(null, "Por favor, rellene ambos campos.","Campos Vaciós", JOptionPane.WARNING_MESSAGE);
					
				} else if (nombre.equals("")) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.green,3));
					JOptionPane.showMessageDialog(null, "Rellene el campo de 'Nombre de Usuario'.", "Falta Nombre de Usuario", JOptionPane.WARNING_MESSAGE);
				} else if (password.equals("")) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.green,3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					JOptionPane.showMessageDialog(null, "Rellene el campo 'Contraseña'.", "Falta Contraseña", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.green,3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.green,3));
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
				}
		}
	});
		
		mipanel.add(ingresar);
		
		//BOTON
		JButton ir_registro = new JButton("IR A REGISTRO");
		ir_registro.setSize(200, 40);
		ir_registro.setLocation(160, 484);
		ir_registro.setFont(new Font("Britannic",Font.BOLD,18));
		ir_registro.setOpaque(true);
		ir_registro.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		ir_registro.setBackground(Color.decode("#B9B28A"));
		
		ir_registro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				AuthView.this.register();
			}
		});
		
		mipanel.add(ir_registro);
		
		JLabel diseño = new JLabel();
		diseño.setIcon(new ImageIcon("img/diseño.jpg"));
		diseño.setBounds(540, -76, 450, 1000);
		mipanel.add(diseño);
		
		ventana.add(mipanel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void register() {
		JFrame ventana = new JFrame();
		
		ventana.setTitle("DISEÑO");
		ventana.setVisible(true);
		ventana.setSize(1000,1000);
		ventana.setLayout(null);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font fuente = new Font("Britannic",Font.BOLD,16);
		
		JPanel mipanel = new JPanel();
		
		mipanel.setBackground(Color.decode("#EFF3EA"));
		mipanel.setOpaque(true);
		mipanel.setSize(1000,1000);
		mipanel.setLocation(0,0);
		mipanel.setLayout(null); //QUITA EL MOLDE
		
//		mipanel.setPreferredSize(new Dimension(500,800));
		//---------------------------
		//TITULO
		JLabel titulo = new JLabel("REGISTRO");
		titulo.setSize(200, 30);
		titulo.setOpaque(true);
		titulo.setBackground(Color.decode("#D9DFC6")); 
		titulo.setLocation(162, 62);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Britannic",Font.BOLD,24));
		
		mipanel.add(titulo);
		//-------------------
		//NOMBRE
		JLabel nombreLabel = new JLabel("Nombre de Usuario");
		nombreLabel.setSize(320, 35);
		nombreLabel.setOpaque(true);
		nombreLabel.setBackground(Color.decode("#FBFFE4")); 
		nombreLabel.setLocation(102, 132);
		nombreLabel.setHorizontalAlignment(JLabel.CENTER);
		nombreLabel.setFont(fuente);
		
		mipanel.add(nombreLabel);
		
		JTextField nombreField = new JTextField();
		nombreField.setSize(300, 30);
		nombreField.setLocation(112, 182);
		nombreField.setFont(fuente);
		
		mipanel.add(nombreField);
		//-----------------------
		//BIO
		
		JLabel bioLabel = new JLabel("BIO");
		bioLabel.setSize(320, 30);
		bioLabel.setLocation(102, 217);
		bioLabel.setHorizontalAlignment(JLabel.CENTER);
		bioLabel.setFont(fuente);
		
		mipanel.add(bioLabel);	
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(112, 252, 300, 70);
		mipanel.add(textArea);
		//--------------------------
		//PREFERENCIAS
		
		JLabel pref_label = new JLabel("PREFERENCIAS");
		pref_label.setBounds(102, 332, 320, 30);
		pref_label.setHorizontalAlignment(JLabel.CENTER);
		pref_label.setBorder(BorderFactory.createLineBorder(Color.decode("#FBFFE4"),4));		
		pref_label.setFont(fuente);
		
		mipanel.add(pref_label);
		
		JCheckBox dulces = new JCheckBox("Dulces");
		dulces.setBounds(112, 349, 150, 50);
		dulces.setFont(new Font("Britannic",Font.BOLD,14));
		dulces.setOpaque(false);
		
		mipanel.add(dulces);
		
		JCheckBox salado = new JCheckBox("Salado");
		salado.setBounds(212, 349, 150, 50);
		salado.setFont(new Font("Britannic",Font.BOLD,14));
		salado.setOpaque(false);
		
		mipanel.add(salado);
		
		JCheckBox saludable = new JCheckBox("Saludable");
		saludable.setBounds(312, 349, 150, 50);
		saludable.setFont(new Font("Britannic",Font.BOLD,14));
		saludable.setBorder(BorderFactory.createLineBorder(Color.RED, 8));		
		saludable.setOpaque(false);
		
		mipanel.add(saludable);
		//----------------------------
		//TERMINOS
		
		JLabel terminos = new JLabel("TÉRMINOS");
		terminos.setBounds(102, 392, 320, 30);
		terminos.setHorizontalAlignment(JLabel.CENTER);
		terminos.setBorder(BorderFactory.createLineBorder(Color.decode("#FBFFE4"),4));		
		terminos.setFont(fuente);
		
		mipanel.add(terminos);
		
		JRadioButton terms1 = new JRadioButton("Acepto los términos", true);
		terms1.setSize(240,40);
		terms1.setLocation(102,422);
		terms1.setOpaque(false);
		mipanel.add(terms1);
		
		JRadioButton terms2 = new JRadioButton("No acepto los términos");
		terms2.setSize(240,40);
		terms2.setLocation(272, 422);
		terms2.setOpaque(false);
		mipanel.add(terms2);
		
		ButtonGroup terms_group = new ButtonGroup();
		terms_group.add(terms1);
		terms_group.add(terms2);
		//----------------------------
		//COLONIAS
		String dataset []= {"Camino Real", "Centro", "La Fuente", "Villas del Encanto", "Panteón"};
		JComboBox colonias = new JComboBox(dataset);
		colonias.setSize(320, 22);
		colonias.setLocation(102,462);
		colonias.setOpaque(true);
		mipanel.add(colonias);
		
		//----------------------------
		//BOTON
		JButton acceder = new JButton("CREAR CUENTA");
		acceder.setSize(320, 40);
		acceder.setLocation(102, 502);
		acceder.setBackground(Color.decode("#FBFFE4"));
		acceder.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		acceder.setFont(new Font("Britannic",Font.BOLD,16));
		//acceder.setBorder(BorderFactory.createLineBorder(Color.RED, 8));		

		acceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombre = nombreField.getText();
				String texto  = textArea.getText();
				
				//VALIDACION DE TÉRMINOS
				if (terms2.isSelected()) {
					JOptionPane.showMessageDialog(null, "Debes aceptar los términos y condiciones para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				//VALIDACIÓN DE PREFERENCIAS
				if (!dulces.isSelected() && !salado.isSelected() && !saludable.isSelected()) {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona al menos una preferencia.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if (nombre.equals("") && texto.equals("")) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					textArea.setBorder(BorderFactory.createLineBorder(Color.red,3));
					JOptionPane.showMessageDialog(null, "Por favor, rellene ambos campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (nombre.equals("")) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					textArea.setBorder(BorderFactory.createLineBorder(Color.green,3));
					JOptionPane.showMessageDialog(null, "Rellene el campo de 'Nombre de Usuario'.", "Falta Nombre de Usuario", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (texto.equals("")) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.green,3));
					textArea.setBorder(BorderFactory.createLineBorder(Color.red,3));
					JOptionPane.showMessageDialog(null, "Rellene el campo 'BIO'.", "Falta BIO", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				//SI TODO ES VALIDO
				nombreField.setBorder(BorderFactory.createLineBorder(Color.green,3));
				textArea.setBorder(BorderFactory.createLineBorder(Color.green,3));
				JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		mipanel.add(acceder);
		
		//BOTON
		JButton ir_login = new JButton("IR A LOGIN");
		ir_login.setSize(320, 40);
		ir_login.setLocation(102, 602);
		ir_login.setBackground(Color.decode("#B9B28A"));
		ir_login.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		ir_login.setFont(new Font("Britannic",Font.BOLD,16));
		
		ir_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				AuthView.this.login();
			}
		});
		
		mipanel.add(ir_login);

		JLabel diseño = new JLabel();
		diseño.setIcon(new ImageIcon("img/diseño.jpg"));
		diseño.setBounds(540, -76, 450, 1000);
		mipanel.add(diseño);
		
		
		ventana.add(mipanel);
		ventana.repaint();
		ventana.revalidate();
		
	}
	
	public void forgot() {
		
	}

}
