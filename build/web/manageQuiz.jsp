<%-- 
    Document   : manageQuiz
    Created on : Dec 7, 2019, 12:54:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Quiz</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <h3 class="m-5">Number of questions: <span class="text-danger">0</span></h3>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col" class="text-danger">Question</th>
                        <th scope="col" class="text-danger">Created Date</th>                      
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td scope="row">What the hell?</td>
                        <td>12/07/2019</td>                   
                    </tr>
                    <tr>
                        <td scope="row">What the hell?</td>
                        <td>12/07/2019</td>                   
                    </tr>                 
                </tbody>
            </table>
        </div>
    </body>
</html>
