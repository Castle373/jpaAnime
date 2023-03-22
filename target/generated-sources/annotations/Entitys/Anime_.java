package Entitys;

import Entitys.Personaje;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-21T17:57:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Anime.class)
public class Anime_ { 

    public static volatile SingularAttribute<Anime, String> cantidadCapitulos;
    public static volatile SingularAttribute<Anime, Integer> id;
    public static volatile ListAttribute<Anime, Personaje> Personaje;
    public static volatile SingularAttribute<Anime, String> nombre;

}