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
    
    
    
    public static Conseiller choixConseiller(Devis d){
         EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("Select cons from Conseiller cons ")  ;
            //query.setParameter("idPays", d.getVoyageDuDevis().getPaysDuVoyage().getIdPays());
            //Conseiller conseiller = (Conseiller) query.getSingleResult();
            List<Conseiller> conseiller = (List<Conseiller>) query.getResultList();
            if (conseiller == null) {
                throw  new EntityNotFoundException("Impossible de trouver conseiller pour le pays :  " + d.getVoyageDuDevis().getPaysDuVoyage() );
                }
            return conseiller.get(0);
    }
}
