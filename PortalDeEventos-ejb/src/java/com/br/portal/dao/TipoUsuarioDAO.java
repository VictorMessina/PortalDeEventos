/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Tipousuario;
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
public class TipoUsuarioDAO implements GenericDAO<Tipousuario>{
    
     @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
     private EntityManager em;

    @Override
    public void persist(Tipousuario e) {
        em.persist(e);
    }

    @Override
    public List<Tipousuario> find() {
        return em.createNamedQuery("Tipopessoa.findAll",Tipousuario.class).getResultList();
    }

    @Override
    public Tipousuario findById(long id) {
       return em.find(Tipousuario.class, id);
    }

    @Override
    public void update(Tipousuario e) {
        em.merge(e);
    }

    @Override
    public void remove(Tipousuario e) {
        em.remove(em.merge(e));
    }
    
}
