<%-- 
    Document   : result
    Created on : Dec 10, 2019, 9:40:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        
        <div class="container">
            <div class="border border-secondary p-5 m-5 rounded">
                <h4 class="text-center">Congratulations! Your score is:</h4>
                <h1 class="text-center text-success">${score}</h1>
               
            </div>
            <a href="listOfTakingQuiz.jsp" class="btn btn-danger ml-5">Take another Quiz</a>
        </div>
    </body>
</html>
