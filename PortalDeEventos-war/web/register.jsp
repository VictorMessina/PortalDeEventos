<%-- 
    Document   : register
    Created on : 04/10/2016, 16:35:51
    Author     : Victor M
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Afiliação de Usuários </title>
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
                margin-top: 87%;
            }
        </style>
    </head>
    <body>
        <div class="topbar">
            <img src="laranja.ico"/>
            <div class="title">EVENTOS</div><br>
            <div class="subtitle">portal de eventos</div>

            <div class="links">
                <a href="sobre.jsp">Sobre</a>
            </div>
        </div>

    <c:if test="${errormsg!=null && !''.equals(errormsg)}">
        <p class="error">${errormsg}</p>
        <c:set scope="session" var="errormsg" value=""></c:set>
    </c:if>

    <div class="container">
        <div class="cadastro">
            <form action="FrontController" method="post">
                <br><h1><i> Afiliação de Usuários </i></h1>
                <br><p> * Informações Obrigatórias </p>
                <h1> Insira os dados da sua conta: </h1>
                <h1> Login: *<br><input type="text" name="login" placeholder="login" maxlength="10" required/></h1>
                <h1> Senha: *<br><input type="password" name="password" placeholder="Nova senha" required="required"/></h1>
                <h1> Confirme a senha: *<br><input type="password" name="password2" placeholder="Confirmar senha nova" required="required"/></h1>

                <br><br><br>

                <h1> Escolha seu tipo de usuário: * </h1>
                <h1><input type="radio" name="tipoUsuario" value="1" checked="checked"/> Cliente </h1>
                <h1><input type="radio" name="tipoUsuario" value="2"/> Promoter (organizador de eventos)</h1>
                <h1><input type="radio" name="tipoUsuario" value="3"/> Fornecedor de serviços </h1>

                <br><br><br>

                <h1> Selecione se você é Pessoa Física ou Jurídica: * </h1>
                <h1><input type="radio" name="tipoPessoa" value="1" checked="checked"/> Pessoa Fisica </h1>
                <h1><input type="radio" name="tipoPessoa" value="2"/> Pessoa Jurídica </h1>

                <h1><input type="hidden" name="command" value="Usuario"/></h1>
                <h1><input type="hidden" name="action" value="insert"/></h1>
                <br><h1><input type="submit" value="CONTINUAR"/></h1>
            </form>
        </div>
    </div>

    <div class="footer">
        Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
    </div>
</body>
</html>
