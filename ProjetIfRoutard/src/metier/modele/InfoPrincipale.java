/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Administrateur
 */
@Entity
public class InfoPrincipale {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer IdInfoPrincipale;
    private String villeDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    private Integer tarif;
    private String Transport;
    @ManyToOne
    private Voyage voyageAssocie;
    @OneToOne
    private Devis devisAssocie;
    
    
    
    
    public InfoPrincipale() {
    }

    public InfoPrincipale(String villeDepart, Date dateDepart, Integer tarif, String Transport) {
        this.villeDepart = villeDepart;
        this.dateDepart = dateDepart;
        this.tarif = tarif;
        this.Transport = Transport;
    }

    public Integer getIdInfoPrincipale() {
        return IdInfoPrincipale;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart)  {
        this.villeDepart = villeDepart;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }

    public String getTransport() {
        return Transport;
    }

    public void setTransport(String Transport) {
        this.Transport = Transport;
    }

    public Voyage getVoyageAssocie() {
        return voyageAssocie;
    }

    public void setVoyageAssocie(Voyage voyageAssocie) {
        this.voyageAssocie = voyageAssocie;
    }

    @Override
    public String toString() {
        return "{" + "villeDepart=" + villeDepart + ", dateDepart=" + dateDepart + ", tarif=" + tarif + ", Transport=" + Transport + ", voyageAssocie=" + voyageAssocie + '}';
    }
    
    
}
