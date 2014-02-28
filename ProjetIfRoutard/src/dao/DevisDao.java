/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import metier.modele.Conseiller;
import metier.modele.Devis;
import metier.modele.Pays;

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
    
    
    
    public static Conseiller chooseConselor(Pays pays){
         EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("select cons from Pays.conseillers cons where emp.ID=e.EMPLOYE_ID group by emp having SIZE(cons.clients) = (select min(SIZE(Pays.conseillers.clients)) from EMPLOYE emp join EMPLOYE_CLIENT e where emp.ID=e.EMPLOYE_ID group by emp)  " );
            query.setParameter("pays", pays);
            Conseiller conseiller = (Conseiller) query.getSingleResult();
            if (conseiller == null) {
                throw  new EntityNotFoundException("Impossible de trouver conseiller pour le pays :  " + pays );
                }
            return conseiller;
    }
}
