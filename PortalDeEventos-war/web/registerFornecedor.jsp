<%-- 
    Document   : registerFornecedor
    Created on : 08/10/2016, 21:20:45
    Author     : Letícia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Afiliação de Fornecedores de Serviços </title>
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
                margin-top: 115%;
            }
            /*----------HEADER---------*/
            .topbar {
                margin: 1% 0% 0% 8%; /*---- top right bottom left --*/
            }
        </style>
    </head>
    <body>

        <c:if test="${usuarioSessao==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>

        <div class="topbar">
            <a href="homepage.jsp"><img src="laranja.ico" alt="LOGO"/></a>
            <div class="title">EVENTOS</div><br>
            <div class="subtitle">portal de eventos</div>

            <div class="links">
                <a href="sobre.jsp">Sobre</a>
            </div>
        </div>

        <div class="container">
            <div class="cadastro">
                <form action="FrontController" method="post">
                    <br>
                    <h1><i> Afiliação de Fornecedores de Serviço </i></h1>
                    <br><p> * Informações Obrigatórias </p>
                    <h1> Insira suas informações pessoais: </h1>
                    <h1> Nome pessoal ou da empresa: *<br><input type="text" name="nome" placeholder="Nome Completo" maxlength="100" required/></h1>
                    <h1> Email: *<br><input type="email" name="email" placeholder="Ex.: email@email.com" maxlength="50" required/></h1>
                    <h1> Telefone 1 (com DDD, sem traços): *<br><input type="tel" name="telefone1" placeholder="Ex.: 11922223333" maxlength="11" required/></h1>
                    <h1> Telefone 2 (com DDD, sem traços):<br><input type="tel" name="telefone2" placeholder="Ex.: 11922223333" maxlength="11" /></h1>
                    <h1> Descrição: (Aparecerá no seu perfil público)<br><input type="text" name="descricao" placeholder="Descrição" maxlength="150" class="inputTexto2" /></h1>
                        <c:choose>
                            <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 1}">
                            <h1> CPF (sem pontos ou traços):*<br><input type="text" name="numeroCadastro" placeholder="Ex.: 12345678910" maxlength="11" required/></h1>
                            </c:when>
                            <c:when test="${usuarioSessao.getFkTipopessoa().getIdTipopessoa() == 2}">
                            <h1> CNPJ (sem pontos ou traços):*<br><input type="text" name="numeroCadastro" placeholder="Ex.: 12345678900000" maxlength="14" required/></h1>
                            </c:when>
                        </c:choose>

                    <br><br><br>

                    <h1> Insira as informações do serviço que você fornece: *</h1>
                    <h1>Selecione a categoria do serviço: *</h1>
                    <select name="idCatServico">
                        <c:forEach var="catServico" items="${listaCatServico}">
                            <option value="${catServico.getIdCategoriaservico()}"> ${catServico.getNomecategoriaservico()} </option>
                        </c:forEach>
                    </select>
                    <h1> Nome do serviço: * <br><input type="text" name="nomeServico" placeholder="nome do serviço" required/></h1>
                    <h1> Descrição do serviço: *<br><input type="text" name="descricaoServico" placeholder="descrição do serviço" class="inputTexto2" required/></h1>
                    <h1> Valor inicial do serviço (R$): *<br><input type="number" name="valorServico" placeholder="Ex.: 0,00" required/></h1>

                    <h1><input type="hidden" name="command" value="Fornecedor"/></h1>
                    <h1><input type="hidden" name="action" value="insert"/></h1>
                    <br><h1><input type="submit" value="AFILIAR-SE"/></h1><br>
                </form>
            </div>
        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
