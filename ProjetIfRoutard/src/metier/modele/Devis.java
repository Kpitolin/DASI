/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author KEV
 */
@Entity
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDevis;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDevis;
    @ManyToOne
    private Voyage voyageDuDevis;
    @OneToOne
    private Conseiller conseillerDevis;
    @ManyToOne
    private Client clientDevis;
    private Integer nbPersonnes;
    @ManyToOne
    private InfoPrincipale choixCaracteristiques;

    public Devis() {
    }

    public Devis(Date date, Voyage voyageDuDevis, Client clientDevis) {
        this.dateDevis = date;
        this.voyageDuDevis = voyageDuDevis;
        this.clientDevis = clientDevis;
    }

    public Integer getIdDevis() {
        return idDevis;
    }

    public Date getDate() {
        return dateDevis;
    }

    public void setDate(Date date) {
        this.dateDevis = date;
    }

    public Voyage getVoyageDuDevis() {
        return voyageDuDevis;
    }

    public void setVoyageDuDevis(Voyage voyageDuDevis) {
        this.voyageDuDevis = voyageDuDevis;
    }

    public Conseiller getConseillerDevis() {
        return conseillerDevis;
    }

    public void setConseillerDevis(Conseiller conseillerDevis) {
        this.conseillerDevis = conseillerDevis;
    }

    public Client getClientDevis() {
        return clientDevis;
    }

    public void setClientDevis(Client clientDevis) {
        this.clientDevis = clientDevis;
    }

    public void setNbPersonnes(Integer nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public void setChoixCaracteristiques(InfoPrincipale choixCaracteristiques) {
        this.choixCaracteristiques = choixCaracteristiques;
    }

    @Override
    public String toString() {
        return "Devis {" + "dateDevis=" + dateDevis + ", voyageDuDevis=" + voyageDuDevis.getDescription() + "Client "+clientDevis+'}';
    }
    
    public String afficheDevis(){
                return "{" + "dateDevis=" + dateDevis + ", voyageDuDevis=" + voyageDuDevis.getDescription() + ", conseillerDevis=" + conseillerDevis.getNom()+" "+conseillerDevis.getPrenom() + ", nbPersonnes=" + nbPersonnes + ", choixCaracteristiques=" + choixCaracteristiques +"\n"+"Prix Total : "+calculePrix() +"€"+'}';

    }
    
    public int calculePrix(){
        return choixCaracteristiques.getTarif()*nbPersonnes;
    }
}
