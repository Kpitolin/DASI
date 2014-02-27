/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrateur
 */
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class Voyage {
    
    
@Id
@GeneratedValue(strategy= GenerationType.AUTO)

protected Integer idVoyage;    
protected String CodePays;
protected String CodeVoyage;
protected String Intitule;
protected Integer Duree;
protected String Description;
@ManyToOne
protected Pays paysDuVoyage;
@OneToMany (mappedBy = "voyageAssocie")
List <InfoPrincipale> infos = new ArrayList <InfoPrincipale> ();
    public Voyage() {
    }

    public Voyage(String CodePays, String CodeVoyage, String Intitule, Integer Duree, String Description) {
        this.CodePays = CodePays;
        this.CodeVoyage = CodeVoyage;
        this.Intitule = Intitule;
        this.Duree = Duree;
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Voyage{" + "CodePays=" + CodePays + ", CodeVoyage=" + CodeVoyage + ", Intitule=" + Intitule + ", Duree=" + Duree + ", Description=" + Description ;
    }


    public String getCodePays() {
        return CodePays;
    }

    public String getCodeVoyage() {
        return CodeVoyage;
    }

    public String getIntitule() {
        return Intitule;
    }

    public Integer getDuree() {
        return Duree;
    }

    public String getDescription() {
        return Description;
    }

    public Integer getIdVoyage() {
        return idVoyage;
    }
    
    
    public void setCodePays(String CodePays) {
        this.CodePays = CodePays;
    }

    public void setCodeVoyage(String CodeVoyage) {
        this.CodeVoyage = CodeVoyage;
    }

    public void setIntitule(String Intitule) {
        this.Intitule = Intitule;
    }

    public void setDuree(Integer Duree) {
        this.Duree = Duree;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Pays getPaysDuVoyage() {
        return this.paysDuVoyage;
    }

    public void setPaysDuVoyage(Pays paysDuVoyage) {
        this.paysDuVoyage = paysDuVoyage;
    }
    
    public void addInfos (InfoPrincipale info){
        this.infos.add(info);
    }

   


    
    
    
    
    
    
    
}
