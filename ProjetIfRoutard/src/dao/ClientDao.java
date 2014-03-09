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
import metier.modele.Client;

/**
 *
 * @author Administrateur
 */
public class ClientDao {
    
    
  
    
        public static  Client findClientById(Integer objectId)
        {
            
            Client client = JpaUtil.obtenirEntityManager().find(Client.class , objectId);
            if (client == null) {
                throw  new EntityNotFoundException("Can't find client for ID " + objectId );
                }
            return client;
        }
        
        public static  Client findClientByMail(String mail)
        {
            
            Query query = JpaUtil.obtenirEntityManager().createQuery("select c from Client c where c.email = :code ");
            query.setParameter("code", mail);
            Client client = (Client) query.getSingleResult();
            if (client == null) {
                throw  new EntityNotFoundException("Can't find client for mail " + mail );
                }
            return client;
        }
        public static List<Client> listerClients() {
        
        Query query = JpaUtil.obtenirEntityManager().createQuery("select c from Client c");

        List<Client> clients = (List<Client>) query.getResultList();
        if (clients == null) {
            throw new EntityNotFoundException("Pas de clients inscrits");
        }
        return clients;
    }
    
    
    
    
    
    
    
    
    
  
    
}
