/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.integracion;

import mx.catalogo.DAO.UsuarioProfesorDAO;
import mx.catalogo.DAO.UsuarioUnidadDAO;
import mx.catalogo.DAO.UnidadaprendizajeDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static UsuarioUnidadDAO usuarioProfesorDAO;
    private static UnidadaprendizajeDAO unidadAprendizajeDAO;
    private static UsuarioUnidadDAO usuarioUnidadDAO;
    
    /**
     * se crea la instancia para usuarioProfesor DAO si esta no existe
     */
    public static UsuarioUnidadDAO getInstanceUsuarioProfesorDAO(){
        if(usuarioProfesorDAO == null){
            usuarioProfesorDAO = new UsuarioUnidadDAO();
            return usuarioProfesorDAO;
        } else{
            return usuarioProfesorDAO;
        }
    }
    
    /**
     * se crea la instancia de UnidadAprendizajeDAO si esta no existe
     */
    public static UnidadaprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        if(unidadAprendizajeDAO == null){
            unidadAprendizajeDAO = new UnidadaprendizajeDAO();
            return unidadAprendizajeDAO;
        } else{
            return unidadAprendizajeDAO;
        }
    }
    
     /**
     * se crea la instancia para usuarioUnidad DAO si esta no existe
     */
    public static UsuarioUnidadDAO getInstanceUsuarioUnidadDAO(){
        if(usuarioUnidadDAO == null){
            usuarioUnidadDAO = new UsuarioUnidadDAO();
            return usuarioUnidadDAO;
        } else{
            return usuarioUnidadDAO;
        }
    }
    
}

