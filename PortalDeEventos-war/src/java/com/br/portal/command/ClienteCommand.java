package com.br.portal.command;

import com.br.portal.dao.EventoDAO;
import com.br.portal.dao.OrcamentoDAO;
import com.br.portal.dao.UsuarioDAO;
import com.br.portal.entities.Orcamento;
import com.br.portal.entities.Usuario;
import com.br.portal.entities.Usuarioinfo;
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
 * @author Letícia
 */
public class ClienteCommand implements Command {

    EventoDAO eventoDAO = lookupEventoDAOBean();
    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();
    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();

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

                Usuarioinfo userinfo = new Usuarioinfo();

                userinfo.setNome(request.getParameter("nome"));
                userinfo.setEmail(request.getParameter("email"));
                userinfo.setDescricao(request.getParameter("descricao"));
                userinfo.setNumerocadastro(request.getParameter("numeroCadastro"));
                userinfo.setTelefone1(request.getParameter("telefone1"));
                userinfo.setTelefone2(request.getParameter("telefone2"));
                userinfo.setComissao(0.0);

                userEvent2.setUsuarioinfo(userinfo);

                userinfo.setUsuario(userEvent2);

                usuarioDAO.persist(userEvent2);

                request.getSession().setAttribute("usuarioSessao", userEvent2);
                request.getSession().setAttribute("successmsg", "Cliente afiliado com sucesso!");
                returnPage = "/homepage.jsp";

                break;

            case "buscarPromoter":

                List<Usuario> listaUsuarios = usuarioDAO.find();

                request.getSession().setAttribute("listaUsuarios", listaUsuarios);
                returnPage = "/buscarPromoter.jsp";

                break;

            case "solicitarOrcamento":

                Long idPromoter = Long.parseLong(request.getParameter("idPromoter"));
                Long idEvento = Long.parseLong(request.getParameter("idEvento"));
                
                Usuario usuarioSolicitante = (Usuario) request.getSession().getAttribute("usuarioSessao");
              
                if (idEvento == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhum Evento foi selecionado.");
                } else {

                    Orcamento orcamento = new Orcamento();

                    orcamento.setFkPromoter(usuarioDAO.findById(idPromoter));
                    orcamento.setFkEvento(eventoDAO.findById(idEvento));
                    orcamento.setFkSolicitante(usuarioSolicitante);
                    orcamento.setValor(null); 

                    orcamentoDAO.persist(orcamento);
                }

                request.getSession().setAttribute("successmsg", "Orçamento solicitado com sucesso");
                returnPage = "FrontController?command=Cliente&action=buscarPromoter";

                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
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

    private OrcamentoDAO lookupOrcamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (OrcamentoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/OrcamentoDAO!com.br.portal.dao.OrcamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EventoDAO lookupEventoDAOBean() {
        try {
            Context c = new InitialContext();
            return (EventoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/EventoDAO!com.br.portal.dao.EventoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}