package metier.modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Pays;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2014-02-24T16:24:15")
@StaticMetamodel(Voyage.class)
public abstract class Voyage_ { 

    public static volatile SingularAttribute<Voyage, String> CodePays;
    public static volatile SingularAttribute<Voyage, String> CodeVoyage;
    public static volatile SingularAttribute<Voyage, String> Description;
    public static volatile SingularAttribute<Voyage, String> Intitule;
    public static volatile SingularAttribute<Voyage, Pays> paysDuVoyage;
    public static volatile SingularAttribute<Voyage, Integer> idVoyage;
    public static volatile SingularAttribute<Voyage, Integer> Duree;

}