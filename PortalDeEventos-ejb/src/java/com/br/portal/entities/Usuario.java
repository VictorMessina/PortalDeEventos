/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author Victor M
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

    @OneToMany(mappedBy = "fkPromoter")
    private List<Orcamento> orcamentoList;

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
    @ManyToMany(mappedBy = "usuarioList")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFornecedor")
    private List<Servico> servicoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Usuarioinfo usuarioinfo;
    @JoinColumn(name = "FK_TIPOPESSOA", referencedColumnName = "ID_TIPOPESSOA")
    @ManyToOne(optional = false)
    private Tipopessoa fkTipopessoa;
    @JoinColumn(name = "FK_TIPOUSUARIO", referencedColumnName = "ID_TIPOUSUARIO")
    @ManyToOne(optional = false)
    private Tipousuario fkTipousuario;
    @OneToMany(mappedBy = "fkPromoter")
    private List<Evento> eventoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliente")
    private List<Evento> eventoList2;

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
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
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
    public List<Evento> getEventoList1() {
        return eventoList1;
    }

    public void setEventoList1(List<Evento> eventoList1) {
        this.eventoList1 = eventoList1;
    }

    @XmlTransient
    public List<Evento> getEventoList2() {
        return eventoList2;
    }

    public void setEventoList2(List<Evento> eventoList2) {
        this.eventoList2 = eventoList2;
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

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }
    
}
