/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.desarrollo.helper.AltasHelper;
import mx.catalogo.facade.FacadeUsuarioProfesor;
import mx.catalogo.facade.FacadeUnidadaprendizaje;
import mx.catalogo.entidad.Unidadaprendizaje;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "altasUI")
@SessionScoped
public class AltasBeanUI implements Serializable {

    private AltasHelper altasHelper;
    private UsuarioProfesor usuarioProfesor;
    private Unidadaprendizaje unidadAprendizaje;

    public AltasBeanUI() {
        altasHelper = new AltasHelper();
    }

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo sera la
     * primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init() {
        usuarioProfesor = new UsuarioProfesor();
    }

    public void redirAltaUnidad() throws IOException {
        String appURL = "/AltaUnidad.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }

    public void saveProfesor() {
        FacadeUsuarioProfesor facadeProfe = new FacadeUsuarioProfesor();
        facadeProfe.guardarUsuarioProfesor(usuarioProfesor);
    }
    
    public void saveUnidadAprendizaje() {
        FacadeUnidadaprendizaje facadeUnidad = new FacadeUnidadaprendizaje();
        facadeUnidad.guardarUnidadAprendizaje(unidadAprendizaje);
    }
}
