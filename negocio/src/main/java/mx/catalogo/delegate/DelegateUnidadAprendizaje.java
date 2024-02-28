/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.delegate;

import java.util.List;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUnidadAprendizaje {
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Unidadaprendizaje usuario){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(usuario);
    }
    
}
