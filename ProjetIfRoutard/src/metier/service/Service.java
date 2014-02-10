/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.PersisteObjet;
import metier.modele.Client;
import metier.modele.Pays;

/**
 *
 * @author Administrateur
 */
public class Service {
    
    
    
    public static void creerClient (Client c){
        PersisteObjet.persit(c);
        
    }    
   
    
      public static void creerPays (Pays p){
        PersisteObjet.persit(p);
        
    }    
    
    
    
}
