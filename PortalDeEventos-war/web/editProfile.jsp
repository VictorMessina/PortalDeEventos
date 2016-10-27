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
            window.onload = function () {
                form1 = document.getElementById("form1");
                form2 = document.getElementById("form2");
                form3 = document.getElementById("form3");
                form4 = document.getElementById("form4");
                form5 = document.getElementById("form5");
                form6 = document.getElementById("form6");

                form1.style.display = "none";
                form2.style.display = "none";
                form3.style.display = "none";
                form4.style.display = "none";
                form5.style.display = "none";
                form6.style.display = "none";
            };

            function mostrar(num) {
                if (num === 1) {
                    form1.style.display = "block";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                } else if (num === 2) {
                    form2.style.display = "block";
                    form1.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                }
                else if (num === 3) {
                    form3.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                } else if (num === 4) {
                    form4.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form5.style.display = "none";
                    form6.style.display = "none";
                }
                else if (num === 5) {
                    form5.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form4.style.display = "none";
                    form6.style.display = "none";
                } else if (num === 6) {
                    form6.style.display = "block";
                    form1.style.display = "none";
                    form2.style.display = "none";
                    form3.style.display = "none";
                    form4.style.display = "none";
                    form5.style.display = "none";
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
                <a href="profile.jsp">Perfil</a>
                <a href="contato.jsp">Contato</a>
                <a href="sobre.jsp">Sobre</a>
            </div>
        </div>

        <div class="container">        
            <c:if test="${successmsg!=null && !''.equals(successmsg)}">
                <p class="success">${successmsg}</p>
                <c:set scope="session" var="successmsg" value=""></c:set>
            </c:if>

            <br><br><br><br>
            <center><button id="botao" onclick="mostrar(1)">Atualizar Senha</button>
                <button id="botao" onclick="mostrar(2)">Atualizar nome</button>
                <button id="botao" onclick="mostrar(3)">Atualizar Email</button>
                <br><br><br>
                <button id="botao" onclick="mostrar(4)">Atualizar Descrição</button>
                <button id="botao" onclick="mostrar(5)">Atualizar Telefone 1</button>
                <button id="botao" onclick="mostrar(6)">Atualizar Telefone 2</button>


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
                        <br><br><br><h3>Atualizar Nome</h3>
                        <p><input type="text" name="fullname" placeholder="Nome Completo" maxlength="100" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateFullName"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar rmail -->
                    <form id="form3" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Email</h3>
                        <p><input type="email" name="email" placeholder="Ex.: email@email.com" maxlength="50" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateEmail"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar descrição -->
                    <form id="form4" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Descrição</h3>
                        <p><input type="text" name="descricao" placeholder="Descrição" maxlength="150" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateDescricao"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar telefone 1 -->
                    <form id="form5" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Telefone 1</h3>
                        <p><input type="tel" name="telefone1" placeholder="Ex.: 11922223333" maxlength="11" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateTelefone1"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>

                    <!-- Atualizar telefone 2 -->
                    <form id="form6" action="FrontController" method="POST">
                        <br><br><br><h3>Atualizar Telefone 2</h3>
                        <p><input type="tel" name="telefone2" placeholder="Ex.: 11922223333" maxlength="11" required="required"/></p>
                        <input type="hidden" name="command" value="Usuario"/>
                        <input type="hidden" name="action" value="updateTelefone2"/>
                        <p><input type="submit" value="ATUALIZAR"/></p>
                    </form>
                </div>
            </center>
        </div>
                    
        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
