/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import dao.PaysDao;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.InfoPrincipale;
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
       //ServiceInit.initialisation();
       
       
       

       
       
       
       /*

       


      
       Conseiller toto = new Conseiller("M", "toto", "jean", null , "Lyon", " 060606060606", "toto.jean@insa-lyon.fr");
       
       Fr.addConseillers(toto);
       Service.creerConseiller(toto);
       Service.miseAjourBase(Fr);
       
       System.out.println("COPY : " + PaysDao.findPaysByCodePays("FR"));
       
       */
       // Creation sejours et circuits fictifs
       Sejour s = new Sejour ("Hotel 5 etoiles","FR","FGHJK" ,"Voyage à Meulun" ,3650 , "Une escursion magnifique dans la vielle ville de meulun en bus");
       Service.creerSejour(s);
       System.out.println(s);
     
       Sejour s2 = new Sejour ("Hotel IBIS","BEL","FGHJK" ,"Voyage à ????" ,3650 , " Non def");
       Service.creerSejour(s2);
       System.out.println(s2);
       
       Circuit c = new Circuit ("jeep",11232,"BEL","FGHJK" ,"Visite du plat pays" ,100 , "Vélo et randonée");
       Service.creerCircuit(c);
       System.out.println(c);
       
       Circuit c2 = new Circuit ("jeep",11232,"FR","FGHJK" ,"Visite " ,100 , "randonée");
       Service.creerCircuit(c2);
       System.out.println(c2);
       
       
       // Crea Pays
       float sup = 550;
       float pop = 66;
       Pays Fr = new Pays("France", "FR", "europe", "Paris", "francais", sup, pop, "république");
       Service.creerPays(Fr); 
       
        float supb = 100;
       float popb = 15;
       Pays Bel = new Pays("Belgique", "BEL", "europe", "Bruxelle", "francais, néélanrdais, allemand", supb, popb, "Monarchie");
       Service.creerPays(Bel); 
 
       // Mises a jour des objets persistés
      
       c.setPaysDuVoyage(PaysDao.findPaysByCodePays(c.getCodePays()));
       Service.miseAjourBase(c);
       Bel.addVoyage(c);
        
       c2.setPaysDuVoyage(PaysDao.findPaysByCodePays(c2.getCodePays()));
       Service.miseAjourBase(c2);
       Bel.addVoyage(c2);
       
       InfoPrincipale i  = new InfoPrincipale("Lyon", null, 100, "bus");
       Service.creerInfoPrincipale(i);
       
       s.addInfos(i);
       Service.miseAjourBase(s);
       i.setVoyageAssocie(s);
       Service.miseAjourBase(i);
       
       
       
       s.setPaysDuVoyage(PaysDao.findPaysByCodePays(s.getCodePays()));
       Service.miseAjourBase(s);
       Fr.addVoyage(s);
       
       s2.setPaysDuVoyage(PaysDao.findPaysByCodePays(s2.getCodePays()));
       Service.miseAjourBase(s2);
       Fr.addVoyage(s2);
       
       //tests de listage
       
       System.out.println(" affichages de tous les pays ");
       Service.listerTousLesPays();
      System.out.println(" affichages de tous les voyages ");
       Service.listerTousLesVoyages();
       String paysAffiche = "Belgique";
       System.out.println(" affichages des voyages du pays : "+ paysAffiche);
      Service.listerVoyagesParPays(paysAffiche);
       System.out.println(" affichages des séjour : ");
      Service.listerSejours();
       System.out.println(" affichages des circuits : ");
      Service.listerCircuits();
      System.out.println(" affichages des séjour pour un pays fr : ");
      Service.listerVoyagesParPaysEtType("France", "Sejour");
       System.out.println(" affichages des circuits pour un pays bel : ");
      Service.listerVoyagesParPaysEtType("Belgique", "Circuit");
    }
}
