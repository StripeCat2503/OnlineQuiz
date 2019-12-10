<%-- 
    Document   : profile
    Created on : Dec 10, 2019, 11:37:23 AM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
        <link rel="stylesheet" href="custom.css" type="text/css">
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <!--        <div id="list-example" class="list-group w-20">
                    <a class="list-group-item list-group-item-action" href="#list-item-1">Profile</a>
                    <a class="list-group-item list-group-item-action" href="#list-item-2">Quiz History</a>
                    <a class="list-group-item list-group-item-action" href="#list-item-3">Take Quiz</a>
                    <a class="list-group-item list-group-item-action" href="#list-item-4">Ranking</a>
                </div>-->

        <nav class="mt-3">
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="true">Profile</a>
                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-quiz-history" role="tab" aria-controls="nav-quiz-history" aria-selected="false">Quiz History</a>              
                <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-ranking" role="tab" aria-controls="nav-ranking" aria-selected="false">Ranking</a>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-profile" role="tabpanel" aria-labelledby="nav-home-tab">
                <jsp:include page="profile.jsp"/>
            </div>
            <div class="tab-pane fade" id="nav-quiz-history" role="tabpanel" aria-labelledby="nav-profile-tab"> 
                <jsp:include page="quizHistory.jsp"/>
            </div>
            <div class="tab-pane fade" id="nav-ranking" role="tabpanel" aria-labelledby="nav-contact-tab">
                
            </div>
        </div>
    </body>
</html>
