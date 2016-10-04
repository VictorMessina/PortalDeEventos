/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Usuarioinfo;
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
public class UsuarioInfoDAO implements GenericDAO<Usuarioinfo>{

    @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void persist(Usuarioinfo e) {
        em.persist(e);
    }

    @Override
    public List<Usuarioinfo> find() {
       return em.createNamedQuery("Usuarioinfo.findAll", Usuarioinfo.class).getResultList();
    }

    @Override
    public Usuarioinfo findById(long id) {
        return em.find(Usuarioinfo.class, id);
    }

    @Override
    public void update(Usuarioinfo e) {
        em.merge(e);
    }

    @Override
    public void remove(Usuarioinfo e) {
        em.remove(em.merge(e));
    }
    
}