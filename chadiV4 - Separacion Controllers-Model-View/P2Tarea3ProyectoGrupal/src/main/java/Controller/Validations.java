package Controller;
import View.VenRegistro;
/**
 *
 * @author cs023
 */
public class Validations {
    
    public static boolean validarContraseña(String contraseña) {
        return contraseña.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("(0?[2-9]|1[0-9])\\d{8}");
    }

    public static boolean validarCedula(String cedula) {
        return cedula.matches("\\d{10}");
    }

    public static boolean validarEdad(int edad) {
        return edad >= 1 && edad <= 150;
    }
    
    
}
