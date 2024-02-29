package mx.catalogo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.catalogo.entidad.UsuarioProfesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-02-28T22:03:25")
@StaticMetamodel(Unidadaprendizaje.class)
public class Unidadaprendizaje_ { 

    public static volatile SingularAttribute<Unidadaprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasClase;
    public static volatile SingularAttribute<Unidadaprendizaje, String> nombreUnidad;
    public static volatile ListAttribute<Unidadaprendizaje, UsuarioProfesor> usuarioProfesorList;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasTaller;

}