/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.facade;

import mx.catalogo.delegate.DelegateUsuarioProfesor;
import mx.catalogo.entidad.UsuarioProfesor;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUsuarioProfesor {
    
    private final DelegateUsuarioProfesor delegateUsuarioProfesor;

    public FacadeUsuarioProfesor() {
        this.delegateUsuarioProfesor = new DelegateUsuarioProfesor();
    }
    public UsuarioProfesor login(String password, String nombreUsuario, String rol){
        return delegateUsuarioProfesor.login(password, nombreUsuario, rol);
    }
    public Boolean guardarUsuarioProfesor(UsuarioProfesor usuarioProfesor){
        if(delegateUsuarioProfesor.validarProfesor(usuarioProfesor)){
            delegateUsuarioProfesor.saveAlumno(usuarioProfesor);
            return true;
        }
        else{
            return false;
        }
    }
    
}