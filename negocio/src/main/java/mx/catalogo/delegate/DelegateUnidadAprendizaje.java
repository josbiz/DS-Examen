/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.delegate;

import java.util.List;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.integracion.ServiceLocator;
import mx.catalogo.DAO.UnidadaprendizajeDAO;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUnidadAprendizaje {

    /**
     * Metodo de ejemplo para guardar Usuario
     *
     * @param usuario de tipo usuario con id 0 para poder que se cree un id
     * nuevo
     */
    public void saveUsario(Unidadaprendizaje usuario) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(usuario);
    }

    public boolean validarUnidadAprendizaje(Unidadaprendizaje unidad) {
    if (unidad.getIdUnidadAprendizaje() == null || unidad.getNombreUnidad() == null || unidad.getHorasClase() == 0
            || unidad.getHorasTaller() == 0 || unidad.getHorasLaboratorio() == 0) {
        return false;
    } else {
        if (unidad.getHorasClase() > 0 || unidad.getHorasTaller() > 0 || unidad.getHorasLaboratorio() > 0) {
            // Si alguna de las horas es mayor que cero, está bien
            UnidadaprendizajeDAO unidadDAO = new UnidadaprendizajeDAO();
            Unidadaprendizaje unidadExistente = unidadDAO.find(unidad.getIdUnidadAprendizaje());
            if (unidadExistente != null) {
                // La unidad académica ya está asignada
                return false;
            } else {
                return true;
            }
        } else {
            // Si todas las horas son iguales a cero, está mal
            return false;
        }

    }
}
