package Model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import View.VenRegistro;
import View.VenSesion;
import Controller.Usuario;
import javax.swing.JOptionPane;
/**
 *
 * @author cs023
 */
public class Mongo {
    
    public MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection<Document> usuariosCollection;
    // instancia
    VenRegistro regis;
    VenSesion sesion;
    Usuario user = new Usuario("","","","","", 0);
    
     public Mongo(VenRegistro regis, VenSesion sesion) {
        // Conectar a MongoDB (asegúrate de que el servidor se ejecute localmente)
        mongoClient = new MongoClient("localhost", 27017);
        // Seleccionar la base de datos y las colecciones
        database = mongoClient.getDatabase("Cine");
        usuariosCollection = database.getCollection("Usuarios");
        
        // asignar la instancia de VenRegistro.
        this.regis = regis;
        // asignar la instancia de VenSesion.
        this.sesion = sesion;
     }
     

    public void insertarUsuario() {
        try {
        user.setnomb(regis.txtnom.getText());
        user.setcorreo(regis.txtCorreo.getText());
        user.settelef(regis.txtTelefono.getText());
        user.setci(regis.txtCi1.getText());
        user.setcont(regis.txtcont.getText());

        int edad = (int) regis.JSedad.getValue(); // Obtén la edad del componente JSedad
        user.setedad(edad); // Establece la edad en el objeto user

        Document userdocument = new Document()
                .append("Usuario", user.getnomb())
                .append("Contraseña", user.getcont())
                .append("Correo", user.getcorreo())
                .append("Telefono", user.gettelef())
                .append("Cedula", user.getci())
                .append("Edad", edad); // Utiliza la variable edad

        usuariosCollection.insertOne(userdocument);

        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Puedes imprimir la traza de la excepción si es necesario
    }
    }
    
    public Document buscarUsuario() {
        String usuario = sesion.TextUsuario.getText();
        String cont = sesion.JLPClave.getText();
        
        if (usuario.isEmpty() || cont.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese usuario y contraseña", "Información", JOptionPane.INFORMATION_MESSAGE);
        return null; 
    }

    try {
        // Utiliza la conexión existente en lugar de crear una nueva
        Document query = new Document("Usuario", usuario).append("Contraseña", cont);
        return usuariosCollection.find(query).first();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al buscar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}

    
    public void cerrarConexion() {
         if (mongoClient != null) {
        mongoClient.close();
        }
    }
}
