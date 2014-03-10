/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import util.LectureDonneesCsv;

/**
 *
 * @author Administrateur
 */
public class ServiceInit {

    /**
     * Initialise toute la base de données.
     */
    public static void initialisation() {
        LectureDonneesCsv.initAll();
    }

    public static void initialisationPays() {
        LectureDonneesCsv.initPays();
    }

    public static void initialisationPays(int nbLignes) {
        LectureDonneesCsv.initPays(nbLignes);
    }

    public static void initialisationClient() {
        LectureDonneesCsv.initClient();
    }

    public static void initialisationClient(int nbLignes) {
        LectureDonneesCsv.initClient(nbLignes);
    }

    public static void initialisationConseiller() {
        LectureDonneesCsv.initConseillers();
    }

    public static void initialisationConseiller(int nbLignes) {
        LectureDonneesCsv.initConseillers(nbLignes);
    }

    public static void initialisationCircuit() {
        LectureDonneesCsv.initCircuits();
    }

    public static void initialisationCircuit(int nbLignes) {
        LectureDonneesCsv.initCircuits(nbLignes);
    }

    public static void initialisationSejour() {
        LectureDonneesCsv.initSejours();
    }

    public static void initialisationSejour(int nbLignes) {
        LectureDonneesCsv.initSejours(nbLignes);
    }

    public static void initialisationInfoPrincipale() {
        LectureDonneesCsv.initDeparts();
    }

    public static void initialisationInfoPrincipale(int nbLignes) {
        LectureDonneesCsv.initDeparts(nbLignes);
    }

}
