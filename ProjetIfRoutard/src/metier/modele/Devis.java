/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author KEV
 */
@Entity
public class Devis {

 @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDevis;    
    
    
}
