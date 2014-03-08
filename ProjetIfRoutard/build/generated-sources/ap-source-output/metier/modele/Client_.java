package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-08T16:55:04")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, Date> dateNaissance;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, Boolean> autorisationPartenaires;
    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile SingularAttribute<Client, String> civilite;
    public static volatile SingularAttribute<Client, String> telephone;
    public static volatile SingularAttribute<Client, String> nom;

}