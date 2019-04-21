/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author Luis Mauricio
 */
public class Administrador implements Factory {
    private String nombre;
    private int NumEmp;
    private String FeNa;
    private String correo;
    private String contra;

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getNumEmp() {
        return NumEmp;
    }

    public void setNumEmp(int NumEmp) {
        this.NumEmp = NumEmp;
    }
     @Override
    public String getFeNa() {
        return FeNa;
    }

    public void setFeNa(String FeNa) {
        this.FeNa = FeNa;
    }
     @Override
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
     @Override
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
   
    
}
