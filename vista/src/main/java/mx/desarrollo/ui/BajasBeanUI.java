/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.catalogo.entidad.Unidadaprendizaje;
import mx.catalogo.entidad.UsuarioProfesor;
import mx.catalogo.entidad.UsuarioUnidad;
import mx.catalogo.facade.FacadeUnidadaprendizaje;
import mx.catalogo.facade.FacadeUsuarioProfesor;
import mx.catalogo.facade.FacadeUsuarioUnidad;
import mx.desarrollo.helper.AltasHelper;
import mx.desarrollo.helper.BajasHelper;
import mx.desarrollo.ui.consultasBeanUI;
import mx.catalogo.entidad.UsuarioUnidad;

/**
 *
 * @author radam
 */
@ManagedBean(name = "bajasUI")
@SessionScoped
public class BajasBeanUI implements Serializable {

    private Integer idProfesor;
    private Integer idRegistro;
    private BajasHelper bajasHelper;
    private UsuarioProfesor usuarioProfesor;
    private Unidadaprendizaje unidadAprendizaje;
    private UsuarioUnidad usuarioUnidad;
    private consultasBeanUI consultasBean;

    public BajasBeanUI() {
        bajasHelper = new BajasHelper();
    }

    public void init() {
        usuarioProfesor = new UsuarioProfesor();
        unidadAprendizaje = new Unidadaprendizaje();
        usuarioUnidad = new UsuarioUnidad();
        consultasBean = new consultasBeanUI();
    }

    public void redirBajaProfesor() throws IOException {
        String appURL = "/BajaProfesor.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }

    public void redirBajasUsuarioUnidad() throws IOException {
        String appURL = "/BajaUsuarioUnidad.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public void eliminarProfesor() {
        try {
            FacadeUsuarioProfesor facadeProfe = new FacadeUsuarioProfesor();
            FacadeUsuarioUnidad facadeRegis = new FacadeUsuarioUnidad();
            if (facadeProfe.eliminarUsuarioProfesor(idProfesor)) {
                for(UsuarioUnidad ud : consultasBean.listaUsuarioUnidad){
                    if(idProfesor.equals(ud.getIdUsuario())){
                        facadeRegis.eliminarUsuarioUnidad(ud.getIdRegistro());
                    }
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor eliminado exitosamente", "Se ha eliminado el profesor"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error: no se pudo eliminar el profesor", "Verifique que los datos sean correctos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor eliminado exitosamente y tambien sus asignaciones", "Se ha eliminado el profesor"));
        }
    }

    public void eliminarRegistro() {
        try {
            FacadeUsuarioUnidad facadeRegis = new FacadeUsuarioUnidad();
            if (facadeRegis.eliminarUsuarioUnidad(idRegistro)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado exitosamente", "Se ha eliminado el registro"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error: no se pudo eliminar el registro", "Verifique que los datos sean correctos"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar el registro", ""));
        }
    }
}
