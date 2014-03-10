/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import dao.JpaUtil;
import static java.lang.System.exit;
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
    public static void saisieInteractive(){
        for(;;)
       {
           String str = Saisie.lireChaine("Taper D pour renter un devis ou "
                   + "taper C pour créer un client Et Q pour quitter\nTaper LV,"
                   + " LC, ou LP pour lister les voyages, les clients ou les "
                   + "pays\n");
           
           
           if( str.equals("C") || str.equals("c"))
           {
              Service.SaisirClient();
           }
          
           if( str.equals("D") || str.equals("d") )
            { 
              Service.SaisirDevis();
            }
            
           if( str.equals("Q") || str.equals("q") )
            {
                System.out.println("Fin de l'application");
                exit(0);
            }
            if( str.equals("LC") || str.equals("lc") )
            {
               Service.listerClients();
            }
            if( str.equals("LV") || str.equals("lv") )
            {
               Service.listerTousLesVoyages();
            }
            if( str.equals("LP") || str.equals("lp") )
            {
               Service.listerTousLesPays();
            }
            
       }
    }

    public static void main(String[] args) {
        // TODO code application logic here
       
        JpaUtil.creerEntityManager();

        ServiceInit.initialisationPays();
        ServiceInit.initialisationConseiller();
        ServiceInit.initialisationCircuit();
        ServiceInit.initialisationSejour();
        ServiceInit.initialisationInfoPrincipale();
        ServiceInit.initialisationClient(5);
        saisieInteractive();

             
    }
}
