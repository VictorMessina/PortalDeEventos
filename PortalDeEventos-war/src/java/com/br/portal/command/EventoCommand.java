/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.command;

import com.br.portal.dao.EventoDAO;
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
public class EventoCommand implements Command{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
