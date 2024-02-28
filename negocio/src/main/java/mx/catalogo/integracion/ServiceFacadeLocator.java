/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.integracion;

import mx.catalogo.facade.FacadeUsuarioProfesor;
import mx.catalogo.facade.FacadeUnidadaprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeUsuarioProfesor facadeUsuarioProfesor;
    private static FacadeUnidadaprendizaje facadeUnidadaprendizaje;
    
    public static FacadeUsuarioProfesor getInstanceFacadeUsuarioProfesor() {
        if (facadeUsuarioProfesor == null) {
            facadeUsuarioProfesor = new FacadeUsuarioProfesor();
            return facadeUsuarioProfesor;
        } else {
            return facadeUsuarioProfesor;
        }
    }
    
    public static FacadeUnidadaprendizaje getInstanceFacadeUnidadaprendizaje() {
        if (facadeUnidadaprendizaje == null) {
            facadeUnidadaprendizaje = new FacadeUnidadaprendizaje();
            return facadeUnidadaprendizaje;
        } else {
            return facadeUnidadaprendizaje;
        }
    }
}
