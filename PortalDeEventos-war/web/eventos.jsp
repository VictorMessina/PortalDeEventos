
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Eventos </title>
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
                margin-top: 35%;
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

        <c:if test="${usuarioSessao.getFkTipousuario().getIdTipousuario()==1}" >          
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
                        <c:forEach var="evento" items="${usuarioSessao.getEventoList2()}">
                            <div class="etitulo">
                                <i class="fa fa-calendar" style="float:right"></i> 
                                <p><c:out value="${evento.getTitulo()}"/>            
                                (<c:out value="${evento.getDataini().getDay()}"/>/<c:out value="${evento.getDataini().getMonth()}"/>/2016 a <c:out value="${evento.getDatafim().getDay()}"/>/<c:out value="${evento.getDatafim().getMonth()}"/>/2016)</p>
                                                                 
                            </div>
                       
                            <div class="ecaixa">
                                <p> Descrição: <c:out value="${evento.getDescricao()}"/></p>
                                <p> Local: <c:out value="${evento.getLugar()}"/></p>
                                <div style="text-align: center" >
                                    <a href="FrontController?command=Evento&action=perfilEvento&idEvento=${evento.getIdEvento()}"><input type="submit" value="Mais info"/></a>
                                </div>
                            </div>                        

                        </c:forEach>                 
                    </div>
                </div>

            </div>           

        </c:if>

        <c:if test="${usuarioSessao.getFkTipousuario().getIdTipousuario()==2}" >
            <div class="container">
                <div class="sidebar">
                    <div class="mtitulo"><i class="fa fa-list" style="float:left"></i> MENU </div>
                    <div class="mcaixa">
                        <div class="lcaixa">
                            <a href="eventos.jsp">Meus Eventos</a>
                            <a href="">Buscar Fornecedores</a>
                        </div>
                    </div>
                </div>

                <div class="posts">
                    <div class="text">
                        <h2> Eventos </h2>
                    </div>

                    <div class="eventos">
                        <c:forEach var="evento" items="${usuarioSessao.getEventoList2()}">
                            <div class="etitulo">
                                <i class="fa fa-calendar" style="float:right"></i> 
                                <p><c:out value="${evento.getTitulo()}"/>            
                                (<c:out value="${evento.getDataini().getDay()}"/>/<c:out value="${evento.getDataini().getMonth()}"/>/2016 a <c:out value="${evento.getDatafim().getDay()}"/>/<c:out value="${evento.getDatafim().getMonth()}"/>/2016)</p>
                                                                 
                            </div>
                       
                            <div class="ecaixa">
                                <p> Descrição: <c:out value="${evento.getDescricao()}"/></p>
                                <p> Local: <c:out value="${evento.getLugar()}"/></p>
                                <div style="text-align: center" >
                                    <a href="FrontController?command=Evento&action=perfilEvento&idEvento=${evento.getIdEvento()}"><input type="submit" value="Mais info"/></a>
                                </div>
                            </div>                        

                        </c:forEach>                 
                    </div>
                </div>

            </div>   
        </c:if>

        <c:if test="${usuarioSessao.getFkTipousuario().getIdTipousuario()==3}" >
            <div class="container">
                <div class="sidebar">
                    <div class="mtitulo"><i class="fa fa-list" style="float:left"></i> MENU </div>
                    <div class="mcaixa">
                        <div class="lcaixa">
                            <a href="eventos.jsp">Meus Eventos</a>
                        </div>
                    </div>
                </div>

                <div class="posts">
                    <div class="text">
                        <h2> Eventos </h2>
                    </div>

                    <!-- ALTERAR A COLLECTION DE ONDE ELE PEGA ESSES DADOS, ESSA É SÓ UMA SIMULAÇÃO-->
                    <div class="eventos">
                        <c:forEach var="evento" items="${usuarioSessao.getEventoList2()}">
                            <div class="etitulo">
                                <i class="fa fa-calendar" style="float:right"></i> 
                                <p><c:out value="${evento.getTitulo()}"/>            
                                (<c:out value="${evento.getDataini().getDay()}"/>/<c:out value="${evento.getDataini().getMonth()}"/>/2016 a <c:out value="${evento.getDatafim().getDay()}"/>/<c:out value="${evento.getDatafim().getMonth()}"/>/2016)</p>
                                                                 
                            </div>
                       
                            <div class="ecaixa">
                                <p> Descrição: <c:out value="${evento.getDescricao()}"/></p>
                                <p> Local: <c:out value="${evento.getLugar()}"/></p>
                                <div style="text-align: center" >
                                    <a href="FrontController?command=Evento&action=perfilEvento&idEvento=${evento.getIdEvento()}"><input type="submit" value="Mais info"/></a>
                                </div>
                            </div>                        

                        </c:forEach>                 
                    </div>
                </div>

            </div>   

        </c:if>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
