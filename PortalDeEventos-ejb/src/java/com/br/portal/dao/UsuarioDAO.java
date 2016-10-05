/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.dao;

import com.br.portal.entities.Usuario;
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
public class UsuarioDAO implements GenericDAO<Usuario>{
    
     @PersistenceContext(unitName = "EventosPU", type = PersistenceContextType.TRANSACTION)
     private EntityManager em;

    @Override
    public void persist(Usuario e) {
        em.persist(e);
    }

    @Override
    public List<Usuario> find() {
        return em.createNamedQuery("Usuario.findAll",Usuario.class).getResultList();
    }

    @Override
    public Usuario findById(long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public void update(Usuario e) {
        em.merge(e);
    }

    @Override
    public void remove(Usuario e) {
        em.remove(em.merge(e));
    }
    
    public Usuario findByUserName(String userName) {

        List<Usuario> usuarioproj = find();

        for (Usuario up : usuarioproj) {
            if (up.getUsername().equals(userName)) {
                return up;
            }
        }
        return null;
    }
    
}