<%-- 
    Document   : profile
    Created on : Dec 10, 2019, 12:09:01 PM
    Author     : Admin
--%>

<%@page import="user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.user}">
            <div class="card">
                <div class="card-header">
                    User Profile
                </div>
                <div class="card-body">
                    <h5 class="card-title">Username: ${sessionScope.user.username}</h5>
                    <p class="card-text">Email: ${sessionScope.user.email}</p>
                    <p class="card-text">Role: ${sessionScope.user.role}</p>                 
                </div>
            </div>
        </c:if>
    </body>
</html>
