<%-- 
    Document   : index
    Created on : 04/10/2016, 16:35:04
    Author     : Victor M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Portal de Eventos</title>
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
                margin-top: 450px;
            }

            /*----------COLUNAS---------*/
            .colunasindex{
                text-align: center;
                margin-top: 60px;
            }
            #conteudo-left{
                width: 500px;
                height: 380px;
                margin-left: 110px;
                float:left;
                background-color: #F8F8FF;
            }
            #conteudo-right{
                width: 500px;
                height: 380px;
                float:left;
                background-color: #F8F8FF;
            }
        </style>
    </head>

    <body>
        <div class="topbar">
            <img src="eventos.png"/>
            <div class="title">EVENTOS</div><br>
            <div class="subtitle">portal de eventos</div>

            <div class="links">
                <a href="sobre.html">Sobre</a>
            </div>
        </div>

        <div class="container">
            <div class="colunasindex">
                <div id="conteudo-left">
                    <br><br>
                    <h1> Já possui conta? <br> Faça login! </h1>
                    <form action="FrontController" method="POST">
                        <h1><input type="text" name="login" placeholder="login" required/></h1>
                        <h1><input type="password" name="password" placeholder="password" required/></h1>
                        <h1><input type="checkbox" name="lembrar"> lembrar? </h1>
                        <h1><input type="submit" value="LOGIN"/></h1>
                    </form>
                </div>
                <div id="conteudo-right">
                    <br><br>
                    <h1> Ainda não se cadastrou? </h1>
                    <h1> Comece já! </h1>
                    <form action="register.jsp">
                        <h1><input type="submit" value="SING UP"/></h1>
                    </form>
                </div>
            </div>
        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
