/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.integracion.ServiceFacadeLocator;

/**
 *
 * @author Kevin
 */
public class LoginHelper implements Serializable{
    

    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param correo
     * @param password
     * @return 
     */
    public UsuarioProfesor Login(String correo, String password, String rol){
        return ServiceFacadeLocator.getInstanceFacadeUsuarioProfesor().login(password, correo, rol);
    }
    
    
    
}
