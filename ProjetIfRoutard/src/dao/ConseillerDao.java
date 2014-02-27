/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import metier.modele.Conseiller;

/**
 *
 * @author Administrateur
 */
public class ConseillerDao {
    
    
    
    
     public void persistConseiller (Conseiller c){
        ObjectDao.persitObject(c);
    
    }
    
       
    public void mergeConseiller  (Conseiller c){
        ObjectDao.mergeObject(c);
    
    }
    
                public static  Conseiller findConseillerById(Integer conseillerId)
        {
            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
            EntityManager em = emf.createEntityManager();
            Conseiller conseiller = em.find(Conseiller.class , conseillerId);
            if (conseiller == null) {
                throw  new EntityNotFoundException("Can't find client for ID " + conseillerId );
                }
            return conseiller;
        }
    
    
}
