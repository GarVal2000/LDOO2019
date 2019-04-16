/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Mauricio
 */
public class Comprobar {
    private String cCorreo;
    private String pCorreo;
    private String cContra;
    private String pContra;
    private boolean com;

    public boolean getCom() {
        return com;
    }
    
    public String getCCorreo() {
        return cCorreo;
    }

    public void setCCorreo(String cCorreo) {
        this.cCorreo = cCorreo;
    }

    public String getPCorreo() {
        return pCorreo;
    }

    public void setPCorreo(String pCorreo) {
        this.pCorreo = pCorreo;
    }

    public String getCContra() {
        return cContra;
    }

    public void setCContra(String cContra) {
        this.cContra = cContra;
    }

    public String getPContra() {
        return pContra;
    }

    public void setPContra(String pContra) {
        this.pContra = pContra;
    }
     public void Comprobar(){
     	if (cCorreo.equals(pCorreo) & cContra.equals(pContra)) {
     		com=true;
     	}else{
     		com=false;
     	}
     }
    
}

