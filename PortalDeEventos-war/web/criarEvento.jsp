<%-- 
    Document   : criarEvento
    Created on : 9-Oct-2016, 7:42:11 PM
    Author     : HugoKeniti
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>EVENTOS</title>
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
    <link rel="stylesheet" href="style.css"/>
    <style>
        .footer{
            margin-top: 65px;
        }
    </style>
</head>

<body>
    <c:if test="${usuarioSessao==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
    </c:if>  
    <div class="topbar">
        <img src="eventos.png" alt="LOGO"/>
        <div class="title">EVENTOS</div><br>
        <div class="subtitle">portal de eventos</div>

        <div class="links">
            <a href="">Home</a>
            <a href="eventos.html">Eventos</a>
            <a href="">Perfil</a>
            <a href="">Contato</a>
            <a href="sobre.html">Sobre</a>
            <a href="">Logout</a>
        </div>
    </div>

    <div class="container">
        <div class="sidebar">
            <div class="mtitulo"><i class="fa fa-list" style="float:left"></i> MENU </div>
            <div class="mcaixa">
                <div class="lcaixa">
                    <a href="eventos.html">Meus Eventos</a>
                    <a href="criarEvento.html">Criar Evento</a>
                    <a href="">Buscar Promoter</a>
                </div>
            </div>
        </div>

        <div class="posts">
            <div class="text">
                <form action="FrontController" method="POST">
                    <h2> Novo Evento  </h2>
                    <p> * Informações Obrigatórias </p>
                    <br>
                    
                    <select name="idCatEvento">
                        <option value="-1"> Selecione a categoria do seu evento: *</option>
                         <c:forEach var="catEvento" items="${listaCatEvento}">
                            <option value="${catEvento.getIdCategoriaevento()}"> ${catEvento.getNomecategoriaevento()} </option>
                        </c:forEach>
                    </select>
                    <h1> Crie um título: * <br><input type="text" name="titulo" placeholder="título" required/></h1>
                    <h1> Adicione uma descrição: *<br><input type="text" name="descricao" placeholder="descriçao"/></h1>
                    <h1> Informe o local: *<br><input type="text" name="local" placeholder="local" required/></h1>
                    <h1> Informe a data: *<br><input type="date" name="data" placeholder="dd/mm/yyyy" required /></h1>
                    
                    <h1><input type="hidden" name="command" value="Evento"/></h1>
                    <h1><input type="hidden" name="action" value="insert"/></h1>
                    <br><h1><input type="submit" value="CRIAR"/></h1><br>

                </form>
            </div>
        </div>
    </div>

    <div class="footer">
        Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
    </div>
</body>
</html>
