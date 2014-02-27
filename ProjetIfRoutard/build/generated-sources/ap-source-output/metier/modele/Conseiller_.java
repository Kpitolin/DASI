package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Pays;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2014-02-24T16:24:15")
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

}