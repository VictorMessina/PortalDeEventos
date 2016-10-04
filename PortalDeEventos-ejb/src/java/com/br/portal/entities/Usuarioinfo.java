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
 * @author Victor M
 */
@Entity
@Table(name = "USUARIOINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioinfo.findAll", query = "SELECT u FROM Usuarioinfo u"),
    @NamedQuery(name = "Usuarioinfo.findByIdUsuarioinfo", query = "SELECT u FROM Usuarioinfo u WHERE u.idUsuarioinfo = :idUsuarioinfo"),
    @NamedQuery(name = "Usuarioinfo.findByNome", query = "SELECT u FROM Usuarioinfo u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuarioinfo.findByEmail", query = "SELECT u FROM Usuarioinfo u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarioinfo.findByTelefone1", query = "SELECT u FROM Usuarioinfo u WHERE u.telefone1 = :telefone1"),
    @NamedQuery(name = "Usuarioinfo.findByTelefone2", query = "SELECT u FROM Usuarioinfo u WHERE u.telefone2 = :telefone2"),
    @NamedQuery(name = "Usuarioinfo.findByDescricao", query = "SELECT u FROM Usuarioinfo u WHERE u.descricao = :descricao"),
    @NamedQuery(name = "Usuarioinfo.findByNumerocadastro", query = "SELECT u FROM Usuarioinfo u WHERE u.numerocadastro = :numerocadastro"),
    @NamedQuery(name = "Usuarioinfo.findByPreco", query = "SELECT u FROM Usuarioinfo u WHERE u.preco = :preco")})
public class Usuarioinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIOINFO")
    private Long idUsuarioinfo;
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 11)
    @Column(name = "TELEFONE1")
    private String telefone1;
    @Size(max = 11)
    @Column(name = "TELEFONE2")
    private String telefone2;
    @Size(max = 150)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 14)
    @Column(name = "NUMEROCADASTRO")
    private String numerocadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECO")
    private Double preco;
    @JoinColumn(name = "ID_USUARIOINFO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Usuarioinfo() {
    }

    public Usuarioinfo(Long idUsuarioinfo) {
        this.idUsuarioinfo = idUsuarioinfo;
    }

    public Long getIdUsuarioinfo() {
        return idUsuarioinfo;
    }

    public void setIdUsuarioinfo(Long idUsuarioinfo) {
        this.idUsuarioinfo = idUsuarioinfo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumerocadastro() {
        return numerocadastro;
    }

    public void setNumerocadastro(String numerocadastro) {
        this.numerocadastro = numerocadastro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioinfo != null ? idUsuarioinfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioinfo)) {
            return false;
        }
        Usuarioinfo other = (Usuarioinfo) object;
        if ((this.idUsuarioinfo == null && other.idUsuarioinfo != null) || (this.idUsuarioinfo != null && !this.idUsuarioinfo.equals(other.idUsuarioinfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.portal.entities.Usuarioinfo[ idUsuarioinfo=" + idUsuarioinfo + " ]";
    }
    
}
