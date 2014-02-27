/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import metier.modele.Client;

/**
 *
 * @author Administrateur
 */
public class ClientDao {
    
    
    public static void persistClient (Client c){
        ObjectDao.persitObject(c);
    
    }
    
       
    public static  void mergeClient (Client c){
        ObjectDao.mergeObject(c);
    
    }
    
        public static  Client findClientById(Integer objectId)
        {
            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
            EntityManager em = emf.createEntityManager();
            Client client = em.find(Client.class , objectId);
            if (client == null) {
                throw  new EntityNotFoundException("Can't find client for ID " + objectId );
                }
            return client;
        }
    
    
    
    
    
    
    
    
    
    
    
  
    
}
