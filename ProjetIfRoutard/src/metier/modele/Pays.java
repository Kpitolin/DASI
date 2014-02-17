/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Administrateur
 */
@Entity
public class Pays {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idPays;
    
    private String nom;
    private String code;
    private String region;
    private String capitale;
    private String langues;
    private Float superficie;
    private Float population;
    private String regimePolitique;
   /* @ManyToMany
    ArrayList<Conseiller> conseillers = new ArrayList();
*/
    public Pays(String nom, String code, String region, String capitale, String langues, Float superficie, Float population, String regimePolitique) {
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

    @Override
    public String toString() {
        return "Pays{" + "nom=" + nom + ", code=" + code + ", region=" + region + ", capitale=" + capitale + ", langues=" + langues + ", superficie=" + superficie + ", population=" + population + ", regimePolitique=" + regimePolitique + /*", conseillers=" + conseillers + */'}';
    }
/*
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }



    public ArrayList<Conseiller> getConseillers() {
        return conseillers;
    }

    public void addConseillers(Conseiller conseiller) {
        this.conseillers.add(conseiller);
    }
    */
    
    
}
