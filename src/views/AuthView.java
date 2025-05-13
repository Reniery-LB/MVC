package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controllers.HomeController;
import models.AuthModel;
import models.User;

public class AuthView{
	
	public AuthView() {
	}
	
	public void inicio() {
		JFrame ventana = new JFrame();
		
		ventana.setTitle("DISEÑO");
		ventana.setVisible(true);
		ventana.setSize(1000,1000);
		ventana.setLayout(null);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mipanel = new JPanel();
		mipanel.setBounds(0, 0, 1000, 1000);
		mipanel.setBackground(Color.decode("#284B63"));
		mipanel.setLayout(null);
		
		JLabel titulo = new JLabel("INICIO");
		titulo.setBackground(Color.decode("#D9DFC6"));
		titulo.setOpaque(true);
		titulo.setFont(new Font("Britannic", Font.BOLD, 42));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setForeground(Color.BLACK);
		titulo.setBounds(288, 10, 410, 93);
		mipanel.add(titulo);
		
		JLabel dirigirse = new JLabel("Dirigirse a");
		dirigirse.setForeground(Color.BLACK);
		dirigirse.setFont(new Font("Britannic", Font.BOLD, 32));
		dirigirse.setBounds(414, 113, 161, 93);
		mipanel.add(dirigirse);
		
		JButton iniciar_sesion = new JButton("INICIAR SESIÓN");
		iniciar_sesion.setForeground(new Color(255, 255, 255));
		iniciar_sesion.setBackground(Color.decode("#B9B28A"));
		iniciar_sesion.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		iniciar_sesion.setFont(new Font("Britannic", Font.BOLD, 18));
		iniciar_sesion.setBounds(229, 371, 183, 58);
		mipanel.add(iniciar_sesion);
		
		iniciar_sesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				AuthView.this.login();
			}
		});
		
		JButton registrarse = new JButton("REGISTRARSE");
		registrarse.setForeground(Color.WHITE);
		registrarse.setFont(new Font("Britannic", Font.BOLD, 18));
		registrarse.setBackground(Color.decode("#B9B28A"));
		registrarse.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		registrarse.setBounds(578, 371, 183, 58);
		mipanel.add(registrarse);
		
		registrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AuthView.this.register();
			}
		});
		
		JLabel icon_acceder = new JLabel(new ImageIcon("img/acceder.png"));
		icon_acceder.setBounds(216, 225, 183, 136);
		mipanel.add(icon_acceder);
		
		JLabel icon_registrarse = new JLabel(new ImageIcon("img/registrarse.png"));
		icon_registrarse.setBounds(578, 225, 183, 136);
		mipanel.add(icon_registrarse);
		
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon("img/fondoInicio.jpg"));
		fondo.setBounds(0, 0, 1000, 1000);
		mipanel.add(fondo);
		
		ventana.add(mipanel);
		ventana.repaint();
		ventana.revalidate();
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
		JLabel nombreLabel = new JLabel("Correro Electronico");
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
				String email = nombreField.getText();
				String password = new String(contraField.getPassword());
				
				if (email.isEmpty() || password.isEmpty()) {
					nombreField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.red,3));
					JOptionPane.showMessageDialog(null, "Por favor, rellene ambos campos.", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
					AuthModel modelo = new AuthModel();
	
					if(modelo.login(email, password)) {
						nombreField.setBorder(BorderFactory.createLineBorder(Color.green,3));
						contraField.setBorder(BorderFactory.createLineBorder(Color.green,3));
						JOptionPane.showMessageDialog(null, "Bienvenido", "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
						ventana.dispose();
						showUserManagement();
					} else {
						nombreField.setBorder(BorderFactory.createLineBorder(Color.red,3));
						contraField.setBorder(BorderFactory.createLineBorder(Color.red,3));
						JOptionPane.showMessageDialog(null, "Error al acceder", "Verificar Correo y Contraseña", JOptionPane.WARNING_MESSAGE);
					}
					
					ventana.dispose();
					HomeController hc = new HomeController();
					
					hc.home();
			
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
		
		JButton regresar = new JButton();
		regresar.setIcon(new ImageIcon("img/regresar.png"));
		regresar.setOpaque(true);
		regresar.setBackground(new Color(185, 178, 138));
		regresar.setBounds(10, 10, 65, 40);
		mipanel.add(regresar);
		
		regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				AuthView.this.inicio();
			}
		});
		
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
		
		//TITULO
		JLabel titulo = new JLabel("REGISTRO DE USUARIO");
		titulo.setSize(600, 60);
		titulo.setOpaque(true);
		titulo.setBackground(Color.decode("#D9DFC6")); 
		titulo.setLocation(186, 70);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Britannic",Font.BOLD,40));
		
		mipanel.add(titulo);
		
		JLabel email = new JLabel("Correo Electrónico");
		email.setFont(new Font("Britannic", Font.BOLD, 16));
		email.setBounds(23, 199, 223, 40);
		email.setBackground(Color.decode("#FBFFE4")); 
		email.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		email.setOpaque(true);
		mipanel.add(email);
		
		JTextField emailField = new JTextField();
		emailField.setBounds(23, 263, 265, 32);
		mipanel.add(emailField);
		emailField.setColumns(10);
		
		JLabel contra_alta = new JLabel("Contraseña");
		contra_alta.setOpaque(true);
		contra_alta.setFont(new Font("Britannic", Font.BOLD, 16));
		contra_alta.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		contra_alta.setBackground(new Color(251, 255, 228));
		contra_alta.setBounds(23, 322, 223, 40);
		mipanel.add(contra_alta);
		
		JPasswordField nueva_contraField = new JPasswordField();
		nueva_contraField.setBounds(23, 384, 265, 32);
		mipanel.add(nueva_contraField);
		
		JLabel nombre = new JLabel("Nombre Completo");
		nombre.setOpaque(true);
		nombre.setFont(new Font("Britannic", Font.BOLD, 16));
		nombre.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		nombre.setBackground(new Color(251, 255, 228));
		nombre.setBounds(362, 199, 223, 40);
		mipanel.add(nombre);
		
		JTextField nombre_field = new JTextField();
		nombre_field.setColumns(10);
		nombre_field.setBounds(362, 263, 265, 32);
		mipanel.add(nombre_field);
		
		JButton aceptar = new JButton("APLICAR Y ACEPTAR");
		aceptar.setSize(310, 65);
		aceptar.setLocation(530, 638);
		aceptar.setHorizontalAlignment(JLabel.CENTER);
		aceptar.setBackground(Color.decode("#B9B28A"));
		aceptar.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		aceptar.setFont(new Font("Dialog", Font.BOLD, 18));
		mipanel.add(aceptar);
		
		JLabel correo = new JLabel(new ImageIcon("correo.png"));
		correo.setBounds(183, 148, 183, 136);
		mipanel.add(correo);
		
		JLabel contra = new JLabel(new ImageIcon("contraseña.png"));
		contra.setBounds(183, 280, 183, 136);
		mipanel.add(contra);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setOpaque(true);
		lblNombreDeUsuario.setFont(new Font("Britannic", Font.BOLD, 16));
		lblNombreDeUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		lblNombreDeUsuario.setBackground(new Color(251, 255, 228));
		lblNombreDeUsuario.setBounds(362, 322, 223, 40);
		mipanel.add(lblNombreDeUsuario);
		
		JTextField usuario_field = new JTextField();
		usuario_field.setColumns(10);
		usuario_field.setBounds(362, 384, 265, 32);
		mipanel.add(usuario_field);
		
		JLabel telefono = new JLabel("Teléfono (Opcional)");
		telefono.setOpaque(true);
		telefono.setFont(new Font("Britannic", Font.BOLD, 16));
		telefono.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		telefono.setBackground(new Color(251, 255, 228));
		telefono.setBounds(710, 199, 223, 40);
		mipanel.add(telefono);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(710, 263, 265, 32);
		mipanel.add(textField_2);
		
		JLabel nacimiento = new JLabel("Fecha de Nacimiento");
		nacimiento.setOpaque(true);
		nacimiento.setFont(new Font("Britannic", Font.BOLD, 16));
		nacimiento.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		nacimiento.setBackground(new Color(251, 255, 228));
		nacimiento.setBounds(710, 322, 223, 40);
		mipanel.add(nacimiento);
		
		JComboBox dia = new JComboBox(new Object[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
		dia.setFont(new Font("Britannic", Font.PLAIN, 17));
		dia.setBounds(710, 384, 59, 32);
		mipanel.add(dia);
		
		JComboBox mes = new JComboBox(new Object[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
		mes.setFont(new Font("Dialog", Font.PLAIN, 17));
		mes.setBounds(779, 384, 59, 32);
		mipanel.add(mes);
		
		JComboBox año = new JComboBox(new Object[]{"2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997"});
		año.setFont(new Font("Dialog", Font.PLAIN, 17));
		año.setBounds(848, 384, 85, 32);
		mipanel.add(año);
		
		JButton btn_login = new JButton("IR A LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				AuthView.this.login();
			}
		});
		btn_login.setHorizontalAlignment(SwingConstants.CENTER);
		btn_login.setFont(new Font("Dialog", Font.BOLD, 18));
		btn_login.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		btn_login.setBackground(Color.decode("#FBFFE4"));
		btn_login.setBounds(166, 638, 310, 65);
		mipanel.add(btn_login);
		
		JLabel verificar_contra = new JLabel("Verificar Contraseña");
		verificar_contra.setOpaque(true);
		verificar_contra.setFont(new Font("Dialog", Font.BOLD, 16));
		verificar_contra.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		verificar_contra.setBackground(new Color(251, 255, 228));
		verificar_contra.setBounds(23, 445, 223, 40);
		mipanel.add(verificar_contra);
		
		JLabel contra_1 = new JLabel(new ImageIcon("contraseña.png"));
		contra_1.setBounds(183, 403, 183, 136);
		mipanel.add(contra_1);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(23, 507, 265, 32);
		mipanel.add(passwordField);
		
		JLabel empresa = new JLabel("Empresa");
		empresa.setOpaque(true);
		empresa.setFont(new Font("Dialog", Font.BOLD, 16));
		empresa.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		empresa.setBackground(new Color(251, 255, 228));
		empresa.setBounds(362, 445, 223, 40);
		mipanel.add(empresa);
		
		JTextField empresa_field = new JTextField();
		empresa_field.setColumns(10);
		empresa_field.setBounds(362, 507, 265, 32);
		mipanel.add(empresa_field);
		
		JLabel ambito_empresa = new JLabel("Ámbito de la Empresa");
		ambito_empresa.setOpaque(true);
		ambito_empresa.setFont(new Font("Dialog", Font.BOLD, 16));
		ambito_empresa.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		ambito_empresa.setBackground(new Color(251, 255, 228));
		ambito_empresa.setBounds(710, 445, 223, 40);
		mipanel.add(ambito_empresa);
		
		JComboBox ambito_comboBox = new JComboBox(new Object[]{"Tecnología", "Salud", "Educación", "Comercio", "Otro"});
		ambito_comboBox.setFont(new Font("Dialog", Font.PLAIN, 17));
		ambito_comboBox.setBounds(710, 507, 223, 32);
		mipanel.add(ambito_comboBox);
		
		JRadioButton terms1 = new JRadioButton("Acepto los términos y condiciones", true);
		terms1.setSize(240,40);
		terms1.setLocation(226,589);
		terms1.setOpaque(false);
		mipanel.add(terms1);
		
		JRadioButton terms2 = new JRadioButton("No acepto los términos y condiciones");
		terms2.setSize(240,40);
		terms2.setLocation(530, 589);
		terms2.setOpaque(false);
		mipanel.add(terms2);
		
		ButtonGroup terms_group = new ButtonGroup();
		terms_group.add(terms1);
		terms_group.add(terms2);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        String nombre = nombre_field.getText();
		        String email = emailField.getText();
		        String usuario = usuario_field.getText();
		        String password = new String(nueva_contraField.getPassword());
		        String confirmPassword = new String(passwordField.getPassword());
		        String empresa = empresa_field.getText();

		        // Validaciones
		        if (nombre.isEmpty() || email.isEmpty() || usuario.isEmpty() || password.isEmpty() || empresa.isEmpty()) {
		            JOptionPane.showMessageDialog(ventana, 
		                "Todos los campos son obligatorios.", 
		                "Error", 
		                JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (!password.equals(confirmPassword)) {
		            JOptionPane.showMessageDialog(ventana, 
		                "Las contraseñas no coinciden.", 
		                "Error", 
		                JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Validación opcional: espacios en el usuario
		        if (usuario.contains(" ")) {
		            JOptionPane.showMessageDialog(ventana, 
		                "El nombre de usuario no puede contener espacios.", 
		                "Error", 
		                JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Registrar usuario en el modelo
		        AuthModel modelo = new AuthModel();
		        boolean registroExitoso = modelo.registrarUsuario(nombre, email, usuario, password, empresa);

		        if (registroExitoso) {
		            JOptionPane.showMessageDialog(ventana, 
		                "¡Registro exitoso!", 
		                "Éxito", 
		                JOptionPane.INFORMATION_MESSAGE);
		            ventana.dispose(); // Cerrar ventana de registro
		            inicio(); // Volver a la pantalla de inicio
		        } else {
		            JOptionPane.showMessageDialog(ventana, 
		                "Error al guardar los datos.", 
		                "Error", 
		                JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		JButton regresar = new JButton();
		regresar.setIcon(new ImageIcon("img/regresar.png"));
		regresar.setOpaque(true);
		regresar.setBackground(Color.decode("#B9B28A"));
		regresar.setBounds(10, 10, 65, 40);
		mipanel.add(regresar);
		
		regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				AuthView.this.inicio();
			}
		});
		
		ventana.add(mipanel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	private void showUserManagement() {
	    JFrame managementFrame = new JFrame("Gestión de Usuarios");
	    managementFrame.setSize(900, 600);
	    managementFrame.setLocationRelativeTo(null);
	    managementFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    JPanel panel = new JPanel(new BorderLayout());
	    
	    // Crear tabla
	    DefaultTableModel tableModel = new DefaultTableModel(
	        new Object[]{"ID", "Nombre", "Email", "Usuario", "Empresa"}, 0);
	    JTable userTable = new JTable(tableModel);
	    userTable.setFont(new Font("Britannic", Font.PLAIN, 14));
	    
	    // Botones
	    JButton refreshButton = new JButton("Actualizar");
	    refreshButton.setFont(new Font("Britannic", Font.BOLD, 16));
	    refreshButton.setBackground(Color.decode("#B9B28A"));
	    refreshButton.setForeground(Color.WHITE);
	    
	    JButton backButton = new JButton("Regresar");
	    backButton.setFont(new Font("Britannic", Font.BOLD, 16));
	    backButton.setBackground(Color.decode("#B9B28A"));
	    backButton.setForeground(Color.WHITE);
	    
	    // Panel de botones
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(refreshButton);
	    buttonPanel.add(backButton);
	    
	    // Cargar datos
	    refreshTableData(tableModel);
	    
	    // Eventos
	    refreshButton.addActionListener(e -> refreshTableData(tableModel));
	    
	    backButton.addActionListener(e -> {
	        managementFrame.dispose();
	        inicio();
	    });
	    
	    // Añadir componentes
	    panel.add(new JScrollPane(userTable), BorderLayout.CENTER);
	    panel.add(buttonPanel, BorderLayout.SOUTH);
	    
	    managementFrame.add(panel);
	    managementFrame.setVisible(true);
	}

	private void refreshTableData(DefaultTableModel tableModel) {
	    tableModel.setRowCount(0); // Limpiar tabla
	    
	    AuthModel model = new AuthModel();
	    List<User> users = model.getAllUsers();
	    model.close();
	    
	    for (User user : users) {
	        tableModel.addRow(user.toArray());
	    }
	}
	
	public void forgot() {
		
	}

}
