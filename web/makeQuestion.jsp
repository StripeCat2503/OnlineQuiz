<%-- 
    Document   : makeQuiz
    Created on : Dec 7, 2019, 12:38:57 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Question</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <form class="custom-form mt-5" action="addQuestion" method="POST">   
                <h2 class="mb-3">Create new question</h2>
                <div class="form-group">
                    <label for="questionInput">Question</label>
                    <textarea class="form-control" id="questionInput" rows="3" name="txtQuestion" required></textarea>
                </div>
                <div class="form-group">
                    <label for="option1">Option 1</label>
                    <textarea class="form-control" id="option1" rows="1" name="txtOption1" required></textarea>
                </div>
                <div class="form-group">
                    <label for="option2">Option 2</label>
                    <textarea class="form-control" id="option2" rows="1" name="txtOption2" required></textarea>
                </div>
                <div class="form-group">
                    <label for="option3">Option 3</label>
                    <textarea class="form-control" id="option3" rows="1" name="txtOption3" required></textarea>
                </div>
                <div class="form-group">
                    <label for="option4">Option 4</label>
                    <textarea class="form-control" id="option4" rows="1" name="txtOption4" required></textarea>
                </div>

                <div class="form-group">
                    <label>Answer</label><br>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input class="custom-control-input" type="radio" name="radioAnswer" id="inlineRadio1" value="1">
                        <label class="custom-control-label" for="inlineRadio1">Option 1</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input class="custom-control-input" type="radio" name="radioAnswer" id="inlineRadio2" value="2">
                        <label class="custom-control-label" for="inlineRadio2">Option 2</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input class="custom-control-input" type="radio" name="radioAnswer" id="inlineRadio3" value="3">
                        <label class="custom-control-label" for="inlineRadio3">Option 3</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input class="custom-control-input" type="radio" name="radioAnswer" id="inlineRadio4" value="4">
                        <label class="custom-control-label" for="inlineRadio4">Option 4</label>
                    </div>
                    
                </div>

                <input type="hidden" name="quizID" value="${quizID}" />

                <button type="submit" class="btn btn-block btn-danger mb-3">Save</button>
            </form>
        </div>
    </body>
</html>
