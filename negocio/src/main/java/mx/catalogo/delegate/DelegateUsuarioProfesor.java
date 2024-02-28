/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.delegate;

import java.util.List;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUsuarioProfesor {
    
    public UsuarioProfesor login(String password, String nombreUsuario){
        UsuarioProfesor usuario = new UsuarioProfesor();
        List<UsuarioProfesor> usuarios = ServiceLocator.getInstanceUsuarioProfesorDAO().findAll();
        
        for(UsuarioProfesor us:usuarios){
            if(us.getContrasena().equalsIgnoreCase(password) && us.getNombreUsuario().equalsIgnoreCase(nombreUsuario)){
                usuario = us;
            }
        }
        return usuario;
    }
    /**
     * Metodo de ejemplo para guardar Alumno
     * @param alumno de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void saveAlumno(UsuarioProfesor usuarioprofesor){
        ServiceLocator.getInstanceUsuarioProfesorDAO().save(usuarioprofesor);
    }
    
}
