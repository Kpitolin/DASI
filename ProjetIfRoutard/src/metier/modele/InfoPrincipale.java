/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Administrateur
 */
@Entity
public class InfoPrincipale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdInfoPrincipale;
    private String codeInfoPrincipale;
    private String villeDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    private Integer tarif;
    private String Transport;
    @ManyToOne
    private Voyage voyageAssocie;
    @OneToMany
    private List<Devis> devisAssocie = new ArrayList<Devis>();

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.IdInfoPrincipale
                != null ? this.IdInfoPrincipale.hashCode() : 0);
        hash = 83 * hash + (this.codeInfoPrincipale
                != null ? this.codeInfoPrincipale.hashCode() : 0);
        hash = 83 * hash + (this.villeDepart
                != null ? this.villeDepart.hashCode() : 0);
        hash = 83 * hash + (this.dateDepart
                != null ? this.dateDepart.hashCode() : 0);
        hash = 83 * hash + (this.tarif
                != null ? this.tarif.hashCode() : 0);
        hash = 83 * hash + (this.Transport
                != null ? this.Transport.hashCode() : 0);
        return hash;
    }

    public InfoPrincipale() {
    }

    public InfoPrincipale(String villeDepart, Date dateDepart, Integer tarif,
            String Transport) {
        this.villeDepart = villeDepart;
        this.dateDepart = dateDepart;
        this.tarif = tarif;
        this.Transport = Transport;
        setCodeInfoPrincipale(hashCode() + "");
    }

    public String getCodeInfoPrincipale() {
        return codeInfoPrincipale;
    }

    public void setCodeInfoPrincipale(String codeInfoPrincipale) {
        this.codeInfoPrincipale = codeInfoPrincipale;
    }

    public Integer getIdInfoPrincipale() {
        return IdInfoPrincipale;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
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
        return "Code : " + codeInfoPrincipale + " villeDepart=" + villeDepart
                + ", dateDepart=" + dateDepart + ", tarif=" + tarif
                + ", Transport=" + Transport;
    }

}
