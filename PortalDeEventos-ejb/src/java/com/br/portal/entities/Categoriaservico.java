/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author HugoKeniti
 */
@Entity
@Table(name = "CATEGORIASERVICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriaservico.findAll", query = "SELECT c FROM Categoriaservico c"),
    @NamedQuery(name = "Categoriaservico.findByIdCategoriaservico", query = "SELECT c FROM Categoriaservico c WHERE c.idCategoriaservico = :idCategoriaservico"),
    @NamedQuery(name = "Categoriaservico.findByNomecategoriaservico", query = "SELECT c FROM Categoriaservico c WHERE c.nomecategoriaservico = :nomecategoriaservico")})
public class Categoriaservico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIASERVICO")
    private Long idCategoriaservico;
    @Size(max = 50)
    @Column(name = "NOMECATEGORIASERVICO")
    private String nomecategoriaservico;
    @OneToMany(mappedBy = "fkCategoriaservico")
    private Collection<Servico> servicoCollection;

    public Categoriaservico() {
    }

    public Categoriaservico(Long idCategoriaservico) {
        this.idCategoriaservico = idCategoriaservico;
    }

    public Long getIdCategoriaservico() {
        return idCategoriaservico;
    }

    public void setIdCategoriaservico(Long idCategoriaservico) {
        this.idCategoriaservico = idCategoriaservico;
    }

    public String getNomecategoriaservico() {
        return nomecategoriaservico;
    }

    public void setNomecategoriaservico(String nomecategoriaservico) {
        this.nomecategoriaservico = nomecategoriaservico;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaservico != null ? idCategoriaservico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriaservico)) {
            return false;
        }
        Categoriaservico other = (Categoriaservico) object;
        if ((this.idCategoriaservico == null && other.idCategoriaservico != null) || (this.idCategoriaservico != null && !this.idCategoriaservico.equals(other.idCategoriaservico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Categoriaservico[ idCategoriaservico=" + idCategoriaservico + " ]";
    }
    
}
