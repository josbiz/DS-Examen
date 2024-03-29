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
    UnidadaprendizajeDAO unidadaprendizajeDao = new UnidadaprendizajeDAO();

    private Unidadaprendizaje unidadaprendizaje;
    List<Unidadaprendizaje> listaUnidades = new ArrayList();

    private UsuarioProfesor usuarioprofesor;
    List<UsuarioProfesor> listaProfes = new ArrayList();

    private UsuarioUnidad usuariounidad;
    List<UsuarioUnidad> listaUsuarioUnidad = new ArrayList();
    List<UsuarioUnidad> listaUsuarioUnidadByID = new ArrayList();
    List<Unidadaprendizaje> listaNombresUnidades = new ArrayList();

    private Integer idProfesor;

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
        idProfesor = 0;
        consultas();
    }

    public void consultas() {
        UnidadaprendizajeDAO unidadDao = new UnidadaprendizajeDAO();
        listaUnidades = unidadDao.findAll();
        UsuarioProfesorDAO profeDao = new UsuarioProfesorDAO();
        listaProfes = profeDao.findAll();
        ordenarPorNombre(listaProfes);
        listaUsuarioUnidad = usuariounidadDao.findAll();
    }

    public void getUnidadesDeProfesor(Integer idProfesor) {
        listaUsuarioUnidadByID = usuariounidadDao.findByOneParameter(idProfesor.toString(), "idUsuario");
        listaNombresUnidades.clear();
        for (UsuarioUnidad usuarioUnidades : listaUsuarioUnidadByID) {
            listaNombresUnidades.addAll(unidadaprendizajeDao.findByOneParameter(usuarioUnidades.getIdUnidadAprendizaje().toString(), "idUnidadAprendizaje"));
        }
    }
    
    public void redirPanelUnidadesProfesor(Integer idProfesor) throws IOException {
        getUnidadesDeProfesor(idProfesor);
        String appURL = "/PanelUnidadesProfesor.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }

    public List<Unidadaprendizaje> getListaUnidades() {
        return listaUnidades;
    }

    public List<UsuarioProfesor> getListaProfesores() {
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

    public String obtenerNombreProfesor(int idProfesor) {
        for (UsuarioProfesor profesor : listaProfes) {
            if (profesor.getIdUsuario() == idProfesor) {
                return profesor.getNombre();
            }
        }
        return "";
    }

    public String obtenerNombreUnidad(int idUnidad) {
        for (Unidadaprendizaje unidad : listaUnidades) {
            if (unidad.getIdUnidadAprendizaje() == idUnidad) {
                return unidad.getNombreUnidad();
            }
        }
        return "";
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
        return idProfesor.toString();
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public List<Unidadaprendizaje> getListaNombresUnidades() {
        return listaNombresUnidades;
    }

    public void setListaNombresUnidades(List<Unidadaprendizaje> listaNombresUnidades) {
        this.listaNombresUnidades = listaNombresUnidades;
    }
}
