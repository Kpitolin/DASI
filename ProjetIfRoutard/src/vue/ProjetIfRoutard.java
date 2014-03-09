/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import dao.JpaUtil;
import dao.PaysDao;
import static java.lang.System.exit;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Devis;
import metier.modele.InfoPrincipale;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.service.Service;
import metier.service.ServiceInit;
import util.Saisie;
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
       
       
       
       

       
       
       
       /*

       


      
       Conseiller toto = new Conseiller("M", "toto", "jean", null , "Lyon", " 060606060606", "toto.jean@insa-lyon.fr");
       
       Fr.addConseillers(toto);
       Service.creerConseiller(toto);
       Service.miseAjourBase(Fr);
       
       System.out.println("COPY : " + PaysDao.findPaysByCodePays("FR"));
       
       */
       // Creation sejours et circuits fictifs
        
        
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        
        ServiceInit.initialisation();
        
       Sejour s = new Sejour ("Hotel 5 etoiles","FR","FGHJK" ,"Voyage à Meulun" ,3650 , "Une escursion magnifique dans la vielle ville de meulun en bus");
       Service.creerSejour(s);
     
       Sejour s2 = new Sejour ("Hotel IBIS","BEL","FGHJK" ,"Voyage à ????" ,3650 , " Non def");
       Service.creerSejour(s2);
       
       Circuit c = new Circuit ("jeep",11232,"BEL","FGHJK" ,"Visite du plat pays" ,100 , "Vélo et randonée");
       Service.creerCircuit(c);
       
       Circuit c2 = new Circuit ("jeep",11232,"FR","FGHJK" ,"Visite " ,100 , "randonée");
       Service.creerCircuit(c2);
       
       
       // Crea Pays
       float sup = 550;
       float pop = 66;
       Pays Fr = new Pays("France", "FR", "europe", "Paris", "francais", sup, pop, "république");
       Service.creerPays(Fr); 
       
       float supb = 100;
       float popb = 15;
       Pays Bel = new Pays("Belgique", "BEL", "europe", "Bruxelle", "francais, néélanrdais, allemand", supb, popb, "Monarchie");
       Service.creerPays(Bel); 
       
       JpaUtil.validerTransaction();
       // Mises a jour des objets persistés
       JpaUtil.ouvrirTransaction();

       c.setPaysDuVoyage(PaysDao.findPaysByCodePays(c.getCodePays()));
       Service.miseAjour(c);
       Bel.addVoyage(c);
        
       c2.setPaysDuVoyage(PaysDao.findPaysByCodePays(c2.getCodePays()));
       Service.miseAjour(c2);
       Bel.addVoyage(c2);
       
       InfoPrincipale i  = new InfoPrincipale("Lyon", null, 100, "bus");
       Service.creerInfoPrincipale(i);
       
       s.addInfos(i);
       Service.miseAjour(s);
       i.setVoyageAssocie(s);
       Service.miseAjour(i);
      
       
       
       s.setPaysDuVoyage(PaysDao.findPaysByCodePays(s.getCodePays()));
       Service.miseAjour(s);
       Fr.addVoyage(s);
       
       s2.setPaysDuVoyage(PaysDao.findPaysByCodePays(s2.getCodePays()));
       Service.miseAjour(s2);
       Fr.addVoyage(s2);
       
        Conseiller toto = new Conseiller("M", "toto", "jean", null , "Lyon", " 060606060606", "toto.jean@insa-lyon.fr");
        Conseiller tito = new Conseiller("M", "titi", "tata", null , "Lyon", " 060606060606", "titi.jean@insa-lyon.fr");

       Fr.addConseillers(toto);
       Bel.addConseillers(tito);
       Bel.addConseillers(toto);
       Service.creerConseiller(toto);
       Service.creerConseiller(tito);
       Service.miseAjour(Fr);
       Service.miseAjour(Bel);
       Client clientBelge = new Client("Mme", "Hamne", "pascale", null, null, null, null);
       Service.creerClient(clientBelge);
        Devis d = new Devis (null,c2,clientBelge);
       Service.creerDevis(d);
       
       
       JpaUtil.validerTransaction();
       // Mises a jour des objets persistés
       JpaUtil.ouvrirTransaction();
       
       
       //Service.choisirConseiller(d);
       
       JpaUtil.validerTransaction();
       
       for(;;)
       {
           String str = Saisie.lireChaine("Taper D pour renter un devis ou taper C pour créer un client Et Q pour quitter\n");
           System.out.println("");
           
           if( str.equals("C") || str.equals("c"))
           {
              JpaUtil.ouvrirTransaction(); 
              Service.SaisirClient();
              JpaUtil.validerTransaction();   
           }
          
           if( str.equals("D") || str.equals("d") )
            { 
              JpaUtil.ouvrirTransaction(); 
              Service.SaisirDevis();
              JpaUtil.validerTransaction();
            }
            
           if( str.equals("Q") || str.equals("q") )
            {
                System.out.println("Fin de l'application");
                exit(0);
            }
       }
       //tests de listage
       
       /* System.out.println(" affichages de tous les pays ");
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
      Service.listerVoyagesParPaysEtType("Belgique", "Circuit");*/
       
       
    }
}
