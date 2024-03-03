package mx.catalogo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.entidad.UsuarioUnidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-03T13:35:52")
@StaticMetamodel(UsuarioProfesor.class)
public class UsuarioProfesor_ { 

    public static volatile ListAttribute<UsuarioProfesor, Unidadaprendizaje> unidadaprendizajeList;
    public static volatile SingularAttribute<UsuarioProfesor, Integer> idUsuario;
    public static volatile SingularAttribute<UsuarioProfesor, String> apellido;
    public static volatile ListAttribute<UsuarioProfesor, UsuarioUnidad> usuarioUnidadList;
    public static volatile SingularAttribute<UsuarioProfesor, String> contrasena;
    public static volatile SingularAttribute<UsuarioProfesor, String> nombreUsuario;
    public static volatile SingularAttribute<UsuarioProfesor, String> nombre;
    public static volatile SingularAttribute<UsuarioProfesor, String> rol;
    public static volatile SingularAttribute<UsuarioProfesor, String> rfc;

}