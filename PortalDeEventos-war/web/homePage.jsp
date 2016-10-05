<%-- 
    Document   : homePage
    Created on : 05/10/2016, 16:39:10
    Author     : Victor M
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>

        <c:if test="${usuarioSessao==null}" >
            <c:redirect url="index.jsp"></c:redirect> 
        </c:if>

        <c:if test="${successmsg!=null && !''.equals(successmsg)}">
            <p class="success">${successmsg}</p>
            <c:set scope="session" var="successmsg" value=""></c:set>
        </c:if>
            
        <h1>Vc esta registrado!!!!</h1>
    </body>
</html>
