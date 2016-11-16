<%-- 
    Document   : visualizarOrcamento
    Created on : 15/11/2016, 23:24:20
    Author     : Vitória
--%>

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

        <div class="container">

             
            <div class="sidebar">
                <div class="mtitulo"><i class="fa fa-list" style="float:left"></i> MENU </div>
                <div class="mcaixa">
                    <div class="lcaixa">
                        <a href="eventos.jsp">Meus Eventos</a>
                        <a href="FrontController?command=Promoter&action=buscaOrcamento">Orçamentos Solicitados</a>
                </div>
                </div>
            </div>
            
            <div class="posts">
                    <a href="FrontController?command=Promoter&action=buscaOrcamento">< Voltar</a>
                    <div class="etitulo">
                        <i class="fa fa-calendar" style="float:right"></i> 
                        <p><c:out value="${orcamentoAtual.getFkEvento().getTitulo()}"/>            
                    </div>
                    
                    <div class="ecaixa"> 
                        <p> <b>Dono do evento:</b>  <a href="FrontController?command=Usuario&action=perfil&idUsuario=${orcamentoAtual.getFkSolicitante().getIdUsuario()}"> <c:out value="${orcamentoAtual.getFkSolicitante().getUsuarioinfo().getNome()}"/></a></p>
                        <p> <b>Local:</b>  <c:out value="${orcamentoAtual.getFkEvento().getLugar()}"/></p>
                        <p> <b>Descrição:</b>  <c:out value="${orcamentoAtual.getFkEvento().getDescricao()}"/></p>                        
                        <p> <b>Inicio:</b>  <c:out value="${orcamentoAtual.getFkEvento().getDataini()}"/></p>
                        <p> <b>Fim:</b>  <c:out value="${orcamentoAtual.getFkEvento().getDatafim()}"/></p>
                        <p> <b>Categoria:</b>  <c:out value="${orcamentoAtual.getFkEvento().getFkCategoriaevento().getNomecategoriaevento()}"/></p>
                        <p> <b>Tema:</b>  <c:out value="${orcamentoAtual.getFkEvento().getCaracteristicasevento().getTema()}"/></p>
                        <p> <b>Número de convidados:</b>  <c:out value="${orcamentoAtual.getFkEvento().getCaracteristicasevento().getNconvidados()}"/></p>
                        <p> <b>Descrição do buffet:</b>  <c:out value="${orcamentoAtual.getFkEvento().getCaracteristicasevento().getBuffet()}"/></p>
                        <p> <b>Descrição da decoração:</b>  <c:out value="${orcamentoAtual.getFkEvento().getCaracteristicasevento().getDecoracao()}"/></p>
                        <p> <b>Descrição das atrações:</b>  <c:out value="${orcamentoAtual.getFkEvento().getCaracteristicasevento().getAtracoes()}"/></p>                                                
                        
                        <div style="text-align: center" >
                            <br>
                            <br>
                            <c:if test="${orcamentoAtual.getValor()==null}">
                                <h1 style="color:#0093B2">Você ainda não enviou um orçamento para este evento.</h1>
                                <p>Preencha o formulário abaixo para enviar um orçamento.</p>                                    
                            </c:if>
                            <c:if test="${orcamentoAtual.getValor()!=null}">
                                <h1 style="color:#0093B2"><b>Orçamento enviado:</b> R$ ${orcamentoAtual.getValor()}  </h1>
                                <h1 style="color:#0093B2"><b>Descrição:</b> ${orcamentoAtual.getDescricao()}  </h1>
                                <br>
                                <p>Preencha o formulário abaixo para reenviar o orçamento. </p> 
                                <p><b>ATENÇÃO: O orçamento acima será substituído.</b></p>
                            </c:if>
                            <form action="FrontController" method="post">
                                <br><p> * Informações Obrigatórias </p>
                                <p> Valor: *<br><input type="number" name="valor" placeholder="Ex.: 1000" required/></p>
                                <p> Descrição: *<br><input type="text" name="descricao" placeholder="Ex.: Aberto a negociações." maxlength="200" required/></p>
                                <h1><input type="hidden" name="command" value="Promoter"/></h1>
                                <h1><input type="hidden" name="action" value="enviarOrcamento"/></h1>
                                <h1><input type="hidden" name="idOrcamento" value="${orcamentoAtual.getIdOrcamento()}"/></h1>
                                <br><h1><input type="submit" value="ENVIAR ORÇAMENTO"/></h1><br>
                            </form>
                        </div> 
                    </div>    
                        
            </div>
                        

        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>



