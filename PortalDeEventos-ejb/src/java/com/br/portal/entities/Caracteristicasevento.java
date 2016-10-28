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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HugoKeniti
 */
@Entity
@Table(name = "CARACTERISTICASEVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristicasevento.findAll", query = "SELECT c FROM Caracteristicasevento c"),
    @NamedQuery(name = "Caracteristicasevento.findByIdCaracteristicasevento", query = "SELECT c FROM Caracteristicasevento c WHERE c.idCaracteristicasevento = :idCaracteristicasevento"),
    @NamedQuery(name = "Caracteristicasevento.findByTema", query = "SELECT c FROM Caracteristicasevento c WHERE c.tema = :tema"),
    @NamedQuery(name = "Caracteristicasevento.findByNconvidados", query = "SELECT c FROM Caracteristicasevento c WHERE c.nconvidados = :nconvidados"),
    @NamedQuery(name = "Caracteristicasevento.findByBuffet", query = "SELECT c FROM Caracteristicasevento c WHERE c.buffet = :buffet"),
    @NamedQuery(name = "Caracteristicasevento.findByDecoracao", query = "SELECT c FROM Caracteristicasevento c WHERE c.decoracao = :decoracao"),
    @NamedQuery(name = "Caracteristicasevento.findByAtracoes", query = "SELECT c FROM Caracteristicasevento c WHERE c.atracoes = :atracoes")})
public class Caracteristicasevento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CARACTERISTICASEVENTO")
    private Long idCaracteristicasevento;
    @Size(max = 50)
    @Column(name = "TEMA")
    private String tema;
    @Column(name = "NCONVIDADOS")
    private Integer nconvidados;
    @Size(max = 150)
    @Column(name = "BUFFET")
    private String buffet;
    @Size(max = 150)
    @Column(name = "DECORACAO")
    private String decoracao;
    @Size(max = 150)
    @Column(name = "ATRACOES")
    private String atracoes;
    @JoinColumn(name = "ID_CARACTERISTICASEVENTO", referencedColumnName = "ID_EVENTO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Evento evento;

    public Caracteristicasevento() {
    }

    public Caracteristicasevento(Long idCaracteristicasevento) {
        this.idCaracteristicasevento = idCaracteristicasevento;
    }

    public Long getIdCaracteristicasevento() {
        return idCaracteristicasevento;
    }

    public void setIdCaracteristicasevento(Long idCaracteristicasevento) {
        this.idCaracteristicasevento = idCaracteristicasevento;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getNconvidados() {
        return nconvidados;
    }

    public void setNconvidados(Integer nconvidados) {
        this.nconvidados = nconvidados;
    }

    public String getBuffet() {
        return buffet;
    }

    public void setBuffet(String buffet) {
        this.buffet = buffet;
    }

    public String getDecoracao() {
        return decoracao;
    }

    public void setDecoracao(String decoracao) {
        this.decoracao = decoracao;
    }

    public String getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(String atracoes) {
        this.atracoes = atracoes;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristicasevento != null ? idCaracteristicasevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristicasevento)) {
            return false;
        }
        Caracteristicasevento other = (Caracteristicasevento) object;
        if ((this.idCaracteristicasevento == null && other.idCaracteristicasevento != null) || (this.idCaracteristicasevento != null && !this.idCaracteristicasevento.equals(other.idCaracteristicasevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Caracteristicasevento[ idCaracteristicasevento=" + idCaracteristicasevento + " ]";
    }
    
}
