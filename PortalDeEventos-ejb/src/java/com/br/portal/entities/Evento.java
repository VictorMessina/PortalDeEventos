/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 31320600
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByTitulo", query = "SELECT e FROM Evento e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Evento.findByDescricao", query = "SELECT e FROM Evento e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Evento.findByDataevento", query = "SELECT e FROM Evento e WHERE e.dataevento = :dataevento"),
    @NamedQuery(name = "Evento.findByLugar", query = "SELECT e FROM Evento e WHERE e.lugar = :lugar")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EVENTO")
    private Long idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAEVENTO")
    @Temporal(TemporalType.DATE)
    private Date dataevento;
    @Size(max = 100)
    @Column(name = "LUGAR")
    private String lugar;
    @JoinTable(name = "FORNECEDOREVENTO", joinColumns = {
        @JoinColumn(name = "FK_EVENTO", referencedColumnName = "ID_EVENTO")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_FORNECEDOR", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "FK_CATEGORIAEVENTO", referencedColumnName = "ID_CATEGORIAEVENTO")
    @ManyToOne
    private Categoriaevento fkCategoriaevento;
    @JoinColumn(name = "FK_PROMOTER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario fkPromoter;
    @JoinColumn(name = "FK_CLIENTE", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario fkCliente;

    public Evento() {
    }

    public Evento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Long idEvento, String titulo, Date dataevento) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.dataevento = dataevento;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataevento() {
        return dataevento;
    }

    public void setDataevento(Date dataevento) {
        this.dataevento = dataevento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Categoriaevento getFkCategoriaevento() {
        return fkCategoriaevento;
    }

    public void setFkCategoriaevento(Categoriaevento fkCategoriaevento) {
        this.fkCategoriaevento = fkCategoriaevento;
    }

    public Usuario getFkPromoter() {
        return fkPromoter;
    }

    public void setFkPromoter(Usuario fkPromoter) {
        this.fkPromoter = fkPromoter;
    }

    public Usuario getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Usuario fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
