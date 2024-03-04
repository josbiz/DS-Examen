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
import mx.catalogo.DAO.UsuarioUnidadDAO;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.entidad.UsuarioUnidad;
import mx.desarrollo.helper.LoginHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "consultasBeanUI")
@SessionScoped
public class consultasBeanUI implements Serializable {
    UsuarioUnidadDAO usuariounidadDao = new UsuarioUnidadDAO();

    private Unidadaprendizaje unidadaprendizaje;
    List<Unidadaprendizaje> listaUnidades = new ArrayList();
    
    private UsuarioProfesor usuarioprofesor;
    List<UsuarioProfesor> listaProfes = new ArrayList();
    
    private UsuarioUnidad usuariounidad;
    List<UsuarioUnidad> listaUsuarioUnidad = new ArrayList();
    List<UsuarioUnidad> listaUsuarioUnidadByID = new ArrayList();
    
    private String idProfesor;

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
        usuariounidad = new UsuarioUnidad();
        idProfesor = "";
        consultas();
    }

    public void consultas(){
        UnidadaprendizajeDAO unidadDao = new UnidadaprendizajeDAO();
        listaUnidades = unidadDao.findAll();
        UsuarioProfesorDAO profeDao = new UsuarioProfesorDAO();
        listaProfes = profeDao.findAll();
        ordenarPorNombre(listaProfes);
        listaUsuarioUnidad = usuariounidadDao.findAll();
    }
    
    public void redirPanelUnidadesProfesor() throws IOException {
        listaUsuarioUnidadByID = usuariounidadDao.findByOneParameter(idProfesor,"idUsuario");
        String appURL = "/PanelUnidadesProfesor.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }
    
    public List<Unidadaprendizaje> getListaUnidades() {
        return listaUnidades;
    }
    
    public List<UsuarioProfesor> getListaProfesores(){
        return listaProfes;
    }
    
    public static void ordenarPorNombre(List<UsuarioProfesor> lista) {
        int n = lista.size();
        UsuarioProfesor temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getNombre().compareTo(lista.get(j + 1).getNombre()) > 0) {
                    // Intercambiar elementos si están en el orden incorrecto
                    temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
    
    public List<UsuarioUnidad> getListaUsuarioUnidades() {
        return listaUsuarioUnidad;
    }
    
    public List<UsuarioUnidad> getListaUsuarioUnidadesbByID() {
        return listaUsuarioUnidadByID;
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
    
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

}
