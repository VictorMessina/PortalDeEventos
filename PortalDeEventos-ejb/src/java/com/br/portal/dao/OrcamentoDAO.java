/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Orcamento;
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
public class OrcamentoDAO implements GenericDAO<Orcamento> {

    @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Orcamento e) {
        em.persist(e);
    }

    @Override
    public List<Orcamento> find() {
        return em.createNamedQuery("Orcamento.findAll", Orcamento.class).getResultList();
    }

    @Override
    public Orcamento findById(long id) {
     return em.find(Orcamento.class, id);
    }

    @Override
    public void update(Orcamento e) {
        em.merge(e);
    }

    @Override
    public void remove(Orcamento e) {
        em.remove(em.merge(e));
    }

}