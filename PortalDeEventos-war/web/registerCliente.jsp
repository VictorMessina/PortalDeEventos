<%-- 
    Document   : registerCliente
    Created on : 08/10/2016, 17:34:35
    Author     : Letícia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Afiliação de Clientes </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="eventos.png">
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
                margin-top: 775px;
            }
        </style>
    </head>
    <body>

        <c:if test="${usuarioSessao==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>

        <div class="topbar">
            <img src="eventos.png"/>
            <div class="title">EVENTOS</div><br>
            <div class="subtitle">portal de eventos</div>

            <div class="links">
                <a href="sobre.html">Sobre</a>
            </div>
        </div>

        <div class="container">
            <div class="cadastro">
                <form action="FrontController" method="post">
                    <br>
                    <h1><i> Afiliação de Clientes </i></h1>
                    <br><p> * Informações Obrigatórias </p>
                    <h1> Insira suas informações pessoais: </h1>
                    <h1> Nome Completo: *<br><input type="text" name="nome" placeholder="Nome Completo" maxlength="100" required/></h1>
                    <h1> Email: *<br><input type="email" name="email" placeholder="E-mail" maxlength="50" required/></h1>
                    <h1> Telefone 1: *<br><input type="tel" name="telefone1" placeholder="Telefone 1" maxlength="11" required/></h1>
                    <h1> Telefone 2: *<br><input type="tel" name="telefone2" placeholder="Telefone 2" maxlength="11" required/></h1>
                    <h1> Descrição: *<br><input type="text" name="descricao" placeholder="Descrição" maxlength="150" required/></h1>
                        <c:choose>
                            <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 1}">
                            <h1> CPF: *<br><input type="text" name="numeroCadastro" placeholder="CPF" maxlength="11" required/></h1>
                            </c:when>
                            <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 2}">
                            <h1> CNPJ: *<br><input type="text" name="numeroCadastro" placeholder="CNPJ" maxlength="14" required/></h1>
                            </c:when>
                        </c:choose>
                            
                    <h1><input type="hidden" name="command" value="Cliente"/></h1>
                    <h1><input type="hidden" name="action" value="insert"/></h1>
                    <br><h1><input type="submit" value="AFILIAR-SE"/></h1>
                </form>
            </div>
        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>