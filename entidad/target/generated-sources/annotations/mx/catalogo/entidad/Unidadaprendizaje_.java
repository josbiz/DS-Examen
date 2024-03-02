package mx.catalogo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.entidad.UsuarioUnidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-02T13:07:30")
@StaticMetamodel(Unidadaprendizaje.class)
public class Unidadaprendizaje_ { 

    public static volatile SingularAttribute<Unidadaprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasClase;
    public static volatile ListAttribute<Unidadaprendizaje, UsuarioUnidad> usuarioUnidadList;
    public static volatile SingularAttribute<Unidadaprendizaje, String> nombreUnidad;
    public static volatile ListAttribute<Unidadaprendizaje, UsuarioProfesor> usuarioProfesorList;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasTaller;

}