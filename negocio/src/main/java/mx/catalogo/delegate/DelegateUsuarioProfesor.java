/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.delegate;

import java.util.List;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.integracion.ServiceLocator;
import mx.catalogo.DAO.UsuarioProfesorDAO;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUsuarioProfesor {
    
    public UsuarioProfesor login(String password, String nombreUsuario, String rol){
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
    
    public boolean validarProfesor(UsuarioProfesor us){
        
        if(us.getIdUsuario() == null || us.getNombreUsuario().equals("") || us.getContrasena().equals("") || us.getRol().equals("") ||
           us.getNombre().equals("") || us.getApellido().equals("") || us.getRfc().equals("")){
            return false;
        }
        else{
            if(us.getRfc().length() < 13){ // Si el RFC es menor a 15 caracteres, no se puede hacer el registro
                return false;
            }
            else{
                UsuarioProfesorDAO usuarioDAO = new UsuarioProfesorDAO();
                UsuarioProfesor profesor = usuarioDAO.find(us.getIdUsuario());
                if(profesor != null){
                    // Significa que ese ID del profesor ya esta asignado
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
