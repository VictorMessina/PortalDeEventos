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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Promoter</title>
    </head>
    <body>

        <c:if test="${usuarioSessao==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>

        <form action="FrontController" method="post">
            <p> Nome Completo: <input type="text" name="nome" placeholder="Nome Completo" maxlength="100" required/></p>
            <p> Email: <input type="email" name="email" placeholder="E-mail" maxlength="50" required/></p>
            <p> Telefone 1: <input type="tel" name="telefone1" placeholder="Telefone 1" maxlength="11" required/></p>
            <p> Telefone 2: <input type="tel" name="telefone2" placeholder="Telefone 2" maxlength="11" required/></p>
            <p> Descrição: <input type="text" name="descricao" placeholder="Descrição" maxlength="150" required/></p>
                <c:choose>
                    <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 1}">
                    <p> CPF: <input type="text" name="numeroCadastro" placeholder="CPF" maxlength="11" required/></p>
                    </c:when>
                    <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 2}">
                    <p> CNPJ: <input type="text" name="numeroCadastro" placeholder="CNPJ" maxlength="14" required/></p>
                    </c:when>
                </c:choose>
            <p>Preço: <input type="number" name="preco" placeholder="Preço" required></p>

            <p><input type="hidden" name="command" value="Promoter"/></p>
            <p><input type="hidden" name="action" value="insert"/></p>
            <p><input type="submit" value="AFILIAR-SE"/></p>
        </form>

    </body>
</html>
