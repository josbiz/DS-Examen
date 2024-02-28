/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "usuario_profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioProfesor.findAll", query = "SELECT u FROM UsuarioProfesor u")
    , @NamedQuery(name = "UsuarioProfesor.findByIdUsuario", query = "SELECT u FROM UsuarioProfesor u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioProfesor.findByNombreUsuario", query = "SELECT u FROM UsuarioProfesor u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "UsuarioProfesor.findByContrasena", query = "SELECT u FROM UsuarioProfesor u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "UsuarioProfesor.findByRol", query = "SELECT u FROM UsuarioProfesor u WHERE u.rol = :rol")
    , @NamedQuery(name = "UsuarioProfesor.findByNombre", query = "SELECT u FROM UsuarioProfesor u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioProfesor.findByApellido", query = "SELECT u FROM UsuarioProfesor u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "UsuarioProfesor.findByRfc", query = "SELECT u FROM UsuarioProfesor u WHERE u.rfc = :rfc")})
public class UsuarioProfesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "RFC")
    private String rfc;
    @JoinTable(name = "usuario_unidad", joinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "idUnidadAprendizaje", referencedColumnName = "idUnidadAprendizaje")})
    @ManyToMany
    private List<Unidadaprendizaje> unidadaprendizajeList;

    public UsuarioProfesor() {
    }

    public UsuarioProfesor(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioProfesor(Integer idUsuario, String nombreUsuario, String contrasena, String rol, String nombre, String apellido, String rfc) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rfc = rfc;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public List<Unidadaprendizaje> getUnidadaprendizajeList() {
        return unidadaprendizajeList;
    }

    public void setUnidadaprendizajeList(List<Unidadaprendizaje> unidadaprendizajeList) {
        this.unidadaprendizajeList = unidadaprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioProfesor)) {
            return false;
        }
        UsuarioProfesor other = (UsuarioProfesor) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.catalogo.entidad.UsuarioProfesor[ idUsuario=" + idUsuario + " ]";
    }
    
}
