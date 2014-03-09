/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.ClientDao;
import dao.DevisDao;
import dao.JpaUtil;
import dao.PaysDao;
import dao.VoyageDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Devis;
import metier.modele.InfoPrincipale;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.modele.Voyage;
import util.Aleatoire;
import util.Saisie;

/**
 *
 * @author Administrateur
 */
public class Service {

    /**
     *
     */
    protected static DateFormat USR_BIRTH_DATE = new SimpleDateFormat("dd-MM-yyyy");
    protected static DateFormat US_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    
    
  
    public static void creerDevis(String CodeVoyage, String addresseMailClient) {
        JpaUtil.ouvrirTransaction();
        Date currentDate = new Date(new GregorianCalendar().getTime().getTime());
        Devis d = new Devis(currentDate, VoyageDao.findVoyageByCodeVoyage(CodeVoyage),
                ClientDao.findClientByMail(addresseMailClient));
                JpaUtil.persist(d);

        JpaUtil.validerTransaction();

        if (choisirConseiller(d)) {
            JpaUtil.ouvrirTransaction();
            d.setNbPersonnes(ChoisirNbPassager());
            d.setChoixCaracteristiques(ChoisirInfoPrincipale(CodeVoyage));
            
            JpaUtil.merge(d);
            d.getClientDevis().addDevis(d);
            JpaUtil.merge(d.getClientDevis());
            System.out.println(afficheDevis(d));
            JpaUtil.validerTransaction();
            
        } else {
            JpaUtil.annulerTransaction();
        }

    }

  
    public static void creerClient(String Civilite, String Nom, String prenom,
            String Date, String Adresse, String telephone, String mail) {
        JpaUtil.ouvrirTransaction();
        Client c = new Client(Civilite, Nom, prenom, parseDateUsFormat(Date), Adresse, telephone, mail);
        
        JpaUtil.persist(c);
        System.out.println(c);
        c.setAutorisationPartenaires(true);
        System.out.println(envoyerMailPartenaires(c));
        
        JpaUtil.validerTransaction();
    }

    

    public static void creerPays(String nom, String code, String continent,
            String capitale, String langues, float superficie, float population,
            String regimePolitique) {
        JpaUtil.ouvrirTransaction();
        Pays p = new Pays(nom, code, nom, capitale, langues, superficie,
                population, regimePolitique);
        
        JpaUtil.persist(p);
        System.out.println(p);
        
        JpaUtil.validerTransaction();
    }

   

    public static void creerConseiller(String Civilite, String Nom, String prenom,
            String Date, String Adresse, String telephone, String mail, String[] CodePaysConseilles) {
        JpaUtil.ouvrirTransaction();
        Conseiller c = new Conseiller(Civilite, Nom, prenom, parseDateUsFormat(Date),
                Adresse, telephone, mail);
        JpaUtil.persist(c);
        System.out.println(c);
        for (int lgtCodePC = 0; lgtCodePC < CodePaysConseilles.length; lgtCodePC++) {
            Pays p = PaysDao.findPaysByCodePays(CodePaysConseilles[lgtCodePC]);
            p.addConseillers(c);
            c.addPays(PaysDao.findPaysByCodePays(CodePaysConseilles[lgtCodePC]));
            JpaUtil.merge(p);
        }
        JpaUtil.merge(c);
        JpaUtil.validerTransaction();
    }

    public static void creerInfoPrincipale(InfoPrincipale info) {
        

    }

    public static void creerInfoPrincipale(String villeDepart, String DateDepart,
            int Prix, String transport, String codeVoyage) {
        JpaUtil.ouvrirTransaction();

        InfoPrincipale iP = new InfoPrincipale(villeDepart,
                parseDateUsFormat(DateDepart), Prix, transport);
        Voyage voyageAssocie = VoyageDao.findVoyageByCodeVoyage(codeVoyage);
        iP.setVoyageAssocie(voyageAssocie);
        
        JpaUtil.persist(iP);
        System.out.println(iP);
        
        voyageAssocie.addInfos(iP);
        JpaUtil.merge(voyageAssocie);
        JpaUtil.validerTransaction();
    }

  
    public static void creerCircuit(String moyenDeTransport, int kilometres,
            String codePays, String codeVoyage, String intitule, int duree,
            String description) {
        JpaUtil.ouvrirTransaction();
        Circuit c = new Circuit(moyenDeTransport, kilometres, codePays, codeVoyage,
                intitule, duree, description);
        Pays pays = PaysDao.findPaysByCodePays(codePays);
        c.setPaysDuVoyage(pays);
        
        JpaUtil.persist(c);
        System.out.println(c);
        
        pays.addVoyage(c);
        JpaUtil.merge(pays);
        JpaUtil.validerTransaction();
    }

    
    public static void creerSejour(String residence, String codePays,
            String codeVoyage, String intitule, int duree, String description) {
        JpaUtil.ouvrirTransaction();
        Sejour s = new Sejour(residence, codePays, codeVoyage, intitule, duree,
                description);
        Pays pays = PaysDao.findPaysByCodePays(codePays);
        s.setPaysDuVoyage(pays);
        
        JpaUtil.persist(s);
        System.out.println(s);
        
        pays.addVoyage(s);
        JpaUtil.merge(pays);
        JpaUtil.validerTransaction();
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

    public static void listerClients() {

        List<Client> clients = ClientDao.listerClients();
        for (int i = 0; i < clients.size(); i++) {

            System.out.print(clients.get(i) + "\n" + clients.get(i).listeDevis());
        }

    }

    public static String envoyerMailPartenaires(Client client) {

        if (client.isAutorisationPartenaires()) {
            String civilite = client.getCivilite();
            String nom = client.getNom();
            String prenom = client.getPrenom();
            String email = client.getEmail();

            return "Nous sommes heureux de vous prévenir de l'adhésion de "
                    + civilite + " " + nom + " " + prenom + " dont l'adresse électronique est "
                    + email + " .";
        }
        return null;

    }

    private static boolean choisirConseiller(Devis d) {
        boolean res = false;
        Conseiller cons = DevisDao.choixConseiller(d);
        if (cons != null) {
            System.out.println(cons);
            d.setConseillerDevis(cons);
            JpaUtil.merge(d);
            res = true;
        }

        return res;

    }

    public static void listerVoyagesParPaysEtType(String nomPays, String type) {

        if (type.equals("Sejour")) {
            List<Sejour> voyages = VoyageDao.listerSejoursParPays(nomPays);
            for (int i = 0; i < voyages.size(); i++) {

                System.out.print(voyages.get(i) + "\n");
            }
            if (voyages.isEmpty()) {
                System.out.println("Aucun séjour pour le pays " + nomPays);
            }
        } else if (type.equals("Circuit")) {
            List<Circuit> voyages = VoyageDao.listerCircuitsParPays(nomPays);
            for (int i = 0; i < voyages.size(); i++) {

                System.out.print(voyages.get(i) + "\n");
            }
            if (voyages.isEmpty()) {
                System.out.println("Aucun Circuit pour le pays " + nomPays);
            }
        } else {
            System.out.println("Choisissez le type Sejour ou Circuit");
        }
    }

    public static void SaisirClient() {

        String[] descriptionClient = new String[7];
        System.out.println("Veuillez écrire : \"CIVILITE\" \"NOM\" \"PRENOM\" "
                + "\"AAAA-JJ-MM\" \"ADRESSE\" \"TELEPHONE\" \"EMAIL\" ");

        descriptionClient[0] = Saisie.lireChaine("CIVILITE\n");
        descriptionClient[1] = Saisie.lireChaine("NOM\n");
        descriptionClient[2] = Saisie.lireChaine("PRENOM\n");
        descriptionClient[3] = Saisie.lireChaine("AAAA-MM-JJ\n");
        descriptionClient[4] = Saisie.lireChaine("ADRESSE\n");
        descriptionClient[5] = Saisie.lireChaine("TELEPHONE\n");
        descriptionClient[6] = Saisie.lireChaine("EMAIL\n");

        creerClient(descriptionClient[0], descriptionClient[1],
                descriptionClient[2], descriptionClient[3], descriptionClient[4],
                descriptionClient[5], descriptionClient[6]);
    }

    public static void SaisirDevis() {

        System.out.println("Veuillez écrire : \"AAAA-JJ-MM\" \"CODEVOYAGE\" \"CODEPAYS\" "
                + "\"CLIENT\" \"NBPERSONNES\" \"CHOIXDEPART\"  ");

        String[] descriptionDevis = new String[2];
        descriptionDevis[0] = Saisie.lireChaine("ADDRESSE EMAIL CLIENT\n");
        descriptionDevis[1] = Saisie.lireChaine("CODE VOYAGE\n");
        creerDevis(descriptionDevis[1], descriptionDevis[0]);
    }

    private static int ChoisirNbPassager() {
        return Aleatoire.random(2, 5);
    }
    
    public static String afficheDevis(Devis d){
        return d.afficheDevis();
    }

    private static InfoPrincipale ChoisirInfoPrincipale(String CodeVoyage) {
        List<InfoPrincipale> lInfosPrincipales = VoyageDao.listerInfos(CodeVoyage);
        if (lInfosPrincipales.size() > 0) {
            int indexInfoPrincipale = Aleatoire.random(0, lInfosPrincipales.size() - 1);
            return lInfosPrincipales.get(indexInfoPrincipale);
        }
        return null;
    }

    private static Date parseDateUsFormat(String date) {
        try {
            return US_DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            return new Date();
        }
    }
}
