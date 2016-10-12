<%-- 
    Document   : registerPromoter
    Created on : 05/10/2016, 16:15:02
    Author     : Victor M
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Afiliação de Promoters </title>
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
                margin-top: 865px;
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
                    <h1><i> Afiliação de Promoters </i></h1>
                    <br><p> * Informações Obrigatórias </p>
                    <h1> Insira suas informações pessoais: </h1>
                    <h1> Nome Completo: *<br><input type="text" name="nome" placeholder="Nome Completo" maxlength="100" required/></h1>
                    <h1> Email: *<br><input type="email" name="email" placeholder="Ex.: email@email.com" maxlength="50" required/></h1>
                    <h1> Telefone 1 (com DDD, sem traços): *<br><input type="tel" name="telefone1" placeholder="Ex.: 11922223333" maxlength="11" required/></h1>
                    <h1> Telefone 2 (com DDD, sem traços):<br><input type="tel" name="telefone2" placeholder="Ex.: 11922223333" maxlength="11" /></h1>
                    <h1> Descrição: (Aparecerá no seu perfil público)<br><input type="text" name="descricao" placeholder="Descrição" maxlength="150" /></h1>
                        <c:choose>
                            <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 1}">
                            <h1> CPF (sem pontos ou traços):*<br><input type="text" name="numeroCadastro" placeholder="Ex.: 12345678910" maxlength="11" required/></h1>
                            </c:when>
                            <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 2}">
                            <h1> CNPJ (sem pontos ou traços):*<br><input type="text" name="numeroCadastro" placeholder="Ex.: 12345678900000" maxlength="14" required/></h1>
                            </c:when>
                        </c:choose>
                    <h1> Valor inicial de preço (R$): * <br><input type="number" name="preco" placeholder="Ex.: 0,00" required></h1>

                    <h1><input type="hidden" name="command" value="Promoter"/></h1>
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
