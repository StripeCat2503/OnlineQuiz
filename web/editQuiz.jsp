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
        <title>Edit Quiz</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <form class="custom-form mt-5" action="editQuiz" method="POST">   
                <h2 class="mb-3">Edit Quiz</h2>
                <div class="form-group">
                    <label for="titleInput">Title</label>
                    <input type="text" class="form-control" id="titleInput" name="txtTitle" value="${quiz.title}"
                           placeholder="Enter quiz title" required/>
                </div>
                <div class="form-group">
                    <label for="titleInput">Taken Time <span class="text-danger font-weight-bold">(In minute)</span></label>
                    <input type="number" class="form-control" id="titleInput" name="txtTakenTime" value="${quiz.taken_time}" 
                           placeholder="Taken time" required/>
                </div>

                <input type="hidden" name="quizID" value="${quiz.id}">
                <input type="hidden" name="createdDate" value="${quiz.created_date}">
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </body>
</html>
