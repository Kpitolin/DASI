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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrateur
 */
@Entity
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPays;

    private String nom;
    private String code;
    private String region;
    private String capitale;
    private String langues;
    private Float superficie;
    private Float population;
    private String regimePolitique;
    @ManyToMany
    List<Conseiller> conseillers = new ArrayList();
    @OneToMany(mappedBy = "paysDuVoyage")
    List<Voyage> voyages = new ArrayList<Voyage>();

    public Pays(String nom, String code, String region, String capitale,
            String langues, Float superficie, Float population,
            String regimePolitique) {
        this.nom = nom;
        this.code = code;
        this.region = region;
        this.capitale = capitale;
        this.langues = langues;
        this.superficie = superficie;
        this.population = population;
        this.regimePolitique = regimePolitique;

    }

    public Pays() {
    }

    public Integer getIdPays() {
        return idPays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCapitale() {
        return capitale;
    }

    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }

    public Float getPopulation() {
        return population;
    }

    public void setPopulation(Float population) {
        this.population = population;
    }

    public String getRegimePolitique() {
        return regimePolitique;
    }

    public void setRegimePolitique(String regimePolitique) {
        this.regimePolitique = regimePolitique;
    }

    public List<Conseiller> getConseillers() {
        return conseillers;
    }

    public void setConseillers(ArrayList<Conseiller> conseillers) {
        this.conseillers = conseillers;
    }

    @Override
    public String toString() {
        return "Pays{" + "nom=" + nom + ", code=" + code + ", region=" + region + ", capitale=" + capitale + ", langues=" + langues + ", superficie=" + superficie + ", population=" + population + ", regimePolitique=" + regimePolitique + /*", conseillers=" + conseillers + */ '}';
    }

    public Conseiller chooseConseiller() {
        return new Conseiller();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pays other = (Pays) obj;
        if ((this.code == null) ? (other.code != null)
                : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }

    public void addConseillers(Conseiller conseiller) {
        this.conseillers.add(conseiller);
    }

    public void addVoyage(Voyage voyage) {
        this.voyages.add(voyage);
    }

}
