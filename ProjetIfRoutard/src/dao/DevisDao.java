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
    
    public static final int MAXRESULT = 1;
   
    
         // select c from Conseiller e join e.attributDeCPointantC unNom

    public static Conseiller choixConseiller(Devis d){
         
            Query query = JpaUtil.obtenirEntityManager().createQuery("select conseillers from Pays pays join pays.conseillers conseillers where pays.nom = :nomPays and SIZE(conseillers.clients) = (select MIN (SIZE(cons.clients))from Conseiller cons) ")  ;
            query.setParameter("nomPays", d.getVoyageDuDevis().getPaysDuVoyage().getNom());
            //Conseiller conseiller = (Conseiller) query.getSingleResult();
            query.setMaxResults(MAXRESULT);
            
            if (query.getSingleResult() == null) {
                throw  new EntityNotFoundException("Impossible de trouver conseiller pour le pays :  " + d.getVoyageDuDevis().getPaysDuVoyage().getNom() );
                }
            else 
            {
                Conseiller conseiller = (Conseiller) query.getSingleResult();
            }
            
            return conseiller;
    }
}
