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
public class Sejour extends Voyage {

    private String Residence;

    public Sejour() {
    }

    public String getResidence() {
        return Residence;
    }

    public void setResidence(String Residence) {
        this.Residence = Residence;
    }

    public Sejour(String Residence, String CodePays, String CodeVoyage,
            String Intitule, Integer Duree, String Description) {
        super(CodePays, CodeVoyage, Intitule, Duree, Description);
        this.Residence = Residence;
    }

    @Override
    public String toString() {
        return super.toString() + "Residence=" + Residence + '}';
    }

}
