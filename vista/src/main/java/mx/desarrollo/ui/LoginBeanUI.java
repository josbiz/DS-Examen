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
import mx.desarrollo.helper.LoginHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {

    private LoginHelper loginHelper;
    private UsuarioProfesor usuarioProfesor;

    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo sera la
     * primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init() {
        usuarioProfesor = new UsuarioProfesor();
    }

    public void login() throws IOException {
        String appURL = "";
        // los atributos de usuario vienen del xhtml 
        UsuarioProfesor usP = new UsuarioProfesor();
        usP.setIdUsuario(0);
        usP = loginHelper.Login(usuarioProfesor.getNombreUsuario(), usuarioProfesor.getContrasena(), usuarioProfesor.getRol());
        if (usP != null && usP.getIdUsuario() != null) {
            // asigno el usuario encontrado al usuario de esta clase para que 
            // se muestre correctamente en la pagina de informacion
            usuarioProfesor = usP;
            if (usuarioProfesor.getRol().equals("profesor")) {
                appURL = "/PanelUnidadAcademica.xhtml";
            } else if (usuarioProfesor.getRol().equals("administrador")) {
                // appURL = "/PanelProfesor.xhtml";
                appURL = "/indexAdmin.xhtml";
            }
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o contraseña incorrecta:", "Intente de nuevo"));
        }
    }

    /* getters y setters*/
    public UsuarioProfesor getUsuarioProfesor() {
        return usuarioProfesor;
    }

    public void setUsuarioProfesor(UsuarioProfesor usuarioP) {
        this.usuarioProfesor = usuarioP;
    }

}
