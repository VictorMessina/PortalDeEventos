/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

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
 * @author Victor M
 */
@Entity
@Table(name = "ORCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o"),
    @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento"),
    @NamedQuery(name = "Orcamento.findByValor", query = "SELECT o FROM Orcamento o WHERE o.valor = :valor")})
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORCAMENTO")
    private Long idOrcamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private Double valor;
    @JoinColumn(name = "FK_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne
    private Evento fkEvento;
    @JoinColumn(name = "FK_SOLICITANTE", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario fkSolicitante;
    @JoinColumn(name = "FK_PROMOTER", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario fkPromoter;

    public Orcamento() {
    }

    public Orcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Evento getFkEvento() {
        return fkEvento;
    }

    public void setFkEvento(Evento fkEvento) {
        this.fkEvento = fkEvento;
    }

    public Usuario getFkSolicitante() {
        return fkSolicitante;
    }

    public void setFkSolicitante(Usuario fkSolicitante) {
        this.fkSolicitante = fkSolicitante;
    }

    public Usuario getFkPromoter() {
        return fkPromoter;
    }

    public void setFkPromoter(Usuario fkPromoter) {
        this.fkPromoter = fkPromoter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrcamento != null ? idOrcamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.idOrcamento == null && other.idOrcamento != null) || (this.idOrcamento != null && !this.idOrcamento.equals(other.idOrcamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Orcamento[ idOrcamento=" + idOrcamento + " ]";
    }
    
}
