/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author Administrateur
 */
@Entity
public class Circuit extends Voyage{
    
    

    private String Transport;
    private Integer Kilometres;

    public Circuit() {
    }

    public Circuit(String Transport, Integer Kilometres, String CodePays, String CodeVoyage, String Intitule, Integer Duree, String Description) {
        super(CodePays, CodeVoyage, Intitule, Duree, Description);
        this.Transport = Transport;
        this.Kilometres = Kilometres;
    }

    @Override
    public String toString() {
        return super.toString() + "Transport=" + Transport + ", Kilometres=" + Kilometres + '}';
    }

   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getTransport() {
        return Transport;
    }

    public void setTransport(String Transport) {
        this.Transport = Transport;
    }

    public Integer getKilometres() {
        return Kilometres;
    }

    public void setKilometres(Integer Kilometres) {
        this.Kilometres = Kilometres;
    }
    
    
    
    
}
