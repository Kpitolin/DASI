/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import dao.PaysDao;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.service.Service;
import metier.service.ServiceInit;
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
       
       
       
       Sejour s = new Sejour ("Hotel 5 etoiles","GHU","FGHJK" ,"Voyage en Australie" ,100 , "Bien");
       Service.creerSejour(s);
       System.out.println(s);
       
       
       
       
       Circuit c = new Circuit ("jeep",11232,"GHU","FGHJK" ,"Voyage en Australie" ,100 , "Bien");
       Service.creerCircuit(c);
       System.out.println(c);
       System.out.println("COPY : " + PaysDao.findPaysById(4));
       
       
    }
}
