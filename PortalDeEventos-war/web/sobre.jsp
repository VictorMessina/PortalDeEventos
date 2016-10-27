<%-- 
    Document   : sobre
    Created on : 08/10/2016, 19:00:00
    Author     : Letícia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>EVENTOS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="laranja.ico.png">
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
                margin-top: 10px;
            }
            img{
                border-radius: 50%;
            }
            
            /*----------HEADER---------*/
            .topbar {
                margin: 1% 0% 0% 8%; /*---- top right bottom left --*/
            }
        </style>
    </head>

    <body>  
        <div class="topbar">
            <a href="homepage.jsp"><img src="laranja.ico" alt="LOGO"/></a>
            <div class="title">EVENTOS</div><br>
            <div class="subtitle">portal de eventos</div>

            <div class="links">
                <a href="homepage.jsp">Voltar</a>
                <a href="sobre.jsp">Sobre</a>
            </div>
        </div>

        <div class="container">

            <table style="width:70%">
                <tr>
                    <td><img src="https://scontent.fcpq1-1.fna.fbcdn.net/v/t1.0-9/12734059_559421630880127_7141839974987295903_n.jpg?oh=b66540347af3aaa159cd726b0915abf2&oe=58740FB5" alt="Hugo Keniti" height="200" width="200"></td>

                    <td><img src="https://scontent.fcpq1-1.fna.fbcdn.net/v/t1.0-9/11698625_976878449028860_3921411231176410218_n.jpg?oh=96bce106d3add0782307db9e1b46d21a&oe=586276DC" alt="Letícia Garcia" height="200" width="200"></td>
                </tr>
                <tr>
                    <td><img src="https://scontent.fcpq1-1.fna.fbcdn.net/v/t1.0-9/13055477_613901232096415_7971776520560186520_n.jpg?oh=2c21817ff0313e8b2779036a76e54bb6&oe=586C78CC" alt="Vitória Previato" height="200" width="200"></td>

                    <td><img src="https://scontent.fcpq1-1.fna.fbcdn.net/v/t1.0-9/1457670_591978994228550_36718279_n.jpg?oh=c41a3bb5b30ce519d6b7149bca012f33&oe=589EB405" alt="Victor Messina"  height="200" width="200"></td>
                </tr>
            </table>
            <br><br>
            <center><h1>Alunos de Projeto Interdisciplinar do curso de Sistemas de Informação da Universidade Presbiteriana Mackenzie</h1></center>

        </div>

        <div class="footer">
            Copyright © 2016. Hugo, Letícia, Victor, Vitória. All rights reserved.
        </div>
    </body>
</html>
