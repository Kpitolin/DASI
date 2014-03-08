package metier.modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.InfoPrincipale;
import metier.modele.Pays;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-08T16:55:04")
@StaticMetamodel(Voyage.class)
public abstract class Voyage_ { 

    public static volatile SingularAttribute<Voyage, String> CodePays;
    public static volatile SingularAttribute<Voyage, String> CodeVoyage;
    public static volatile SingularAttribute<Voyage, String> Description;
    public static volatile ListAttribute<Voyage, InfoPrincipale> infos;
    public static volatile SingularAttribute<Voyage, String> Intitule;
    public static volatile SingularAttribute<Voyage, Pays> paysDuVoyage;
    public static volatile SingularAttribute<Voyage, Integer> idVoyage;
    public static volatile SingularAttribute<Voyage, Integer> Duree;

}