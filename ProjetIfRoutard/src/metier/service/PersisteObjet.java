/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Administrateur
 */
public class PersisteObjet {
    
    
    
    public static void persit (Object o){
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(o);
        tx.commit();
        em.close();
    }
    
        public static void merge (Object o){
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjetIfRoutardPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(o);
        tx.commit();
        em.close();
    }
    
}
