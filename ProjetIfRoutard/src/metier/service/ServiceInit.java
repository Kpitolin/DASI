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
    
    public static void initialisation () {
        LectureDonneesCsv.initAll();
    }
    
    public static void initialisationPays () {
        LectureDonneesCsv.initPays();
    }
      
    public static void initialisationClient () {
        LectureDonneesCsv.initClient();
    }
    public static void initialisationConseiller () {
        LectureDonneesCsv.initConseillers();
    }
    public static void initialisationCircuit () {
        LectureDonneesCsv.initCircuits();
    }
    public static void initialisationSejour () {
        LectureDonneesCsv.initSejours();
    }
    public static void initialisationInfoPrincipale () {
        LectureDonneesCsv.initDeparts();
    }
    
    
}
