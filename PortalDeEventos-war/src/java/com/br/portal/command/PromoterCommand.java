package com.br.portal.command;

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
 * @author Victor M
 */
public class PromoterCommand implements Command {

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
                userinfo.setComissao(Double.parseDouble(request.getParameter("comissao")));

                userEvent2.setUsuarioinfo(userinfo);

                userinfo.setUsuario(userEvent2);

                usuarioDAO.persist(userEvent2);

                request.getSession().setAttribute("usuarioSessao", userEvent2);
                request.getSession().setAttribute("successmsg", "Promoter afiliado com sucesso");
                returnPage = "/homepage.jsp";

                break;

            case "updateComissao":
                String comissao = request.getParameter("comissao");

                Usuario usuarioSessao8 = (Usuario) request.getSession().getAttribute("usuarioSessao");

                usuarioSessao8 = usuarioDAO.findById(usuarioSessao8.getIdUsuario());
                usuarioSessao8.getUsuarioinfo().setComissao(Double.parseDouble(comissao));

                usuarioDAO.update(usuarioSessao8);

                request.getSession().setAttribute("usuarioSessao", usuarioSessao8);

                request.getSession().setAttribute("successmsg", "Comissão atualizada com sucesso");

                returnPage = "/editProfile.jsp";

                break;

            case "buscaOrcamento":

                List<Orcamento> listaOrcamento = orcamentoDAO.find();

                request.getSession().setAttribute("listaOrcamento", listaOrcamento);

                returnPage = "/eventoOrcamentos.jsp";

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

}
