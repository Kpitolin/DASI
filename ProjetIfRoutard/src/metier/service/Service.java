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
    
    public static void creerDevis (Devis d){
        JpaUtil.persist(d);
        System.out.println(d);
       
    }
    
    public static void creerDevis(String CodeVoyage, String addresseMailClient)
         {
             Date currentDate = new Date(new GregorianCalendar().getTime().getTime());
             Devis d = new Devis (currentDate,VoyageDao.findVoyageByCodeVoyage(CodeVoyage),
                     ClientDao.findClientByMail(addresseMailClient));
             creerDevis(d);
             d.setNbPersonnes(ChoisirNbPassager());
             d.setChoixCaracteristiques(ChoisirInfoPrincipale(CodeVoyage));
             Service.choisirConseiller(d);
             JpaUtil.merge(d);
             d.getClientDevis().addDevis(d);
             JpaUtil.merge(d.getClientDevis());
         }
         
    public static void creerClient(Client c) {
        
        JpaUtil.persist(c);
        System.out.println(c);
        envoyerMailPartenaires(c);

    }
    
    public static void creerClient (String Civilite, String Nom, String prenom, 
             String Date, String Adresse, String telephone, String mail)
    {
        Client c = new Client(Civilite, Nom, prenom, parseDate(Date), Adresse, telephone, mail);
        creerClient(c);
    }

    public static void creerPays(Pays p) {
        JpaUtil.persist(p);
        System.out.println(p);

    }

    public static void creerPays(String nom, String code, String continent, 
            String capitale, String langues, float superficie, float population,
            String regimePolitique)
    {
        Pays p = new Pays(nom, code, nom, capitale, langues, superficie, 
                population, regimePolitique);
        creerPays(p);
    }
             
    public static void creerConseiller(Conseiller c) {
        JpaUtil.persist(c);
        System.out.println(c);

    }
  
     public static void creerConseiller(String Civilite, String Nom, String prenom, 
             String Date, String Adresse, String telephone, String mail, String[] CodePaysConseilles) 
     {
         Conseiller c = new Conseiller(Civilite, Nom, prenom, parseDate(Date),
                 Adresse, telephone, mail);
         creerConseiller(c);
         for (int lgtCodePC = 0; lgtCodePC < CodePaysConseilles.length; lgtCodePC++)
         {
             Pays p =PaysDao.findPaysByCodePays(CodePaysConseilles[lgtCodePC]);
             p.addConseillers(c);
             c.addPays(PaysDao.findPaysByCodePays(CodePaysConseilles[lgtCodePC]));
             JpaUtil.merge(p);
         }
         JpaUtil.merge(c);         
         
     }
    public static void creerInfoPrincipale(InfoPrincipale info) {
        JpaUtil.persist(info);
        System.out.println(info);

    }

    public static void creerInfoPrincipale(String villeDepart, String DateDepart,
            int Prix, String transport, String codeVoyage)
    {
        InfoPrincipale iP = new InfoPrincipale(villeDepart, parseDate(DateDepart),
                Prix, transport);
        Voyage voyageAssocie = VoyageDao.findVoyageByCodeVoyage(codeVoyage);
        iP.setVoyageAssocie(voyageAssocie);
        creerInfoPrincipale(iP);
        voyageAssocie.addInfos(iP);
        JpaUtil.merge(voyageAssocie);
    }
    public static void creerCircuit(Circuit circuit) {
        JpaUtil.persist(circuit);
        System.out.println(circuit);

    }
    //public static void creerCircuit(Circuit circuit)
    {
        
    }
    
    public static void creerSejour(Sejour s) {
        JpaUtil.persist(s);
        System.out.println(s);

    }

    public static void creerSejour(String residence, String codePays, 
            String codeVoyage, String intitule,int duree, String description )
    {
       Sejour s = new Sejour(residence, codePays, codeVoyage, intitule, duree,
               description);
       Pays pays = PaysDao.findPaysByCodePays(codePays);
       s.setPaysDuVoyage(pays);
        creerSejour(s);
        pays.addVoyage(s);
        JpaUtil.merge(pays);
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

     public static void listerClients() {

        List<Client> clients = ClientDao.listerClients();
        for (int i = 0; i < clients.size(); i++) {

            System.out.print(clients.get(i) + "\n" + clients.get(i).listeDevis());
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
        Conseiller cons = DevisDao.choixConseiller(d);
        System.out.println(cons);
        d.setConseillerDevis(cons);
    
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
        
        descriptionClient[0] = Saisie.lireChaine("CIVILITE\n");
        descriptionClient[1] = Saisie.lireChaine("NOM\n");
        descriptionClient[2] = Saisie.lireChaine("PRENOM\n");
        descriptionClient[3] = Saisie.lireChaine("JJ-MM-AAAA\n");
        descriptionClient[4] = Saisie.lireChaine("ADRESSE\n");
        descriptionClient[5] = Saisie.lireChaine("TELEPHONE\n");
        descriptionClient[6] = Saisie.lireChaine("EMAIL\n");

        
        creerClient(descriptionClient[0],descriptionClient[1],
                descriptionClient[2],descriptionClient[3],descriptionClient[4],
                descriptionClient[5], descriptionClient[6]);
    }
    
        public static void SaisirDevis(){
        
            System.out.println("Veuillez écrire : \"AAAA-JJ-MM\" \"CODEVOYAGE\" \"CODEPAYS\" "
            + "\"CLIENT\" \"NBPERSONNES\" \"CHOIXDEPART\"  ");
            
            String [] descriptionDevis = new String [2];
            descriptionDevis[0] = Saisie.lireChaine("ADDRESSE EMAIL CLIENT\n");
            descriptionDevis[1] = Saisie.lireChaine("CODE VOYAGE\n");
            creerDevis(descriptionDevis[1], descriptionDevis[0]);
    }
        public static int ChoisirNbPassager()
        {
          return Aleatoire.random(2, 5);
        }
        
        public static InfoPrincipale ChoisirInfoPrincipale(String CodeVoyage)
        {
            List<InfoPrincipale> lInfosPrincipales = VoyageDao.listerInfos(CodeVoyage);
            if (lInfosPrincipales.size() > 0)
            {
                int indexInfoPrincipale = Aleatoire.random(0, lInfosPrincipales.size());
                return lInfosPrincipales.get(indexInfoPrincipale-1);
            }
            return null;
        }
        
        
         public static Date parseDate(String date) {
        try {
            return USR_BIRTH_DATE.parse(date);
        } catch (ParseException ex) {
            return new Date();
            }
        }
         
}
