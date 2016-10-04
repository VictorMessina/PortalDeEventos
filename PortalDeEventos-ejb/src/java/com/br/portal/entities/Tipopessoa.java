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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor M
 */
@Entity
@Table(name = "TIPOPESSOA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopessoa.findAll", query = "SELECT t FROM Tipopessoa t"),
    @NamedQuery(name = "Tipopessoa.findByIdTipopessoa", query = "SELECT t FROM Tipopessoa t WHERE t.idTipopessoa = :idTipopessoa"),
    @NamedQuery(name = "Tipopessoa.findByTitulopessoa", query = "SELECT t FROM Tipopessoa t WHERE t.titulopessoa = :titulopessoa")})
public class Tipopessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOPESSOA")
    private Long idTipopessoa;
    @Size(max = 15)
    @Column(name = "TITULOPESSOA")
    private String titulopessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipopessoa")
    private List<Usuario> usuarioList;

    public Tipopessoa() {
    }

    public Tipopessoa(Long idTipopessoa) {
        this.idTipopessoa = idTipopessoa;
    }

    public Long getIdTipopessoa() {
        return idTipopessoa;
    }

    public void setIdTipopessoa(Long idTipopessoa) {
        this.idTipopessoa = idTipopessoa;
    }

    public String getTitulopessoa() {
        return titulopessoa;
    }

    public void setTitulopessoa(String titulopessoa) {
        this.titulopessoa = titulopessoa;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipopessoa != null ? idTipopessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopessoa)) {
            return false;
        }
        Tipopessoa other = (Tipopessoa) object;
        if ((this.idTipopessoa == null && other.idTipopessoa != null) || (this.idTipopessoa != null && !this.idTipopessoa.equals(other.idTipopessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Tipopessoa[ idTipopessoa=" + idTipopessoa + " ]";
    }
    
}
