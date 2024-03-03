/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.facade;

import mx.catalogo.delegate.DelegateUsuarioUnidad;
import mx.catalogo.entidad.UsuarioUnidad;

/**
 *
 * @author alan
 */
public class FacadeUsuarioUnidad {

    private final DelegateUsuarioUnidad delegateUsuarioUnidad;

    public FacadeUsuarioUnidad() {
        this.delegateUsuarioUnidad = new DelegateUsuarioUnidad();
    }

    public Boolean guardarUsuarioUnidad(UsuarioUnidad usuarioUnidad) {
        delegateUsuarioUnidad.saveUsuarioUnidad(usuarioUnidad);
        return true;
    }
    
    public boolean eliminarUsuarioUnidad(Integer idUsuUnidad) {
     try {
            // Verificar si el registro existe antes de intentar eliminar
            UsuarioUnidad usuUnidadExiste = delegateUsuarioUnidad.findById(idUsuUnidad);
            
            if (idUsuUnidad != null) {
                // El profesor existe, intentar eliminar
                delegateUsuarioUnidad.deleteUsuarioUnidad(usuUnidadExiste);
                return true; // Indicar que se eliminó correctamente
            } else {
                // El profesor no existe
                return false; // Indicar que no se pudo eliminar
            }
        } catch (Exception e) {
            // Manejar excepciones, loggear, etc.
            return false; // Indicar que no se pudo eliminar debido a una excepción
        }

}
