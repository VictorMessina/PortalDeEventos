
<%-- 
    Document   : perfil
    Created on : 21/10/2016, 11:31:32
    Author     : 31402836
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Perfil </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="laranja.ico">
        <!-- 
        pra fazer os icones bonitinhos, colocar o link.
        pra escolher quais, ir em http://fontawesome.io/icons/
        e colocar <i class="fa fa-BLABLA" style="float:RIGHT OU LEFT"></i>
        -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- fontes -->
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .footer{
                margin-top: 60%;
            }
        </style>

    </head>

    <body>
        <c:if test="${usuarioSessao==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>    

        <div class="welcome">
            <div class="wlinks">
                <h3> Olá ${usuarioSessao.getUsuarioinfo().getNome()} !
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a style="color:#A8A8A8;" href="FrontController?command=Usuario&action=logout">Logout</a></h3>
            </div>
        </div>

        <div class="topbar">
            <a href="homepage.jsp"><img src="laranja.ico" alt="LOGO"/></a>
            <div class="title">EVENTOS</div><br>
            <div class="subtitle">portal de eventos</div>

            <div class="links">
                <a href="homepage.jsp">Home</a>
                <a href="eventos.jsp">Eventos</a>
                <a href="FrontController?command=Usuario&action=perfil&idUsuario=${usuarioSessao.getIdUsuario()}"> Perfil</a>                      
                <a href="sobre.jsp">Sobre</a>
            </div>
        </div>

        <div class="container">        
            <c:if test="${successmsg!=null && !''.equals(successmsg)}">
                <p class="success">${successmsg}</p>
                <c:set scope="session" var="successmsg" value=""></c:set>
            </c:if>

            <!-- usei a div cadastro pq ela já está posicionada no meio da página -->
            <div class="cadastro">
                <h1> ${usuarioPerfil.getUsuarioinfo().getNome()} </h3>
                <h3> Dados pessoais: </h3>
                <p> <b>Email:</b> ${usuarioPerfil.getUsuarioinfo().getEmail()} </p>
                <p> <b>Telefone:</b> ${usuarioPerfil.getUsuarioinfo().getTelefone1()} </p>
                <p> <b>Telefone 2:</b> ${usuarioPerfil.getUsuarioinfo().getTelefone2()} </p>
                <p> <b>Descrição:</b> ${usuarioPerfil.getUsuarioinfo().getDescricao()} </p>
                    <c:choose>                       

                        <c:when test="${usuarioPerfil.getFkTipousuario().getIdTipousuario() == 2}">
                            <p> <b>Comissão:</b>  ${usuarioPerfil.getUsuarioinfo().getComissao()} %</p>
                        </c:when>

                        <c:when test="${usuarioPerfil.getFkTipousuario().getIdTipousuario() == 3}">                            
                            <br>
                            <h3> Dados de serviços: </h3>
                            <c:forEach var="servico" items="${listaServico}">
                                <p> <b>Nome:</b> ${servico.getTitulo()} </p> 
                                <p> <b>Categoria:</b> ${servico.getFkCategoriaservico().getNomecategoriaservico()}</p> 
                                <p> <b>Descrição:</b> ${servico.getDescricao()} </p>  
                                <p> <b>Preço:</b> ${servico.getPreço()}</p>  
                                <br>
                            </c:forEach>
                        </c:when>
                    </c:choose>

                    <c:if test="${usuarioSessao.getIdUsuario() == usuarioPerfil.getIdUsuario()}">
                        <br><h1><a href="FrontController?command=Usuario&action=editProfile"><input type="submit" value="EDITAR PERFIL"/></a></h1><br>
                    </c:if>
                                  
            </div>
        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>