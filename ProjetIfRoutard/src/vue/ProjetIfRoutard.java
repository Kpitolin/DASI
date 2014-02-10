/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import metier.modele.Client;
import metier.service.ServiceInit;
import util.LectureDonneesCsv;
/**
 *
 * @author Administrateur
 */
public class ProjetIfRoutard {

    /**
     * @param args the command line arguments
     */
    public static void afficheClient (Client c){
        System.out.print(c.getCivilite() + " ");
        System.out.print(c.getNom()+" ");
        System.out.println(c.getPrenom());
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       ServiceInit.initialisation();
    }
}
