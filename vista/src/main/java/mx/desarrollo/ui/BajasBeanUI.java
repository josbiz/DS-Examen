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
import mx.catalogo.facade.FacadeUnidadaprendizaje;
import mx.catalogo.facade.FacadeUsuarioProfesor;
import mx.desarrollo.helper.AltasHelper;
import mx.desarrollo.helper.BajasHelper;


/**
 *
 * @author radam
 */
@ManagedBean(name = "bajasUI")
@SessionScoped
public class BajasBeanUI implements Serializable{
    
    private Integer idProfesor;
    private BajasHelper bajasHelper;
    private UsuarioProfesor usuarioProfesor;
    private Unidadaprendizaje unidadAprendizaje;
    
    public BajasBeanUI(){
        bajasHelper = new BajasHelper();
    }
    
    public void init() {
        usuarioProfesor = new UsuarioProfesor();
        unidadAprendizaje = new Unidadaprendizaje();
    }
    
    public void redirBajaProfesor() throws IOException {
        String appURL = "/BajaProfesor.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
    }
    
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void eliminarProfesor() {
        try {
            FacadeUsuarioProfesor facadeProfe = new FacadeUsuarioProfesor();
            if(facadeProfe.eliminarUsuarioProfesor(idProfesor)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor eliminado exitosamente", "Se ha eliminado el profesor"));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error: no se pudo eliminar el profesor", "Verifique que los datos sean correctos"));
            }
        } catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar profesor", "")); 
        }
    }
}
