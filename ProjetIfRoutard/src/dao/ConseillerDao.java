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
    
    
    
    
    
    
                public static  Conseiller findConseillerById(Integer conseillerId)
        {
            
            Conseiller conseiller = JpaUtil.obtenirEntityManager().find(Conseiller.class , conseillerId);
            if (conseiller == null) {
                throw  new EntityNotFoundException("Can't find client for ID " + conseillerId );
                }
            return conseiller;
        }
    
    
}
