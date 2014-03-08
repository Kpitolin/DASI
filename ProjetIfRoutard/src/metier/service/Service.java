/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.DevisDao;
import dao.JpaUtil;
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
import util.LectureDonneesCsv;
import util.Saisie;

/**
 *
 * @author Administrateur
 */
public class Service {
    
    /**
     *
     */

    
    public static void creerDevis (Devis d){
        JpaUtil.persist(d);
        System.out.println(d);
       
    }
    public static void creerClient(Client c) {
        
        JpaUtil.persist(c);
        System.out.println(c);
        envoyerMailPartenaires(c);

    }

    public static void creerPays(Pays p) {
        JpaUtil.persist(p);
        System.out.println(p);

    }

    public static void creerConseiller(Conseiller c) {
        JpaUtil.persist(c);
        System.out.println(c);

    }

    public static void creerInfoPrincipale(InfoPrincipale info) {
        JpaUtil.persist(info);
        System.out.println(info);

    }

    public static void creerCircuit(Circuit circuit) {
        JpaUtil.persist(circuit);
        System.out.println(circuit);

    }

    public static void creerSejour(Sejour s) {
        JpaUtil.persist(s);
        System.out.println(s);

    }

    public static void miseAjour(Object o) {
        JpaUtil.merge(o);
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
    d.setConseillerDevis(DevisDao.choixConseiller(d));
    
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
    
    public static void SaisirClient(){
        
        String[] descriptionClient = new String [7];
        System.out.println("Veuillez écrire : \"CIVILITE\" \"NOM\" \"PRENOM\" "
         + "\"AAAA-JJ-MM\" \"ADRESSE\" \"TELEPHONE\" \"EMAIL\" ");
        
        descriptionClient[0] = Saisie.lireChaine("CIVILITE");
        descriptionClient[1] = Saisie.lireChaine("NOM");
        descriptionClient[2] = Saisie.lireChaine("PRENOM");
        descriptionClient[3] = Saisie.lireChaine("AAAA-JJ-MM");
        descriptionClient[4] = Saisie.lireChaine("ADRESSE");
        descriptionClient[5] = Saisie.lireChaine("TELEPHONE");
        descriptionClient[6] = Saisie.lireChaine("EMAIL");
        LectureDonneesCsv.creerClient(descriptionClient);
        
    }
    
        public static void SaisirDevis(){
        
            System.out.println("ne fais rien");
            System.out.println("Veuillez écrire : \"AAAA-JJ-MM\" \"CODEVOYAGE\" \"CODEPAYS\" "
            + "\"CLIENT\" \"NBPERSONNES\" \"CHOIXDEPART\"  ");
        
    }
}
