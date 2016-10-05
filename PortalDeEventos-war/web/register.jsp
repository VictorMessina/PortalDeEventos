<%-- 
    Document   : register
    Created on : 04/10/2016, 16:35:51
    Author     : Victor M
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Afiliação de usuário</title>
    </head>
    <body>
        <form action="FrontController" method="post">
            <br><br><br><h3>Afiliação Usuario</h3>
            <p> Login: <input type="text" name="login" placeholder="login" maxlength="10" required/></p>
            <p>Senha: <input type="password" name="password" placeholder="Nova senha" required="required"/></p>
            <p>Confirma Senha: <input type="password" name="password2" placeholder="Confirmar senha nova" required="required"/></p>

            <p>Escolha o tipo de cliente que deseja ser</p>
            <p><input type="radio" name="tipoUsuario" value="1" checked="checked"/> Cliente </p>
            <p><input type="radio" name="tipoUsuario" value="2"/> Promoter </p>
            <p><input type="radio" name="tipoUsuario" value="3"/> Fonecedor de Serviços </p>

            <p>Escolha o tipo de pessoa que deseja cadastrar</p>
            <p><input type="radio" name="tipoPessoa" value="1" checked="checked"/> Pessoa Fisica </p>
            <p><input type="radio" name="tipoPessoa" value="2"/> Pessoa Jurídica </p>

            <p><input type="hidden" name="command" value="Usuario"/></p>
            <p><input type="hidden" name="action" value="insert"/></p>
            <p><input type="submit" value="AFILIAR-SE"/></p>
        </form>

    </body>
</html>
