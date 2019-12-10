<%-- 
    Document   : newQuiz
    Created on : Dec 8, 2019, 4:33:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new Quiz</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <form class="custom-form mt-5" action="makeQuiz" method="POST">   
                <h2 class="mb-3">Create new Quiz</h2>
                <div class="form-group">
                    <label for="titleInput">Title</label>
                    <input type="text" class="form-control" id="titleInput" name="txtTitle" placeholder="Enter quiz title" required/>
                </div>
                <div class="form-group">
                    <label for="titleInput">Taken Time <span class="text-danger font-weight-bold">(In minute)</span></label>
                    <input type="number" class="form-control" id="titleInput" name="txtTakenTime" placeholder="Taken time" required/>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
    </body>
</html>
