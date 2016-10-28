/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HugoKeniti
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Evento> eventoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFornecedor")
    private Collection<Servico> servicoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Usuarioinfo usuarioinfo;
    @JoinColumn(name = "FK_TIPOPESSOA", referencedColumnName = "ID_TIPOPESSOA")
    @ManyToOne(optional = false)
    private Tipopessoa fkTipopessoa;
    @JoinColumn(name = "FK_TIPOUSUARIO", referencedColumnName = "ID_TIPOUSUARIO")
    @ManyToOne(optional = false)
    private Tipousuario fkTipousuario;
    @OneToMany(mappedBy = "fkPromoter")
    private Collection<Evento> eventoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliente")
    private Collection<Evento> eventoCollection2;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String username, String password) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    public Usuarioinfo getUsuarioinfo() {
        return usuarioinfo;
    }

    public void setUsuarioinfo(Usuarioinfo usuarioinfo) {
        this.usuarioinfo = usuarioinfo;
    }

    public Tipopessoa getFkTipopessoa() {
        return fkTipopessoa;
    }

    public void setFkTipopessoa(Tipopessoa fkTipopessoa) {
        this.fkTipopessoa = fkTipopessoa;
    }

    public Tipousuario getFkTipousuario() {
        return fkTipousuario;
    }

    public void setFkTipousuario(Tipousuario fkTipousuario) {
        this.fkTipousuario = fkTipousuario;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection1() {
        return eventoCollection1;
    }

    public void setEventoCollection1(Collection<Evento> eventoCollection1) {
        this.eventoCollection1 = eventoCollection1;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection2() {
        return eventoCollection2;
    }

    public void setEventoCollection2(Collection<Evento> eventoCollection2) {
        this.eventoCollection2 = eventoCollection2;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
