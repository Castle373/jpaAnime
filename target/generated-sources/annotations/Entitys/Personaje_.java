package Entitys;

import Entitys.Anime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-21T17:57:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Personaje.class)
public class Personaje_ { 

    public static volatile SingularAttribute<Personaje, String> descripcion;
    public static volatile SingularAttribute<Personaje, Long> id;
    public static volatile SingularAttribute<Personaje, String> nombre;
    public static volatile SingularAttribute<Personaje, Anime> anime;

}