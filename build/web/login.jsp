<%-- 
    Document   : login
    Created on : Dec 7, 2019, 12:27:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <form class="custom-form" action="login" method="POST">
                <h2 class="mt-5 mb-3">Login form</h2>
                <div class="form-group">
                    <label for="usernameInput">Username</label>
                    <input name="txtUsername" type="text" class="form-control" id="usernameInput" placeholder="Username">             
                </div>
                <div class="form-group">
                    <label for="passwordInput">Password</label>
                    <input name="txtPassword" type="password" class="form-control" id="passwordInput" placeholder="Password">             
                </div>
                <c:if test="${not empty err}">
                    <p class="text-danger">${err}</p>
                </c:if>
                <button type="submit" class="btn btn-primary mb-3">Login</button>
                <br><a href="register.jsp">Don't have account? Create one</a>
            </form>
        </div>
    </body>
</html>
