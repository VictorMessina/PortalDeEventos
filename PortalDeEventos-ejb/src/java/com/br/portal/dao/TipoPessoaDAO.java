/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Tipopessoa;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Victor M
 */
@Stateless
@LocalBean
public class TipoPessoaDAO implements GenericDAO<Tipopessoa>{
    
    @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Tipopessoa e) {
        em.persist(e);
    }

    @Override
    public List<Tipopessoa> find() {
        return em.createNamedQuery("Tipopessoa.findAll", Tipopessoa.class).getResultList();
    }

    @Override
    public Tipopessoa findById(long id) {
        return em.find(Tipopessoa.class, id);
    }

    @Override
    public void update(Tipopessoa e) {
        em.merge(e);
    }

    @Override
    public void remove(Tipopessoa e) {
        em.remove(em.merge(e)); 
    }
}