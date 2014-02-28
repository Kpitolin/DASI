/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.PaysDao;
import dao.VoyageDao;
import java.util.List;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Devis;
import metier.modele.InfoPrincipale;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.modele.Voyage;

/**
 *
 * @author Administrateur
 */
public class Service {

    public static void creerClient(Client c) {
        PersisteObjet.persit(c);
        envoyerMailPartenaires(c);

    }

    public static void creerPays(Pays p) {
        PersisteObjet.persit(p);

    }

    public static void creerConseiller(Conseiller c) {
        PersisteObjet.persit(c);

    }

    public static void creerInfoPrincipale(InfoPrincipale info) {
        PersisteObjet.persit(info);

    }

    public static void creerCircuit(Circuit circuit) {
        PersisteObjet.persit(circuit);

    }

    public static void creerSejour(Sejour s) {
        PersisteObjet.persit(s);

    }

    public static void miseAjourBase(Object o) {
        PersisteObjet.merge(o);
    }

    public static void listerTousLesPays() {

        List<Pays> pays = PaysDao.listerPays();
        for (int i = 0; i < pays.size(); i++) {

            System.out.print(pays.get(i).getNom() + "\n");
        }
    }

    public static void listerTousLesVoyages() {

        List<Voyage> voyages = VoyageDao.listerVoyages();
        for (int i = 0; i < voyages.size(); i++) {

            System.out.print(voyages.get(i) + "\n");
        }
        if (voyages.isEmpty()) {
            System.out.println("Aucun voyage ");
        }
    }

    public static void listerVoyagesParPays(String nomPays) {

        List<Voyage> voyages = VoyageDao.findVoyageByNomPays(nomPays);
        for (int i = 0; i < voyages.size(); i++) {

            System.out.print(voyages.get(i) + "\n");
        }
        if (voyages.isEmpty()) {
            System.out.println("Aucun voyage pour le pays " + nomPays);
        }
    }

    public static void listerSejours() {

        List<Sejour> voyages = VoyageDao.listerSejours();
        for (int i = 0; i < voyages.size(); i++) {

            System.out.print(voyages.get(i) + "\n");
        }
        if (voyages.isEmpty()) {
            System.out.println("Aucun séjour");
        }
    }

    public static void listerCircuits() {

        List<Circuit> voyages = VoyageDao.listerCircuits();
        for (int i = 0; i < voyages.size(); i++) {

            System.out.print(voyages.get(i) + "\n");
        }
        if (voyages.isEmpty()) {
            System.out.println("Aucun circuit");
        }
    }

    
    
    public static void envoyerMailPartenaires(Client client){
        
        if(client.isAutorisationPartenaires()){
             String civilite = client.getCivilite();
        String nom = client.getNom();
        String prenom = client.getPrenom();
        String email = client.getEmail();
        
        System.out.println("Nous sommes heureux de vous prévenir de l'adhésion de "
                +civilite+" " + nom +" "+ prenom + " dont l'adresse électronique est "+
                    email+" ."); 
        }
      
        
        
    }
    public static void choisirConseiller (Devis d) {
        
    
}
    public static void listerVoyagesParPaysEtType(String nomPays, String type) {

        if (type == "Sejour") {
            List<Sejour> voyages = VoyageDao.listerSejoursParPays(nomPays);
            for (int i = 0; i < voyages.size(); i++) {

                System.out.print(voyages.get(i) + "\n");
            }
            if (voyages.isEmpty()) {
                System.out.println("Aucun séjour pour le pays " + nomPays);
            }
        } else if (type == "Circuit") {
            List<Circuit> voyages = VoyageDao.listerCircuitsParPays(nomPays);
            for (int i = 0; i < voyages.size(); i++) {

                System.out.print(voyages.get(i) + "\n");
            }
            if (voyages.isEmpty()) {
                System.out.println("Aucun Circuit pour le pays " + nomPays);
            }
        }
        else
        {
            System.out.println("Choisissez le type Sejour ou Circuit");
        }
    }
}
