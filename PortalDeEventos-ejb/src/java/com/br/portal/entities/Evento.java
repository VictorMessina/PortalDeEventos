/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HugoKeniti
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement

public class Evento implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EVENTO")
    private Long idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA")
    private Date data;
    
    
//     fk_cliente BIGINT not null,
//    fk_promoter BIGINT,
//    fk_categoriaEvento BIGINT
    
    @JoinColumn(name = "FK_CLIENTE", referencedColumnName = "ID_CLIENTE" )
    
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
//    private Usuarioinfo usuarioinfo;
//    @JoinColumn(name = "FK_TIPOPESSOA", referencedColumnName = "ID_TIPOPESSOA")
//    @ManyToOne(optional = false)
//    private Tipopessoa fkTipopessoa;
//    @JoinColumn(name = "FK_TIPOUSUARIO", referencedColumnName = "ID_TIPOUSUARIO")
//    @ManyToOne(optional = false)
//    private Tipousuario fkTipousuario;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
