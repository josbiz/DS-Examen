/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.integracion.ServiceFacadeLocator;

import mx.catalogo.entidad.UsuarioUnidad;
import mx.catalogo.DAO.UsuarioUnidadDAO;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        UsuarioProfesor usuario = new UsuarioProfesor();
        
        List<UsuarioUnidad> listaUsuarioUnidad = new ArrayList();
        UsuarioUnidadDAO usuariounidadDao = new UsuarioUnidadDAO();
        
        /*usuario = ServiceFacadeLocator.getInstanceFacadeUsuarioProfesor().login("contrasena123","nuevoProfesor", "profesor");
        
        if(usuario.getIdUsuario() != null){
            System.out.println("Login exitoso con el usuario: " + usuario.getNombreUsuario());
            System.out.println("Rol: " + usuario.getRol());
        }else{
            System.out.println("No se encontro registro");
        }*/
        
        /*listaUsuarioUnidad = usuariounidadDao.findByOneParameter("1","idUsuario");
        for (UsuarioUnidad usuarioUnidad : listaUsuarioUnidad) {
            System.out.println(usuarioUnidad.toString());
        }*/
        
        listaUsuarioUnidad = usuariounidadDao.findAll();
        Integer idProfesor = 2;
        Integer idUnidades = 2;
        
        for(UsuarioUnidad ud : listaUsuarioUnidad){
            if(idProfesor.equals(ud.getIdUsuario()) && idUnidades.equals(ud.getIdUnidadAprendizaje())) {
                System.out.println("idProfesor: " + idProfesor);
                System.out.println("idUnidades: " + idUnidades);
                System.out.println("ud.getIdUsuario(): " + ud.getIdUsuario());
                System.out.println("ud.getIdUnidadAprendizaje(): " + ud.getIdUnidadAprendizaje());
                break;
            }
        }
        
    }
}
