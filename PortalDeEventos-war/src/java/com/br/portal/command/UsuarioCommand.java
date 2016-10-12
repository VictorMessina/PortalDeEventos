package com.br.portal.command;

import com.br.portal.dao.CategoriaEventoDAO;
import com.br.portal.dao.CategoriaServicoDAO;
import com.br.portal.dao.TipoPessoaDAO;
import com.br.portal.dao.TipoUsuarioDAO;
import com.br.portal.dao.UsuarioDAO;
import com.br.portal.entities.Categoriaevento;
import com.br.portal.entities.Categoriaservico;
import com.br.portal.entities.Tipopessoa;
import com.br.portal.entities.Tipousuario;
import com.br.portal.entities.Usuario;
import com.br.portal.entities.Usuarioinfo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UsuarioCommand implements Command {

    CategoriaEventoDAO categoriaEventoDAO = lookupCategoriaEventoDAOBean();
    
    CategoriaServicoDAO categoriaServicoDAO = lookupCategoriaServicoDAOBean();
    
    TipoPessoaDAO tipoPessoaDAO = lookupTipoPessoaDAOBean();
    TipoUsuarioDAO tipoUsuarioDAO = lookupTipoUsuarioDAOBean();
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

            case "login":
                //up = usuario projeto
                Usuario up = (Usuario) usuarioDAO.findByUserName(request.getParameter("login"));

                String md5Login = geraSenhaMD5(request.getParameter("password"));

                if (up == null) {
                    request.getSession().setAttribute("errormsg", "Usuário não encontrado! Por favor tente novamente.");
                } else {
                    System.out.println(up.toString());

                    if (!up.getPassword().equals(md5Login)) {
                        request.getSession().setAttribute("errormsg", "Senha incorreta! Por favor tente novamente.");
                    }

                    if (up.getFkTipousuario().getIdTipousuario() == 1 && up.getPassword().equals(md5Login)) {
                        //jmsProdutor.sendMessage(MsgType.LOGIN," Usuario Cliente: " + up.getUsername() + " realizou login " + " \n" );
                        List<Categoriaevento> listaCat = categoriaEventoDAO.find();
                       request.getSession().setAttribute("listaCatEvento", listaCat);
                        request.getSession().setAttribute("usuarioSessao", up);
                        returnPage = "/homepage.jsp";

                    } else if (up.getFkTipousuario().getIdTipousuario() == 2 && up.getPassword().equals(md5Login)) {
                        //jmsProdutor.sendMessage(MsgType.LOGIN," Usuario Promoter: " + up.getUsername() + " realizou login " + " \n" );
                        request.getSession().setAttribute("usuarioSessao", up);
                        returnPage = "/homepage.jsp";

                    } else if (up.getFkTipousuario().getIdTipousuario() == 3 && up.getPassword().equals(md5Login)) {
                        //jmsProdutor.sendMessage(MsgType.LOGIN,"Usuario Fornecedor de Serviços: " + up.getUsername() + " realizou login" + "\n");
                        List<Categoriaservico> listaCategorias = categoriaServicoDAO.find();
                        request.getSession().setAttribute("listaCatServico", listaCategorias);
                        request.getSession().setAttribute("usuarioSessao", up);

                        returnPage = "/homepage.jsp";
                    }
                }
                break;

            case "logout":
                Usuario ups = (Usuario) request.getSession().getAttribute("usuarioSessao");
                //jmsProdutor.sendMessage(MsgType.LOGOUT,"Usuario: " + ups.getUsername() + " realizou logout" + "\n");
                request.getSession().setAttribute("usuarioSessao", null);
                break;

            case "insert":
                if (usuarioDAO.findByUserName(request.getParameter("login")) != null) {
                    returnPage = "/register.jsp";
                    request.getSession().setAttribute("errormsg", "Usuário já utilizado! Por favor utilize outro usuário para realizar o cadastro.");
                } else if (!request.getParameter("password").equals(request.getParameter("password2"))) {
                    returnPage = "/register.jsp";
                    request.getSession().setAttribute("errormsg", "Senha imcompatível! Por favor digite senhas compatíveis.");
                } else {
                    Usuario userEvent = new Usuario();

                    Tipousuario userType = tipoUsuarioDAO.findById(Integer.parseInt(request.getParameter("tipoUsuario")));

                    Tipopessoa personType = tipoPessoaDAO.findById(Integer.parseInt(request.getParameter("tipoPessoa")));

                    userEvent.setUsername(request.getParameter("login"));

                    String md5InsertNormal = geraSenhaMD5(request.getParameter("password"));

                    userEvent.setPassword(md5InsertNormal);

                    userEvent.setFkTipopessoa(personType);

                    userEvent.setFkTipousuario(userType);

                    request.getSession().setAttribute("usuarioSessao", userEvent);                   
                    
                    if (userEvent.getFkTipousuario().getIdTipousuario() == 1) {
                       List<Categoriaevento> listaCat = categoriaEventoDAO.find();
                       request.getSession().setAttribute("listaCatEvento", listaCat);
                        returnPage = "/registerCliente.jsp";
                    }
                    else if (userEvent.getFkTipousuario().getIdTipousuario() == 2) {
                        returnPage = "/registerPromoter.jsp";
                    } 
                    else if (userEvent.getFkTipousuario().getIdTipousuario() == 3) {
                        List<Categoriaservico> listaCategorias = categoriaServicoDAO.find();
                        request.getSession().setAttribute("listaCatServico", listaCategorias);
                        returnPage = "/registerFornecedor.jsp";
                    }
                }
                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private String geraSenhaMD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] arrayBytes = md.digest(senha.getBytes());

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < arrayBytes.length; i++) {
                sb.append(Integer.toHexString((arrayBytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioCommand.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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

    private TipoUsuarioDAO lookupTipoUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (TipoUsuarioDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/TipoUsuarioDAO!com.br.portal.dao.TipoUsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TipoPessoaDAO lookupTipoPessoaDAOBean() {
        try {
            Context c = new InitialContext();
            return (TipoPessoaDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/TipoPessoaDAO!com.br.portal.dao.TipoPessoaDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CategoriaServicoDAO lookupCategoriaServicoDAOBean() {
        try {
            Context c = new InitialContext();
            return (CategoriaServicoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/CategoriaServicoDAO!com.br.portal.dao.CategoriaServicoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
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

}
