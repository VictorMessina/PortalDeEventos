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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor M
 */
@Entity
@Table(name = "SERVICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByIdServico", query = "SELECT s FROM Servico s WHERE s.idServico = :idServico"),
    @NamedQuery(name = "Servico.findByTitulo", query = "SELECT s FROM Servico s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Servico.findByPre\u00e7o", query = "SELECT s FROM Servico s WHERE s.pre\u00e7o = :pre\u00e7o")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idServico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRE\u00c7O")
    private Double preço;
    @JoinColumn(name = "FK_CATEGORIASERVICO", referencedColumnName = "ID_CATEGORIASERVICO")
    @ManyToOne
    private Categoriaservico fkCategoriaservico;
    @JoinColumn(name = "FK_FORNECEDOR", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario fkFornecedor;

    public Servico() {
    }

    public Servico(Long idServico) {
        this.idServico = idServico;
    }

    public Servico(Long idServico, String titulo) {
        this.idServico = idServico;
        this.titulo = titulo;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
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

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public Categoriaservico getFkCategoriaservico() {
        return fkCategoriaservico;
    }

    public void setFkCategoriaservico(Categoriaservico fkCategoriaservico) {
        this.fkCategoriaservico = fkCategoriaservico;
    }

    public Usuario getFkFornecedor() {
        return fkFornecedor;
    }

    public void setFkFornecedor(Usuario fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Servico[ idServico=" + idServico + " ]";
    }
    
}
