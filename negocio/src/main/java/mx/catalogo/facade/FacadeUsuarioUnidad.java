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

}
