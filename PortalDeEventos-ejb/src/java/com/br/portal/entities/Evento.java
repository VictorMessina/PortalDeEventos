/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor M
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByTitulo", query = "SELECT e FROM Evento e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Evento.findByDescricao", query = "SELECT e FROM Evento e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Evento.findByDataini", query = "SELECT e FROM Evento e WHERE e.dataini = :dataini"),
    @NamedQuery(name = "Evento.findByDatafim", query = "SELECT e FROM Evento e WHERE e.datafim = :datafim"),
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
    @Column(name = "DATAINI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataini;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAFIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @Size(max = 100)
    @Column(name = "LUGAR")
    private String lugar;
    @JoinTable(name = "FORNECEDOREVENTO", joinColumns = {
        @JoinColumn(name = "FK_EVENTO", referencedColumnName = "ID_EVENTO")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_FORNECEDOR", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "evento")
    private Caracteristicasevento caracteristicasevento;
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

    public Evento(Long idEvento, String titulo, Date dataini, Date datafim) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.dataini = dataini;
        this.datafim = datafim;
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

    public Date getDataini() {
        return dataini;
    }

    public void setDataini(Date dataini) {
        this.dataini = dataini;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Caracteristicasevento getCaracteristicasevento() {
        return caracteristicasevento;
    }

    public void setCaracteristicasevento(Caracteristicasevento caracteristicasevento) {
        this.caracteristicasevento = caracteristicasevento;
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
