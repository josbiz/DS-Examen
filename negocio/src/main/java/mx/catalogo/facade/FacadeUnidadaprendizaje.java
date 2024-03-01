/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.facade;

import mx.catalogo.delegate.DelegateUnidadAprendizaje;
import mx.catalogo.entidad.Unidadaprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUnidadaprendizaje {
    
    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadaprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    
    public void guardarUnidadAprendizaje(Unidadaprendizaje unidad){
        if(delegateUnidadAprendizaje.validarUnidadAprendizaje(unidad)){
            delegateUnidadAprendizaje.saveUsario(unidad);
        }
    }
    
}