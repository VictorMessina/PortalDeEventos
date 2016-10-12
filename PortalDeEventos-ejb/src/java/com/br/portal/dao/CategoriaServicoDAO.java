/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Categoriaservico;
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
public class CategoriaServicoDAO implements GenericDAO<Categoriaservico>{
    
    @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Categoriaservico e) {
        em.persist(e);
    }

    @Override
    public List<Categoriaservico> find() {
        return em.createNamedQuery("Categoriaservico.findAll", Categoriaservico.class).getResultList();
    }

    @Override
    public Categoriaservico findById(long id) {
        return em.find(Categoriaservico.class, id);
    }

    @Override
    public void update(Categoriaservico e) {
        em.merge(e);
    }

    @Override
    public void remove(Categoriaservico e) {
        em.remove(em.merge(e)); 
    }

}
