package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AuthModel {

	public boolean registrarUsuario(String nombre, String email, String usuario, 
            String password, String empresa) {
// 1. Crear la carpeta si no existe
File directorio = new File("files");
if (!directorio.exists()) {
directorio.mkdirs();  // Crea la carpeta y todas las necesarias
}

// 2. Ruta absoluta para debug
File archivo = new File("files/usuarios.txt");
System.out.println("Ruta completa: " + archivo.getAbsolutePath());

try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
String linea = String.join(",", nombre, email, usuario, password, empresa);
writer.write(linea);
writer.newLine();
return true;
} catch (IOException e) {
System.err.println("Error crítico al registrar: " + e.getMessage());
e.printStackTrace();
return false;
}
}
	
	public AuthModel() {
	
	}
	
    private static final String USERS_FILE = "files/usuarios.txt"; 
    
    public boolean login(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // email está en posición 1, password en 3 (según tu formato de registro)
                if (data.length >= 4 && email.equals(data[1]) && password.equals(data[3])) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return false;
    }

}
