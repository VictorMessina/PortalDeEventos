/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Categoriaevento;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Vitória
 */
@Stateless
@LocalBean
public class CategoriaEventoDAO implements GenericDAO<Categoriaevento>{
    
    @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Categoriaevento e) {
        em.persist(e);
    }

    @Override
    public List<Categoriaevento> find() {
        return em.createNamedQuery("Categoriaevento.findAll", Categoriaevento.class).getResultList();
    }

    @Override
    public Categoriaevento findById(long id) {
        return em.find(Categoriaevento.class, id);
    }

    @Override
    public void update(Categoriaevento e) {
        em.merge(e);
    }

    @Override
    public void remove(Categoriaevento e) {
        em.remove(em.merge(e)); 
    }

}
