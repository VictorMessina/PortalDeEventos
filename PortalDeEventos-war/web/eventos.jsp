<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        .footer{
            margin-top: 500px;
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
            <a href="eventos.jsp">Eventos</a>
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
                    <a href="eventos.jsp">Meus Eventos</a>
                    <a href="criarEvento.jsp">Criar Evento</a>
                    <a href="">Buscar Promoter</a>
                </div>
            </div>
        </div>

        <div class="posts">
            <div class="text">
                <h2> Eventos </h2>
            </div>

            <div class="eventos">
                <div class="etitulo">
                    <i class="fa fa-calendar" style="float:right"></i> 
                    <p>Nome do evento</p>
                    <c:out value="${eventoSessao.titulo}"/>
                </div>

                <div class="ecaixa">
                    <p> Descriçao do evento </p>
                    <c:out value="${eventoSessao.descricao}"/>
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
    </div>
</body>