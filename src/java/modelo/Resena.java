/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sg
 */
@Entity
@Table(name = "RESENA")
@NamedQueries({
    @NamedQuery(name = "Resena.findAll", query = "SELECT r FROM Resena r"),
    @NamedQuery(name = "Resena.findByCalificacion", query = "SELECT r FROM Resena r WHERE r.calificacion = :calificacion"),
    @NamedQuery(name = "Resena.findByTexto", query = "SELECT r FROM Resena r WHERE r.texto = :texto"),
    @NamedQuery(name = "Resena.findByFecha", query = "SELECT r FROM Resena r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Resena.findByUsuarioescrito", query = "SELECT r FROM Resena r WHERE r.usuarioescrito = :usuarioescrito")})
public class Resena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION")
    private double calificacion;
    @Size(max = 255)
    @Column(name = "TEXTO")
    private String texto;
    @Size(max = 20)
    @Column(name = "FECHA")
    private String fecha;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIOESCRITO")
    private Integer usuarioescrito;
    @JoinColumn(name = "USUARIOPROFESOR", referencedColumnName = "CODIGO")
    @ManyToOne
    private Usuario usuarioprofesor;
    @JoinColumn(name = "USUARIOESCRITO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Resena() {
    }

    public Resena(Integer usuarioescrito) {
        this.usuarioescrito = usuarioescrito;
    }

    public Resena(Integer usuarioescrito, double calificacion) {
        this.usuarioescrito = usuarioescrito;
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getUsuarioescrito() {
        return usuarioescrito;
    }

    public void setUsuarioescrito(Integer usuarioescrito) {
        this.usuarioescrito = usuarioescrito;
    }

    public Usuario getUsuarioprofesor() {
        return usuarioprofesor;
    }

    public void setUsuarioprofesor(Usuario usuarioprofesor) {
        this.usuarioprofesor = usuarioprofesor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioescrito != null ? usuarioescrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resena)) {
            return false;
        }
        Resena other = (Resena) object;
        if ((this.usuarioescrito == null && other.usuarioescrito != null) || (this.usuarioescrito != null && !this.usuarioescrito.equals(other.usuarioescrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Resena[ usuarioescrito=" + usuarioescrito + " ]";
    }
    
}
