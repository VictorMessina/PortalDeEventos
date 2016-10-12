<%-- 
    Document   : homePage
    Created on : 05/10/2016, 16:39:10
    Author     : Victor M
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
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
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
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
            <a href="">Eventos</a>
            <a href="">Perfil</a>
            <a href="">Contato</a>
            <a href="sobre.html">Sobre</a>
            <a href="FrontController?command=Usuario&action=logout">Logout</a>
        </div>
    </div>

    <div class="container">        
        
        <c:if test="${successmsg!=null && !''.equals(successmsg)}">
            <p class="success">${successmsg}</p>
            <c:set scope="session" var="successmsg" value=""></c:set>
        </c:if>

        <div class="posts">
            <h1>Bem vindo (a) ${usuarioSessao.getUsuarioinfo().getNome()} ! </h1>
            <div class="text">
                <p> Text  Text  Text  Text  Text  Text  Text  Text  Text  </p>
            </div>
        </div>
    </div>

    <div class="footer">

    </div>
</body>
