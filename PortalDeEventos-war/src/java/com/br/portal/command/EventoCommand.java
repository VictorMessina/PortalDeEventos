/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.command;

import com.br.portal.dao.CategoriaEventoDAO;
import com.br.portal.dao.EventoDAO;
import com.br.portal.dao.UsuarioDAO;
import com.br.portal.entities.Categoriaevento;
import com.br.portal.entities.Evento;
import com.br.portal.entities.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HugoKeniti
 */
public class EventoCommand implements Command {

    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();

    CategoriaEventoDAO categoriaEventoDAO = lookupCategoriaEventoDAOBean();
    EventoDAO eventoDAO = lookupEventoDAOBean();
    

    private String returnPage = "/index.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch (action) {
            case "insert":
                Usuario userEvent2 = (Usuario) request.getSession().getAttribute("usuarioSessao");
                Categoriaevento catEvento = categoriaEventoDAO.findById(Integer.parseInt(request.getParameter("idCatEvento")));
                Evento evento = new Evento();
                evento.setTitulo(request.getParameter("titulo"));
                evento.setDescricao(request.getParameter("descricao"));
                String date = request.getParameter("data");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date data = new Date();
            try {
                data = formatter.parse(date);
                
            } catch (ParseException ex) {
                Logger.getLogger(EventoCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                evento.setDataevento(data);
                evento.setLugar(request.getParameter("local"));
                evento.setFkCliente(userEvent2);
                evento.setFkCategoriaevento(catEvento);
                evento.setFkPromoter(null);
                eventoDAO.persist(evento);
                request.getSession().setAttribute("eventoSessao", evento);
                request.getSession().setAttribute("successmsg", "Evento criado com sucesso!");
                returnPage = "/evento.jsp";

                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private EventoDAO lookupEventoDAOBean() {
        try {
            Context c = new InitialContext();
            return (EventoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/EventoDAO!com.br.portal.dao.EventoDAO");
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);
        }
    }

    private CategoriaEventoDAO lookupCategoriaEventoDAOBean() {
        try {
            Context c = new InitialContext();
            return (CategoriaEventoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/CategoriaEventoDAO!com.br.portal.dao.CategoriaEventoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuarioDAO lookupUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/UsuarioDAO!com.br.portal.dao.UsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
