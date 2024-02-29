/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author josbt
 */
@ManagedBean(name = "returnsUI")
@SessionScoped
public class ReturnBeanUI implements Serializable{
    public ReturnBeanUI() {
        
    }
    
    @PostConstruct
    public void init() {
    }
    
    public void Return() throws IOException {
        String returnURL = "/PanelUnidadAcademica.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(returnURL);
    }
}
