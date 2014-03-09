/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import metier.modele.InfoPrincipale;

/**
 *
 * @author KEV
 */
public class InfoPrincipaleDao {
    
    
    
    
       public static InfoPrincipale findInfoByCodeInfo(String codeInfo) {
        
        Query query = JpaUtil.obtenirEntityManager().createQuery("select i from InfoPrincipale i where i.codeInfoPrincipale = :code ");
        query.setParameter("code", codeInfo);
        InfoPrincipale voyage = (InfoPrincipale) query.getSingleResult();
        if (voyage == null) {
            throw new EntityNotFoundException("Can't find informations for code " + codeInfo);
        }
        return voyage;
    }
    
    
    
    
    
    
    
}
