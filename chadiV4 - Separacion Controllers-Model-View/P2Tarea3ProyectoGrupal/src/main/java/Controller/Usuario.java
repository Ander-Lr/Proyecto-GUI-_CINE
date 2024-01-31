/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author cs023
 */
public class Usuario {
    public String nomb;
    public String correo;
    public String telef;
    public String ci;
    public String cont;
    public int edad;

    public Usuario(String nomb, String correo, String telef, String ci, String cont, int edad) {
        this.nomb = nomb;
        this.correo = correo;
        this.telef = telef;
        this.ci = ci;
        this.cont = cont;
        this.edad = edad;
    }
    
    
    
    //GETTERS
    public String getnomb(){
        return nomb;
    }

    public String getcorreo(){
        return correo;
    }
    public String gettelef(){
        return telef;
    }
    public String getci(){
        return ci;
    }
    public String getcont(){
        return cont;
    }

    public int getedad() {
        return edad;
    }
    
    
    public void setnomb(String nomb){
        this.nomb=nomb;
    }
    public void setcorreo(String correo){
        this.correo=correo;
    }
    public void settelef(String telef){
        this.telef=telef;
    }
    public void setci(String ci){
        this.ci=ci;
    }    
    public void setcont(String cont){
        this.cont=cont;
    }
    public void setedad(int edad){
        this.edad=edad;
    }
}
