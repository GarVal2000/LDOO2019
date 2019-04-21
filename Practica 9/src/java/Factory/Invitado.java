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
public class Invitado implements Factory {
    private String nombre;
    private String correo;
    private String contra;
    private String FeNa;

    
    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     @Override
    public String getFeNa() {
        return FeNa;
    }

    public void setFeNa(String FeNa) {
        this.FeNa = FeNa;
    }
    
    
    
    
}
