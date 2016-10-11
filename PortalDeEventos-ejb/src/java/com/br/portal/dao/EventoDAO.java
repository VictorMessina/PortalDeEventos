/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Evento;
import com.br.portal.entities.Usuario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author HugoKeniti
 */
@Stateless
@LocalBean
public class EventoDAO implements GenericDAO<Evento>{
    
     @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
     private EntityManager em;

    @Override
    public void persist(Evento e) {
        em.persist(e);
    }

    @Override
    public List<Evento> find() {
        return em.createNamedQuery("Evento.findAll",Evento.class).getResultList();
    }

    @Override
    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    @Override
    public void update(Evento e) {
        em.merge(e);
    }

    @Override
    public void remove(Evento e) {
        em.remove(em.merge(e));
    }
    
    public Evento findByName(String titulo) {

        List<Evento> eventoproj = find();

        for (Evento up : eventoproj) {
            if (up.getTitulo().equals(titulo)) {
                return up;
            }
        }
        return null;
    }

   
}
