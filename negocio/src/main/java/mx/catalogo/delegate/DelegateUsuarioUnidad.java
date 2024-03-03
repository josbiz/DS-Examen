/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.delegate;

import java.util.List;
import mx.catalogo.entidad.UsuarioUnidad;
import mx.catalogo.integracion.ServiceLocator;
import mx.catalogo.DAO.UsuarioUnidadDAO;

/**
 *
 * @author alan
 */
public class DelegateUsuarioUnidad {

    public void saveUsuarioUnidad(UsuarioUnidad usuarioUnidad) {
        ServiceLocator.getInstanceUsuarioUnidadDAO().save(usuarioUnidad);
    }

    public void deleteUsuarioUnidad(UsuarioUnidad usuarioUnidad) {
        ServiceLocator.getInstanceUsuarioUnidadDAO().delete(usuarioUnidad);
    }

    public boolean validarUsuarioUnidad(UsuarioUnidad usuarioUnidad) {
        // Verificar que los campos obligatorios no estén vacios
        if (usuarioUnidad.getIdUsuario() == null || usuarioUnidad.getIdUnidadAprendizaje() == null) {
            return false;
        } 
        // Si todas las validaciones pasan, retornar true
        return true;
    }
    
    public UsuarioUnidad findById(Integer idUsuarioUnidad) {
        UsuarioUnidadDAO usuarioUnidadDAO = new UsuarioUnidadDAO();
        return usuarioUnidadDAO.find(idUsuarioUnidad);
    }

}
