/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Caracteristicasevento;
import com.br.portal.entities.Evento;
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
public class CaracteristicaseventoDAO implements GenericDAO<Caracteristicasevento> {

    @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Caracteristicasevento e) {
        em.persist(e);
    }

    @Override
    public List<Caracteristicasevento> find() {
        return em.createNamedQuery("Caracteristicasevento.findAll", Caracteristicasevento.class).getResultList();
    }

    @Override
    public Caracteristicasevento findById(long id) {
        return em.find(Caracteristicasevento.class, id);
    }

    @Override
    public void update(Caracteristicasevento e) {
        em.merge(e);
    }

    @Override
    public void remove(Caracteristicasevento e) {
        em.remove(em.merge(e));
    }

}
