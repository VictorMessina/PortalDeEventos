/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.command;

import com.br.portal.dao.CaracteristicaseventoDAO;
import com.br.portal.dao.CategoriaEventoDAO;
import com.br.portal.dao.EventoDAO;
import com.br.portal.dao.UsuarioDAO;
import com.br.portal.entities.Caracteristicasevento;
import com.br.portal.entities.Categoriaevento;
import com.br.portal.entities.Evento;
import com.br.portal.entities.Usuario;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    CaracteristicaseventoDAO caracteristicaseventoDAO = lookupCaracteristicaseventoDAOBean();

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
                String dateini = request.getParameter("dataini");
                String datefim = request.getParameter("datafim");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                //SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date dataini = new Date();
                Date datafim = new Date();
                try {
                    dataini = formatter.parse(dateini);
                    datafim = formatter.parse(datefim);
                    dataini.setHours(Integer.parseInt(request.getParameter("horaini")));
                    dataini.setMinutes(Integer.parseInt(request.getParameter("minini")));
                    dataini.setSeconds(0);
                    datafim.setHours(Integer.parseInt(request.getParameter("horafim")));
                    datafim.setMinutes(Integer.parseInt(request.getParameter("minfim")));
                    datafim.setSeconds(0);

                } catch (ParseException ex) {
                    Logger.getLogger(EventoCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                evento.setDataini(dataini);
                evento.setDatafim(datafim);
                evento.setLugar(request.getParameter("local"));
                evento.setFkCliente(userEvent2);
                evento.setFkCategoriaevento(catEvento);
                
                Caracteristicasevento carac = new Caracteristicasevento();
                
                carac.setTema(request.getParameter("tema"));
                carac.setNconvidados(Integer.parseInt(request.getParameter("nconvidados")));
                carac.setBuffet(request.getParameter("buffet"));
                carac.setDecoracao(request.getParameter("decoracao"));
                carac.setAtracoes(request.getParameter("atracoes"));
                carac.setEvento(evento);
                evento.setCaracteristicasevento(carac);
                
                eventoDAO.persist(evento);

                request.getSession().setAttribute("successmsg", "Evento criado com sucesso!");  
                userEvent2.getEventoList2().add(evento);
                request.getSession().setAttribute("usuarioSessao", userEvent2);
                returnPage = "/eventos.jsp";

                break;
            case "perfilEvento":
                Evento eventoAtual = eventoDAO.findById(Integer.parseInt(request.getParameter("idEvento")));
                request.getSession().setAttribute("eventoAtual", eventoAtual);
                returnPage = "/eventoProfile.jsp";
                break;
            case "cronogramaEvento":
                Evento eventoAtual2 = eventoDAO.findById(Integer.parseInt(request.getParameter("idEvento")));
                request.getSession().setAttribute("eventoAtual", eventoAtual2);
                returnPage = "/eventoCronograma.jsp";
                break;
            case "participantesEvento":
                Evento eventoAtual3 = eventoDAO.findById(Integer.parseInt(request.getParameter("idEvento")));                
//                List listaFornecedores = new List();
//                request.getSession().setAttribute("listaFornecedores", listaFornecedores);
                request.getSession().setAttribute("eventoAtual", eventoAtual3);
                returnPage = "/eventoParticipantes.jsp";
                break;
            case "orcamentosEvento":
                Evento eventoAtual4 = eventoDAO.findById(Integer.parseInt(request.getParameter("idEvento")));
                request.getSession().setAttribute("eventoAtual", eventoAtual4);
                returnPage = "/eventoOrcamentos.jsp";
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

    private CaracteristicaseventoDAO lookupCaracteristicaseventoDAOBean() {
        try {
            Context c = new InitialContext();
            return (CaracteristicaseventoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/CaracteristicaseventoDAO!com.br.portal.dao.CaracteristicaseventoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
