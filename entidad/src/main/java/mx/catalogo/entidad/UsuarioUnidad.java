/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.catalogo.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giselle
 */
@Entity
@Table(name = "usuario_unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioUnidad.findAll", query = "SELECT u FROM UsuarioUnidad u")
    , @NamedQuery(name = "UsuarioUnidad.findByIdRegistro", query = "SELECT u FROM UsuarioUnidad u WHERE u.idRegistro = :idRegistro")})
public class UsuarioUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegistro")
    private Integer idRegistro;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private UsuarioProfesor idUsuario;
    @JoinColumn(name = "idUnidadAprendizaje", referencedColumnName = "idUnidadAprendizaje")
    @ManyToOne
    private Unidadaprendizaje idUnidadAprendizaje;

    public UsuarioUnidad() {
    }

    public UsuarioUnidad(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdUsuario() {
        return idUsuario.getIdUsuario();
    }

    public void setIdUsuario(UsuarioProfesor idUsuario) {
        this.idUsuario.setIdUsuario(idUsuario.getIdUsuario());
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje.getIdUnidadAprendizaje();
    }

    public void setIdUnidadAprendizaje(Unidadaprendizaje idUnidadAprendizaje) {
        this.idUnidadAprendizaje.setIdUnidadAprendizaje( idUnidadAprendizaje.getIdUnidadAprendizaje());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioUnidad)) {
            return false;
        }
        UsuarioUnidad other = (UsuarioUnidad) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.catalogo.entidad.UsuarioUnidad[ idRegistro=" + idRegistro + " ]";
    }
    
}
