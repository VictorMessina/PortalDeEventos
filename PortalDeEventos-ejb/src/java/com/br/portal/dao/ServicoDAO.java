/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Servico;
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
public class ServicoDAO implements GenericDAO<Servico>{
    
     @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
     private EntityManager em;

    @Override
    public void persist(Servico e) {
        em.persist(e);
    }

    @Override
    public List<Servico> find() {
        return em.createNamedQuery("Servico.findAll",Servico.class).getResultList();
    }

    @Override
    public Servico findById(long id) {
        return em.find(Servico.class, id);
    }

    @Override
    public void update(Servico e) {
        em.merge(e);
    }

    @Override
    public void remove(Servico e) {
        em.remove(em.merge(e));
    }
    
    public Servico findByName(String titulo) {

        List<Servico> servicoproj = find();

        for (Servico up : servicoproj) {
            if (up.getTitulo().equals(titulo)) {
                return up;
            }
        }
        return null;
    }

   
}
