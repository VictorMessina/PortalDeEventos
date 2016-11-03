<%-- 
    Document   : editProfile
    Created on : 27/10/2016, 08:04:20
    Author     : 31449530
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Editar Perfil </title>
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
                margin-top: 15%;
            }

            /*----------BOTÕES---------*/
            input[type="submit"],
            #botao {
                transition: background-color 0.35s ease-in-out;
                background: #6CA6CD;
                border-radius: 6px;
                border-style: outset;
                color: #fff;
                cursor: pointer;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                text-transform: uppercase;
                font-size: 14px;
            }
            input[type="submit"]:hover,
            #botao:hover {
                background: #FF7700;
            }
        </style>
        <script type="text/javascript">
            var form1;
            var form2;
            var form3;
            var form4;
            var form5;
            var form6;
            var form7;
            var form8;
            var form9;
            var form10;
            var form11;
            var form12;
            var form13;

            window.onload = function () {
                form1 = document.getElementById("form1");
                form2 = document.getElementById("form2");
                form3 = document.getElementById("form3");
                form4 = document.getElementById("form4");
                form5 = document.getElementById("form5");
                form6 = document.getElementById("form6");
                form7 = document.getElementById("form7");
                form8 = document.getElementById("form8");
                form9 = document.getElementById("form9");
                form10 = document.getElementById("form10");
                form11 = document.getElementById("form11");
                form12 = document.getElementById("form12");
                form13 = document.getElementById("form13");

                form1.style.display = "none";
                form2.style.display = "none";
                form3.style.display = "none";
                form4.style.display = "none";
                form5.style.display = "none";
                form6.style.display = "none";
                form7.style.display = "none";
                form8.style.display = "none";
                form9.style.display = "none";
                form10.style.display = "none";
                form11.style.display = "none";
                form12.style.display = "none";
                form13.style.display = "none";
            };

            function mostrar(num) {
                if (num === 1) {
                    form1.style.display = "block";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 2) {
                    form2.style.display = "block";
                    form1.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 3) {
                    form3.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 4) {
                    form4.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 5) {
                    form5.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form4.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 6) {
                    form6.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 7) {
                    form7.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 8) {
                    form8.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 9) {
                    form9.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 10) {
                    form10.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 11) {
                    form11.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form12.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 12) {
                    form12.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form13.style.display = "none";
                } else if (num === 13) {
                    form13.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                    form7.style.display = "none";
                    form8.style.display = "none";
                    form9.style.display = "none";
                    form10.style.display = "none";
                    form11.style.display = "none";
                    form12.style.display = "none";
                }
            }
        </script>
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
            <c:if test="${successmsg!=null && !''.equals(successmsg)}">
                <p class="success">${successmsg}</p>
                <c:set scope="session" var="successmsg" value=""></c:set>
            </c:if>

            <c:if test="${errormsg!=null && !''.equals(errormsg)}">
                <p class="error">${errormsg}</p>
                <c:set scope="session" var="errormsg" value=""></c:set>
            </c:if>
            <br><br>    
            <a href="FrontController?command=Usuario&action=perfil&idUsuario=${usuarioSessao.getIdUsuario()}">< Voltar</a>

            <br><br><br><br>
            <center><button id="botao" onclick="mostrar(1)">Atualizar Senha</button>
                <button id="botao" onclick="mostrar(2)">Atualizar nome</button>
                <button id="botao" onclick="mostrar(3)">Atualizar Email</button>
                <br><br><br>
                <button id="botao" onclick="mostrar(4)">Atualizar Descrição</button>
                <button id="botao" onclick="mostrar(5)">Atualizar Telefone 1</button>
                <button id="botao" onclick="mostrar(6)">Atualizar Telefone 2</button>

                <c:choose>
                    <c:when test="${usuarioSessao.getFkTipousuario().getIdTipousuario() == 1}">

                    </c:when>

                    <c:when test="${usuarioSessao.getFkTipousuario().getIdTipousuario() == 2}">

                        <button id="botao" onclick="mostrar(7)">Atualizar comissão</button>

                    </c:when>

                    <c:when test="${usuarioSessao.getFkTipousuario().getIdTipousuario() == 3}">

                        <button id="botao" onclick="mostrar(8)">Atualizar nome serviço</button>
                        <button id="botao" onclick="mostrar(9)">Atualizar descrição serviço</button>
                        <button id="botao" onclick="mostrar(10)">Atualizar categoria serviço</button>
                        <button id="botao" onclick="mostrar(11)">Atualizar preço serviço</button>
                        <button id="botao" onclick="mostrar(12)">Criar Serviço</button>
                        <button id="botao" onclick="mostrar(13)">Deletar Serviço</button>
                    </c:when>

                </c:choose>    


                <div>
                    <!-- Atualizar senha -->
                    <form id="form1" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Senha</h3>
                        <p><input type="password" name="password" placeholder="nova senha" required="required"/></p>
                        <p><input type="password" name="password2" placeholder="confirme nova senha" required="required"/></p>
                        <p><input type="hidden" name="command" value="Usuario"/></p>
                        <p><input type="hidden" name="action" value="updatePassword"/></p>
                        <p><input type="submit" value="ALTERAR"/></p>
                    </form>

                    <!-- Atualizar nome -->
                    <form id="form2" action="FrontController" method="POST">
                        <br><h3>Nome atual</h3>
                        <p><input type="text" value="${usuarioSessao.getUsuarioinfo().getNome()}" disabled="disabled"/></p>
                        <br><h3>Novo Nome</h3>
                        <p><input type="text" name="fullname" placeholder="Nome Completo" maxlength="100" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateFullName"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar rmail -->
                    <form id="form3" action="FrontController" method="POST">
                        <br><h3> Email atual</h3>
                        <p><input type="email" value="${usuarioSessao.getUsuarioinfo().getEmail()}" disabled="disabled"/></p>
                        <br><h3>Novo Email</h3>
                        <p><input type="email" name="email" placeholder="Ex.: email@email.com" maxlength="50" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateEmail"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar descrição -->
                    <form id="form4" action="FrontController" method="POST">
                        <br><h3>Descrição atual</h3>
                        <p><input type="text" value="${usuarioSessao.getUsuarioinfo().getDescricao()}" disabled="disabled"/></p>
                        <br><h3>Nova descrição</h3>
                        <p><input type="text" name="descricao" placeholder="Descrição" maxlength="150" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateDescricao"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar telefone 1 -->
                    <form id="form5" action="FrontController" method="POST">
                        <br><h3>Telefone 1 atual</h3>
                        <p><input type="tel" value="${usuarioSessao.getUsuarioinfo().getTelefone1()}" disabled="disabled"/></p>
                        <br><h3>Novo telefone 1</h3>
                        <p><input type="tel" name="telefone1" placeholder="Ex.: 11922223333" maxlength="11" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateTelefone1"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar telefone 2 -->
                    <form id="form6" action="FrontController" method="POST">
                        <br><h3>Telefone 2 atual</h3>
                        <p><input type="tel" value="${usuarioSessao.getUsuarioinfo().getTelefone2()}" disabled="disabled"/></p>
                        <br><h3>Novo telefone 2</h3>
                        <p><input type="tel" name="telefone2" placeholder="Ex.: 11922223333" maxlength="11" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateTelefone2"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar Comissão -->
                    <form id="form7" action="FrontController" method="POST">
                        <br><h3>Comissão atual</h3>
                        <p><input type="text" value="${usuarioSessao.getUsuarioinfo().getComissao()}"/></p>
                        <br><h3>Nova comissão (%)</h3>
                        <p><input type="number" name="comissao" placeholder="Ex.: 10%" required></p>
                        <input type="hidden" name="command" value="Promoter"/>
                        <input type="hidden" name="action" value="updateComissao"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar Nome Serviço -->
                    <form id="form8" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Nome Serviço</h3>
                        <select name="idServico" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="servico" items="${listaServico}">
                                <option value="${servico.getIdServico()}"> ${servico.getTitulo()} </option>
                            </c:forEach> 

                        </select>
                        <p><input type="text" name="nomeServico" placeholder="nome serviço" maxlength="50" required="required"/></p>
                        <input type="hidden" name="command" value="Fornecedor"/>
                        <input type="hidden" name="action" value="updateNomeServico"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar Descrição Serviço -->
                    <form id="form9" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Descrição Serviço</h3>
                        <p>Nome Serviço</p>
                        <select name="idServico2" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="servico" items="${listaServico}">
                                <option value="${servico.getIdServico()}"> ${servico.getTitulo()} </option>
                            </c:forEach> 

                        </select>
                        <p><input type="text" name="descricaoServico" placeholder="descrição serviço" maxlength="500" required="required"/></p>
                        <input type="hidden" name="command" value="Fornecedor"/>
                        <input type="hidden" name="action" value="updateDescricaoServico"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar Categoria Serviço -->
                    <form id="form10" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Categoria Serviço</h3>
                        <p>Nome Serviço</p>
                        <select name="idServico3" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="servico" items="${listaServico}">
                                <option value="${servico.getIdServico()}"> ${servico.getTitulo()} </option>
                            </c:forEach> 

                        </select>
                        <p>Nova Categoria</p>
                        <select name="idCategoria" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="categoria" items="${categorias}">
                                <option value="${categoria.getIdCategoriaservico()}"> ${categoria.getNomecategoriaservico()} </option>
                            </c:forEach> 

                        </select>
                        <input type="hidden" name="command" value="Fornecedor"/>
                        <input type="hidden" name="action" value="updateCategoriaServico"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar Preço Serviço -->
                    <form id="form11" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Preço do Serviço</h3>
                        <p>Nome Serviço</p>
                        <select name="idServico4" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="servico" items="${listaServico}">
                                <option value="${servico.getIdServico()}"> ${servico.getTitulo()} </option>
                            </c:forEach> 

                        </select>
                        <p><input type="number" name="precoServico" placeholder="10" required="required"/></p>
                        <input type="hidden" name="command" value="Fornecedor"/>
                        <input type="hidden" name="action" value="updatePrecoServico"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Criar Serviço -->
                    <form id="form12" action="FrontController" method="POST">
                        <br><br><br><h3>Criar Serviço</h3>
                        <p>Categoria</p>
                        <select name="idCategoria2" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="categoria" items="${categorias}">
                                <option value="${categoria.getIdCategoriaservico()}"> ${categoria.getNomecategoriaservico()} </option>
                            </c:forEach> 

                        </select>
                        <h1> Nome do serviço: * <br><input type="text" name="nomeServico" placeholder="nome do serviço" required/></h1>
                        <h1> Descrição do serviço: *<br><input type="text" name="descricaoServico" placeholder="descrição do serviço" required/></h1>
                        <h1> Valor inicial do serviço (R$): *<br><input type="number" name="precoServico" placeholder="Ex.: 0,00" required/></h1>

                        <input type="hidden" name="command" value="Fornecedor"/>
                        <input type="hidden" name="action" value="createServico"/>
                        <p><input type="submit" value="Criar"/></p>
                    </form>

                    <!-- Deletar Serviço -->
                    <form id="form13" action="FrontController" method="POST">
                        <br><br><br><h3>Excluir Serviço</h3>
                        <p>Nome Serviço</p>
                        <select name="idServico5" required>
                            <option value="-1"> selecionar </option>
                            <c:forEach var="servico" items="${listaServico}">
                                <option value="${servico.getIdServico()}"> ${servico.getTitulo()} </option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="command" value="Fornecedor"/>
                        <input type="hidden" name="action" value="deleteServico"/>
                        <p><input type="submit" value="deletar serviço"/></p>
                    </form>

                </div>
            </center>
        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
