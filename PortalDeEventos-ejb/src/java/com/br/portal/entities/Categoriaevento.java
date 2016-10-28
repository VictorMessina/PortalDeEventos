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
@Table(name = "CATEGORIAEVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriaevento.findAll", query = "SELECT c FROM Categoriaevento c"),
    @NamedQuery(name = "Categoriaevento.findByIdCategoriaevento", query = "SELECT c FROM Categoriaevento c WHERE c.idCategoriaevento = :idCategoriaevento"),
    @NamedQuery(name = "Categoriaevento.findByNomecategoriaevento", query = "SELECT c FROM Categoriaevento c WHERE c.nomecategoriaevento = :nomecategoriaevento")})
public class Categoriaevento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIAEVENTO")
    private Long idCategoriaevento;
    @Size(max = 50)
    @Column(name = "NOMECATEGORIAEVENTO")
    private String nomecategoriaevento;
    @OneToMany(mappedBy = "fkCategoriaevento")
    private Collection<Evento> eventoCollection;

    public Categoriaevento() {
    }

    public Categoriaevento(Long idCategoriaevento) {
        this.idCategoriaevento = idCategoriaevento;
    }

    public Long getIdCategoriaevento() {
        return idCategoriaevento;
    }

    public void setIdCategoriaevento(Long idCategoriaevento) {
        this.idCategoriaevento = idCategoriaevento;
    }

    public String getNomecategoriaevento() {
        return nomecategoriaevento;
    }

    public void setNomecategoriaevento(String nomecategoriaevento) {
        this.nomecategoriaevento = nomecategoriaevento;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaevento != null ? idCategoriaevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriaevento)) {
            return false;
        }
        Categoriaevento other = (Categoriaevento) object;
        if ((this.idCategoriaevento == null && other.idCategoriaevento != null) || (this.idCategoriaevento != null && !this.idCategoriaevento.equals(other.idCategoriaevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Categoriaevento[ idCategoriaevento=" + idCategoriaevento + " ]";
    }
    
}
