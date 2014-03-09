/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import metier.modele.Pays;

/**
 *
 * @author Administrateur
 */
public class PaysDao {
    
    
 
 
                   
   public static  Pays findPaysById(Integer paysId)
        {
            
            Pays pays = JpaUtil.obtenirEntityManager().find(Pays.class , paysId);
            if (pays == null) {
                throw  new EntityNotFoundException("Can't find client for ID " + paysId );
                }
            return pays;
        }
    
      public static  Pays findPaysByCodePays(String codePays)
        {
            
            Query query = JpaUtil.obtenirEntityManager().createQuery("select p from Pays p where p.code = :code " );
            query.setParameter("code", codePays);
            Pays pays = (Pays) query.getSingleResult();
            if (pays == null) {
                throw  new EntityNotFoundException("Impossible de trouver un pays avec le code " + codePays );
                }
            return pays;
        }
      
      
          public static  List<Pays> listerPays ()
        {
          
            Query query = JpaUtil.obtenirEntityManager().createQuery("select p from Pays p" );
            
            List<Pays> pays = (List<Pays>) query.getResultList();
            if (pays == null) {
                throw  new EntityNotFoundException("");
                }
            return pays;
        }
      
      
    
}
