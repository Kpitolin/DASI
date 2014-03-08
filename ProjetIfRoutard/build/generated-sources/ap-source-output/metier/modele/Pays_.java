package metier.modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Conseiller;
import metier.modele.Voyage;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-08T16:55:04")
@StaticMetamodel(Pays.class)
public class Pays_ { 

    public static volatile SingularAttribute<Pays, String> region;
    public static volatile SingularAttribute<Pays, Float> superficie;
    public static volatile SingularAttribute<Pays, String> capitale;
    public static volatile ListAttribute<Pays, Conseiller> conseillers;
    public static volatile SingularAttribute<Pays, String> langues;
    public static volatile SingularAttribute<Pays, Integer> idPays;
    public static volatile SingularAttribute<Pays, String> regimePolitique;
    public static volatile SingularAttribute<Pays, String> code;
    public static volatile SingularAttribute<Pays, String> nom;
    public static volatile SingularAttribute<Pays, Float> population;
    public static volatile ListAttribute<Pays, Voyage> voyages;

}