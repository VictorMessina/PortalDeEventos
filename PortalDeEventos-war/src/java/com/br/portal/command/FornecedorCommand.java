/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.portal.command;

import com.br.portal.dao.CategoriaServicoDAO;
import com.br.portal.dao.ServicoDAO;
import com.br.portal.dao.UsuarioDAO;
import com.br.portal.entities.Categoriaservico;
import com.br.portal.entities.Servico;
import com.br.portal.entities.Usuario;
import com.br.portal.entities.Usuarioinfo;
import java.util.ArrayList;
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
 * @author Vitória
 */
public class FornecedorCommand implements Command {

    CategoriaServicoDAO categoriaServicoDAO = lookupCategoriaServicoDAOBean();
    ServicoDAO servicoDAO = lookupServicoDAOBean();
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

                userEvent2.setUsuarioinfo(userinfo);
                userinfo.setUsuario(userEvent2);

                Categoriaservico catServ = categoriaServicoDAO.findById(Integer.parseInt(request.getParameter("idCatServico")));

                Servico servico = new Servico();
                servico.setTitulo(request.getParameter("nomeServico"));
                servico.setDescricao(request.getParameter("descricaoServico"));
                servico.setPreço(Double.parseDouble(request.getParameter("valorServico")));
                servico.setFkFornecedor(userEvent2);
                servico.setFkCategoriaservico(catServ);

                usuarioDAO.persist(userEvent2);
                servicoDAO.persist(servico);

                request.getSession().setAttribute("usuarioSessao", userEvent2);
                request.getSession().setAttribute("successmsg", "Fornecedor afiliado com sucesso");
                returnPage = "/homepage.jsp";

                break;

            case "updateNomeServico":
                Long idServico = Long.parseLong(request.getParameter("idServico"));

                if (idServico == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhum Servico foi selecionado.");
                } else {
                    String nomeServico = request.getParameter("nomeServico");

                    Usuario usuarioSessao = (Usuario) request.getSession().getAttribute("usuarioSessao");

                    usuarioSessao = usuarioDAO.findById(usuarioSessao.getIdUsuario());

                    List<Servico> listaServico = usuarioSessao.getServicoList();

                    for (Servico servico1 : listaServico) {
                        if (servico1.getIdServico() == idServico) {
                            servico1.setTitulo(nomeServico);
                        }
                    }

                    usuarioDAO.update(usuarioSessao);

                    request.getSession().setAttribute("listaServico", listaServico);

                    request.getSession().setAttribute("successmsg", "Nome Serviço atualizado com sucesso");

                }
                returnPage = "/profile.jsp";

                break;

            case "updateDescricaoServico":

                Long idServico2 = Long.parseLong(request.getParameter("idServico2"));

                if (idServico2 == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhum Servico foi selecionado.");
                } else {
                    String descricaoServico = request.getParameter("descricaoServico");

                    Usuario usuarioSessao2 = (Usuario) request.getSession().getAttribute("usuarioSessao");

                    usuarioSessao2 = usuarioDAO.findById(usuarioSessao2.getIdUsuario());

                    List<Servico> listaServico2 = usuarioSessao2.getServicoList();

                    for (Servico servico2 : listaServico2) {
                        if (servico2.getIdServico() == idServico2) {
                            servico2.setDescricao(descricaoServico);
                        }
                    }

                    usuarioDAO.update(usuarioSessao2);

                    request.getSession().setAttribute("listaServico", listaServico2);

                    request.getSession().setAttribute("successmsg", "Descrição Serviço atualizado com sucesso");
                }
                returnPage = "/profile.jsp";

                break;

            case "updateCategoriaServico":

                Long idCategoria = Long.parseLong(request.getParameter("idCategoria"));

                Long idServico3 = Long.parseLong(request.getParameter("idServico3"));

                if (idServico3 == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhum Servico foi selecionado.");
                } else if (idCategoria == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhuma Categoria foi selecionado.");
                } else {

                    Usuario usuarioSessao3 = (Usuario) request.getSession().getAttribute("usuarioSessao");

                    usuarioSessao3 = usuarioDAO.findById(usuarioSessao3.getIdUsuario());

                    Categoriaservico categoriaServico = categoriaServicoDAO.findById(idCategoria);

                    List<Categoriaservico> listaCategoria = categoriaServicoDAO.find();

                    for (Categoriaservico catServico : listaCategoria) {
                        if (catServico.getIdCategoriaservico() == idCategoria) {
                            categoriaServico = catServico;
                        }

                    }

                    List<Servico> listaServico3 = usuarioSessao3.getServicoList();

                    for (Servico servico3 : listaServico3) {
                        if (servico3.getIdServico() == idServico3) {
                            servico3.setFkCategoriaservico(categoriaServico);
                        }
                    }

                    usuarioDAO.update(usuarioSessao3);

                    request.getSession().setAttribute("listaServico", listaServico3);

                    request.getSession().setAttribute("successmsg", "Categoria Serviço atualizado com sucesso");
                }
                returnPage = "/profile.jsp";

                break;

            case "updatePrecoServico":

                Long idServico4 = Long.parseLong(request.getParameter("idServico4"));

                if (idServico4 == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhum Servico foi selecionado.");
                } else {
                    double precoServico = Double.parseDouble(request.getParameter("precoServico"));

                    Usuario usuarioSessao4 = (Usuario) request.getSession().getAttribute("usuarioSessao");

                    usuarioSessao4 = usuarioDAO.findById(usuarioSessao4.getIdUsuario());

                    List<Servico> listaServico4 = usuarioSessao4.getServicoList();

                    for (Servico servico4 : listaServico4) {
                        if (servico4.getIdServico() == idServico4) {
                            servico4.setPreço(precoServico);
                        }
                    }

                    usuarioDAO.update(usuarioSessao4);

                    request.getSession().setAttribute("listaServico", listaServico4);

                    request.getSession().setAttribute("successmsg", "Preço do Serviço atualizado com sucesso");
                }

                returnPage = "/profile.jsp";

                break;

            case "createServico":

                Long idCategoria2 = Long.parseLong(request.getParameter("idCategoria2"));

                if (idCategoria2 == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhuma categoria foi selecionado.");
                } else {
                    Categoriaservico categoriaServico = categoriaServicoDAO.findById(Integer.parseInt(request.getParameter("idCategoria2")));

                    Usuario usuarioSessao = (Usuario) request.getSession().getAttribute("usuarioSessao");

                    Servico servico2 = new Servico();
                    servico2.setTitulo(request.getParameter("nomeServico"));
                    servico2.setDescricao(request.getParameter("descricaoServico"));
                    servico2.setPreço(Double.parseDouble(request.getParameter("precoServico")));
                    servico2.setFkFornecedor(usuarioSessao);
                    servico2.setFkCategoriaservico(categoriaServico);

                    servicoDAO.persist(servico2);

                    List<Servico> listaServico = refreshServicos(usuarioSessao);

                    request.getSession().setAttribute("listaServico", listaServico);

                    request.getSession().setAttribute("successmsg", "Serviço cadastrado com sucesso");
                }

                returnPage = "/profile.jsp";

                break;

            case "deleteServico":
                Long idServico5 = Long.parseLong(request.getParameter("idServico5"));

                if (idServico5 == -1) {
                    request.getSession().setAttribute("errormsg", "Nenhum Servico foi selecionado.");
                } else {

                    Servico servico3 = servicoDAO.findById(idServico5);

                    servicoDAO.remove(servico3);

                    Usuario usuarioSessao2 = (Usuario) request.getSession().getAttribute("usuarioSessao");
                    List<Servico> listaServico2 = refreshServicos(usuarioSessao2);

                    request.getSession().setAttribute("listaServico", listaServico2);

                    request.getSession().setAttribute("successmsg", "Servico deletado com sucesso");
                }

                returnPage = "/profile.jsp";
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

    private ServicoDAO lookupServicoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ServicoDAO) c.lookup("java:global/PortalDeEventos/PortalDeEventos-ejb/ServicoDAO!com.br.portal.dao.ServicoDAO");
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

    public List<Servico> refreshServicos(Usuario us) {
        List<Servico> lista2 = servicoDAO.find();
        List<Servico> novaLista2 = new ArrayList<>();

        for (Servico ser : lista2) {
            if (ser.getFkFornecedor().getIdUsuario().equals(us.getIdUsuario())) {
                novaLista2.add(ser);
            }
        }
        return novaLista2;
    }

}
