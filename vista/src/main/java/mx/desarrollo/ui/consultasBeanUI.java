/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.catalogo.DAO.UnidadaprendizajeDAO;
import mx.catalogo.DAO.UsuarioProfesorDAO;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.desarrollo.helper.LoginHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "consultasBeanUI")
@SessionScoped
public class consultasBeanUI implements Serializable {

    private Unidadaprendizaje unidadaprendizaje;
    List<Unidadaprendizaje> listaUnidades = new ArrayList();
    
    private UsuarioProfesor usuarioprofesor;
    List<UsuarioProfesor> listaProfes = new ArrayList();

    public consultasBeanUI() {     
    }

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo sera la
     * primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init() {
        unidadaprendizaje = new Unidadaprendizaje();
        usuarioprofesor = new UsuarioProfesor();
        consultas();
    }

    public void consultas(){
        UnidadaprendizajeDAO unidadDao = new UnidadaprendizajeDAO();
        listaUnidades = unidadDao.findAll();
        UsuarioProfesorDAO profeDao = new UsuarioProfesorDAO();
        listaProfes = profeDao.findAll();
    }
    
    public List<Unidadaprendizaje> getListaUnidades() {
        return listaUnidades;
    }
    
    public List<UsuarioProfesor> getListaProfesores(){
        return listaProfes;
    }
    
    /* getters y setters*/
    public Unidadaprendizaje getUnidadaprendizaje() {
        return unidadaprendizaje;
    }

    public void setUnidadaprendizaje(Unidadaprendizaje unidad) {
        this.unidadaprendizaje = unidad;
    }
    
    public UsuarioProfesor getUsuarioProfesor() {
        return usuarioprofesor;
    }

    public void setUsuarioProfesor(UsuarioProfesor usuarioP) {
        this.usuarioprofesor = usuarioP;
    }

}
