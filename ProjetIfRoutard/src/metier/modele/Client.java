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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Administrateur
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idClient;
    private String civilite;
    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String adresse;
    private String telephone;
    private String email;
    private boolean autorisationPartenaires;
    @OneToMany(mappedBy = "clientDevis")
    private List<Devis> devisDuClient = new ArrayList<Devis>();

    public Client() {
    }

    public Client(String civilite, String nom, String prenom,
            Date dateNaissance, String adresse, String telephone,
            String email) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.idClient != other.idClient && (this.idClient == null
                || !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public boolean isAutorisationPartenaires() {
        return autorisationPartenaires;
    }

    public void setAutorisationPartenaires(boolean autorisationPartenaires) {
        this.autorisationPartenaires = autorisationPartenaires;
    }

    public void addDevis(Devis d) {
        devisDuClient.add(d);
    }

    @Override
    public String toString() {
        return "Client{" + "civilite=" + civilite + ", nom=" + nom
                + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
                + ", adresse=" + adresse + ", telephone=" + telephone
                + ", email=" + email + '}';
    }

    public String listeDevis() {
        String chaine = "";
        for (int i = 0; i < this.devisDuClient.size(); i++) {

            chaine += "   Devis " + (i + 1) + " : "
                    + this.devisDuClient.get(i).afficheDevis() + "\n";
        }

        return chaine;
    }
}
