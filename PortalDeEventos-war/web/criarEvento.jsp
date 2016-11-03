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
        <title> Criar Evento </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="laranja.ico">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(document).ready(function () {
                $("#txtFromDate").datepicker({
                    numberOfMonths: 2,
                    minDate: 0,
                    onSelect: function (selected) {
                        $("#txtToDate").datepicker("option", "minDate", selected)
                    }
                });
                $("#txtToDate").datepicker({
                    numberOfMonths: 2,
                    onSelect: function (selected) {
                        $("#txtFromDate").datepicker("option", "maxDate", selected)
                    }
                });
            });
        </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- fontes -->
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
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
                    <form action="FrontController" method="POST">
                        <h2> Novo Evento  </h2>
                        <p> * Informações Obrigatórias </p>
                        <br>
                        <h1>Selecione a categoria do evento: *</h1>
                        <select name="idCatEvento">
                            <c:forEach var="catEvento" items="${listaCatEvento}">
                                <option value="${catEvento.getIdCategoriaevento()}"> ${catEvento.getNomecategoriaevento()} </option>
                            </c:forEach>
                        </select>
                        <h1> Título: * <br><input type="text" name="titulo" placeholder="título" required/></h1>
                        <h1> Descrição: *<br><input type="text" name="descricao" placeholder="descriçao"/></h1>
                        <h1> Local: *<br><input type="text" name="local" placeholder="local" required/></h1>
                        <h1> Data Inicial: *</h1><br><input type="text" id="txtFromDate" name="dataini"/>
                        <h1> Hora de Inicio: *<br>
                            <select name="horaini" placeholder="HH">
                                <c:forEach var="h" begin="0" end="24">
                                    <c:if test="${h < 10}">
                                        <option value="${h}">0${h}</option>
                                    </c:if>
                                    <c:if test="${h > 9}">
                                        <option value="${h}">${h}</option>
                                    </c:if>    
                                </c:forEach>
                            </select>
                            H

                            <select name="minini" placeholder="MM">
                                <c:forEach var="m" begin="0" end="59">
                                    <c:if test="${m < 10}">
                                        <option value="${m}">0${m}</option>
                                    </c:if>
                                    <c:if test="${m > 9}">
                                        <option value="${m}">${m}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                            M

                        </h1>
                        <h1> Data Final: *<br><input type="text" id="txtToDate" name="datafim"/>
                            <h1> Hora Fim: *<br>
                                <select name="horafim" placeholder="HH">
                                    <c:forEach var="h" begin="0" end="23">
                                        <c:if test="${h < 10}">
                                            <option value="${h}">0${h}</option>
                                        </c:if>
                                        <c:if test="${h > 9}">
                                            <option value="${h}">${h}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                H    

                                <select name="minfim" placeholder="MM">
                                    <c:forEach var="m" begin="0" end="59">
                                        <c:if test="${m < 10}">
                                        <option value="${m}">0${m}</option>
                                    </c:if>
                                    <c:if test="${m > 9}">
                                        <option value="${m}">${m}</option>
                                    </c:if>
                                    </c:forEach>
                                </select>
                                M
                            </h1>
                            <h1> Tema: *<br><input type="text" name="tema" placeholder="Insira o tema do seu evento" required /></h1>
                            <h1> Numero de convidados: *<br><input type="number"  name="nconvidados" placeholder="Numero de convidados" required /></h1>
                            <h1> Descrição do Buffet: *<br><input type="text" name="buffet" placeholder="Descrição do Buffet" required /></h1>
                            <h1> Descrição da decoração: *<br><input type="text" name="decoracao" placeholder="Descrição da decoração" required /></h1>
                            <h1> Descrição das atrações: *<br><input type="text" name="atracoes" placeholder="Descrição das atrações" required /></h1>

                            <h1><input type="hidden" name="command" value="Evento"/></h1>
                            <h1><input type="hidden" name="action" value="insert"/></h1>
                            <br><h1><input type="submit" value="CRIAR"/></h1>

                    </form>
                </div>
            </div>
        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
