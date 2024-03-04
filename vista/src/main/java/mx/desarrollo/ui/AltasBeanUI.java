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
import mx.catalogo.entidad.UsuarioProfesor;
import mx.desarrollo.helper.AltasHelper;
import mx.catalogo.facade.FacadeUsuarioProfesor;
import mx.catalogo.facade.FacadeUnidadaprendizaje;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.facade.FacadeUsuarioUnidad;
import mx.catalogo.entidad.UsuarioUnidad;
import mx.desarrollo.ui.consultasBeanUI;
import mx.catalogo.DAO.UsuarioUnidadDAO;

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
    private UsuarioUnidad usuarioUnidad;
    private Integer idProfesor;
    private Integer idUnidades;
    private consultasBeanUI consultasBean;
    private UsuarioUnidadDAO usunDAO;
    
    private UsuarioUnidad usuariounidad;
    List<UsuarioUnidad> listaUsuarioUnidad = new ArrayList();

    public AltasBeanUI() {
        altasHelper = new AltasHelper();
    }

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo sera la
     * primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init() {
        usunDAO = new UsuarioUnidadDAO();
        usuarioProfesor = new UsuarioProfesor();
        unidadAprendizaje = new Unidadaprendizaje();
        usuarioUnidad = new UsuarioUnidad();
        consultasBean = new consultasBeanUI();
        listaUsuarioUnidad = usunDAO.findAll();
    }

    public void redirAltaUnidad() throws IOException {
        String appURL = "/AltaUnidad.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }

    public void redirAltaProfesor() throws IOException {
        String appURL = "/AltaProfesor.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }
    
    public void redirUsuarioUnidad() throws IOException {
        String appURL = "/AltaUsuarioUnidad.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }

    public void saveProfesor() {
        try {
            FacadeUsuarioProfesor facadeProfe = new FacadeUsuarioProfesor();
            if (facadeProfe.guardarUsuarioProfesor(usuarioProfesor)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Profesor registrado exitosamente", "Se ha registrado el profesor"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error: no se pudo registrar el profesor", "Verifique que los datos esten completos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar unidad", ""));
        }
    }

    public void saveUnidadAprendizaje() {
        
        try {
            FacadeUnidadaprendizaje facadeUnidad = new FacadeUnidadaprendizaje();
            if (facadeUnidad.guardarUnidadAprendizaje(unidadAprendizaje)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Unidad registrada exitosamente", "Se ha registrado la UA"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error: no se pudo registrar la unidad", "Verifique que los datos esten completos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar unidad", ""));
        }
    }

    public void saveUsuarioUnidad() {
        UsuarioUnidad usUn = new UsuarioUnidad();  
        Boolean flag = true;
        usUn.setIdRegistro(0);
        usUn.setIdUsuario(idProfesor);
        usUn.setIdUnidadAprendizaje(idUnidades);
        try {
            for(UsuarioUnidad ud : listaUsuarioUnidad){
                if(idProfesor.equals(ud.getIdUsuario()) && idUnidades.equals(ud.getIdUnidadAprendizaje())) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                FacadeUsuarioUnidad facadeUsuarioUnidad = new FacadeUsuarioUnidad();
                usuarioUnidad = usUn;
                if (facadeUsuarioUnidad.guardarUsuarioUnidad(usUn)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Unidad registrada exitosamente", "Se ha registrado la UA"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error: no se pudo registrar la unidad al profesor", "Verifique que los datos no esten traslapados con otra asignatura"));
                }
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Traslape con otra materia", "Este profesor ya tiene esa materia asginada"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar unidad al profesor", ""));
        }
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    public Integer getIdUnidades() {
        return idUnidades;
    }

    public void setIdUnidades(Integer idUnidades) {
        this.idUnidades = idUnidades;
    }

    /* getters y setters*/
    public UsuarioProfesor getUsuarioProfesor() {
        return usuarioProfesor;
    }

    public void setUsuarioProfesor(UsuarioProfesor usuarioP) {
        this.usuarioProfesor = usuarioP;
    }

    public Unidadaprendizaje getUnidadaprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadaprendizaje(Unidadaprendizaje unidadAp) {
        this.unidadAprendizaje = unidadAp;
    }

    public UsuarioUnidad getUsuarioUnidad() {
        return usuarioUnidad;
    }

    public void setUsuarioUnidad(UsuarioUnidad UsuarioUni) {
        this.usuarioUnidad = UsuarioUni;
    }

}
