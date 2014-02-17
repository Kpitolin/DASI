/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Pays;
import metier.modele.Sejour;

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
    
       
     
      public static void creerConseiller (Conseiller c){
        PersisteObjet.persit(c);
        
    }  
      
      
      
      
      public static void creerCircuit (Circuit circuit){
        PersisteObjet.persit(circuit);
        
    }  
      
       public static void creerSejour (Sejour s){
        PersisteObjet.persit(s);
        
    }  
    
}
