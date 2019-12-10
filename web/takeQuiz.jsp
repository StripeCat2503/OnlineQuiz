<%-- 
    Document   : takeQuiz
    Created on : Dec 7, 2019, 12:33:22 PM
    Author     : Admin
--%>

<%@page import="quiz.Quiz"%>
<%@page import="quiz.QuizDAO"%>
<%@page import="java.util.List"%>
<%@page import="question.Question"%>
<%@page import="question.Question"%>
<%@page import="question.QuestionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">

            <%
                int count = 1;
                int radioCount = 1;
                String txtQuizID = request.getParameter("id");
                QuizDAO quizDAO = new QuizDAO();
                Quiz quiz = quizDAO.getQuiz(Integer.parseInt(txtQuizID));
                QuestionDAO dao = new QuestionDAO();
                List<Question> listOfQuestions = dao.getAllQuestions(Integer.parseInt(txtQuizID));
                if (listOfQuestions != null && !listOfQuestions.isEmpty()) {
            %>
            <h5 class="m-5" id="timeRemaining">Time Remaining: </h5>
            <form action="submitQuiz" id="form" method="POST" class="border border-secondary m-3 rounded-lg p-5">
                <%
                    for (Question question : listOfQuestions) {
                %>
                <h4 class="mt-5 mb-3"><%= count %>.<%= question.getContent()%></h4>

                <div class="custom-control custom-radio">                   
                    <input type="radio" id="radio<%= radioCount %>" name="radio<%= count %>" class="custom-control-input" 
                           value="1#<%= question.getId() %>">
                    <label class="custom-control-label" for="radio<%= radioCount++ %>"><%= question.getOp1()%></label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="radio<%= radioCount %>" name="radio<%= count %>" class="custom-control-input" 
                           value="2#<%= question.getId() %>">
                    <label class="custom-control-label" for="radio<%= radioCount++ %>"><%= question.getOp2()%></label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="radio<%= radioCount %>" name="radio<%= count %>" class="custom-control-input" 
                           value="3#<%= question.getId() %>">
                    <label class="custom-control-label" for="radio<%= radioCount++ %>"><%= question.getOp3()%></label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="radio<%= radioCount %>" name="radio<%= count %>" class="custom-control-input" 
                           value="4#<%= question.getId() %>">
                    <label class="custom-control-label" for="radio<%= radioCount++ %>"><%= question.getOp4()%></label>
                </div>
                <%
                    count++;
                    }
                %>
                <input type="hidden" name="numOfQuestions" value="<%= count - 1 %>">              
                <input type="hidden" name="quizID" value="<%= quiz.getId() %>">              
                <button type="submit" class="btn btn-primary mt-5 mb-3">Submit</button>
            </form>

            <script>
                var div = document.getElementById('timeRemaining');
                var submitted = document.getElementById('submitted');

                function CountDown(duration, display) {

                    var timer = duration, minutes, seconds;

                    var interVal = setInterval(function () {
                        minutes = parseInt(timer / 60, 10);
                        seconds = parseInt(timer % 60, 10);

                        minutes = minutes < 10 ? "0" + minutes : minutes;
                        seconds = seconds < 10 ? "0" + seconds : seconds;
                        display.innerHTML = "Time Remaining: <b class='text-danger'>" + minutes + "m : " + seconds + "s" + "</b>";
                        if (timer > 0) {
                            --timer;
                        } else {
                            clearInterval(interVal)
                            SubmitFunction();
                        }

                    }, 1000);

                }

                function SubmitFunction() {
                    div.innerHTML = "Time is up!";
                    document.getElementById('form').submit();

                }
                CountDown(<%= quiz.getTaken_time() * 60 %>, div);
            </script>


            <%
                }
            %>




        </div>
    </body>
</html>
