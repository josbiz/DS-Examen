/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        UsuarioProfesor usuario = new UsuarioProfesor();
        
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuarioProfesor().login("contrasena123","nuevoProfesor", "profesor");
        
        if(usuario.getIdUsuario() != null){
            System.out.println("Login exitoso con el usuario: " + usuario.getNombreUsuario());
            System.out.println("Rol: " + usuario.getRol());
        }else{
            System.out.println("No se encontro registro");
        }
    }
}
