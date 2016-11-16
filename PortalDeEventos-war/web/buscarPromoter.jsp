<%-- 
    Document   : buscarPromoters
    Created on : 13/11/2016, 10:43:41
    Author     : Victor M
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Buscar promoter </title>
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
                margin-top: 85%;
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

        <c:if test="${successmsg!=null && !''.equals(successmsg)}">
            <p class="success">${successmsg}</p>
            <c:set scope="session" var="successmsg" value=""></c:set>
        </c:if>
            
        <c:if test="${errormsg!=null && !''.equals(errormsg)}">
            <p class="error">${errormsg}</p>
            <c:set scope="session" var="errormsg" value=""></c:set>
        </c:if>

        <div class="container">
            <div class="sidebar">
                <div class="mtitulo"><i class="fa fa-list" style="float:left"></i> MENU </div>
                <div class="mcaixa">
                    <div class="lcaixa">
                        <a href="eventos.jsp">Meus Eventos</a>
                        <a href="criarEvento.jsp">Criar Evento</a>
                        <a href="FrontController?command=Cliente&action=buscarPromoter">Buscar Promoter</a>
                    </div>
                </div>
            </div>

            <div class="posts">
                <div class="text">
                    <h2>Promoters</h2>
                </div>

                <div class="eventos">
                    <c:forEach var="promoter" items="${listaUsuarios}">
                        <c:if test="${promoter.getFkTipousuario().getIdTipousuario()== 2}">

                            <div class="etitulo" style="text-align:center">
                                Perfil: <a href="FrontController?command=Usuario&action=perfil&idUsuario=${promoter.getIdUsuario()}"> <c:out value="${promoter.getUsuarioinfo().getNome()}"/></a>
                            </div>

                            <div class="ecaixa">  
                                <p> <b>Descrição:</b> ${promoter.getUsuarioinfo().getDescricao()} </p>
                                <p> <b>Comissão padrão:</b> ${promoter.getUsuarioinfo().getComissao()} % </p>
                                <form action="FrontController" method="POST">
                                    <select name="idEvento" required>
                                        <option value="-1"> Selecione um evento </option>
                                        <c:forEach var="evento" items="${listaEventos}">
                                            <option value="${evento.getIdEvento()}"> ${evento.getTitulo()} </option>
                                        </c:forEach>
                                    </select>
                                    <p><input type="hidden" name="idPromoter" value="${promoter.getIdUsuario()}"/></p>
                                    <p><input type="hidden" name="command" value="Cliente"/></p>
                                    <p><input type="hidden" name="action" value="solicitarOrcamento"/></p>
                                    <p><input type="submit" value="Solicitar Orçamento"/></p>
                                </form>
                               
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>

    <div class="footer">
        Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
    </div>
</body>
</html>

