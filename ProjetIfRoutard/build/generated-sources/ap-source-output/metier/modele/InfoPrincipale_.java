package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Voyage;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-08T16:55:04")
@StaticMetamodel(InfoPrincipale.class)
public class InfoPrincipale_ { 

    public static volatile SingularAttribute<InfoPrincipale, String> Transport;
    public static volatile SingularAttribute<InfoPrincipale, Date> dateDepart;
    public static volatile SingularAttribute<InfoPrincipale, Voyage> voyageAssocie;
    public static volatile SingularAttribute<InfoPrincipale, Integer> IdInfoPrincipale;
    public static volatile SingularAttribute<InfoPrincipale, String> villeDepart;
    public static volatile SingularAttribute<InfoPrincipale, Integer> tarif;

}