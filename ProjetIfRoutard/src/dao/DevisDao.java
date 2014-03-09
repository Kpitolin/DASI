/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import metier.modele.Conseiller;
import metier.modele.Devis;

/**
 *
 * @author KEV
 */
public class DevisDao {
      public void persistDevis (Devis p){
        ObjectDao.persitObject(p);
    
    }
    
       
    public void mergeDevis  (Devis p){
        ObjectDao.mergeObject(p);
    
    }
    
    
        // select c from Conseiller e join e.attributDeCPointantC unNom

    public static List<Conseiller> choixConseiller(Devis d){
         EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("Select conseillers from Conseiller cons join Pays.conseillers where Pays.nom = :nomPays   ")  ;
            query.setParameter("nomPays", d.getVoyageDuDevis().getPaysDuVoyage().getNom());
            //Conseiller conseiller = (Conseiller) query.getSingleResult();
            List<Conseiller> conseiller = (List<Conseiller>) query.getResultList();
            if (conseiller == null) {
                throw  new EntityNotFoundException("Impossible de trouver conseiller pour le pays :  " + d.getVoyageDuDevis().getPaysDuVoyage().getNom() );
                }
            return conseiller;
    }
}
