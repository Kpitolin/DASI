package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Client;
import metier.modele.Pays;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-08T16:55:04")
@StaticMetamodel(Conseiller.class)
public class Conseiller_ { 

    public static volatile SingularAttribute<Conseiller, String> prenom;
    public static volatile ListAttribute<Conseiller, Pays> paysConseilles;
    public static volatile SingularAttribute<Conseiller, Date> dateNaissance;
    public static volatile SingularAttribute<Conseiller, String> adresse;
    public static volatile SingularAttribute<Conseiller, String> email;
    public static volatile SingularAttribute<Conseiller, String> civilite;
    public static volatile SingularAttribute<Conseiller, String> telephone;
    public static volatile SingularAttribute<Conseiller, String> nom;
    public static volatile SingularAttribute<Conseiller, Integer> idConseiller;
    public static volatile ListAttribute<Conseiller, Client> clients;

}