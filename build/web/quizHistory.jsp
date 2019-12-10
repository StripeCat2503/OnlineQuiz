<%-- 
    Document   : quizHistory
    Created on : Dec 10, 2019, 1:05:49 PM
    Author     : Admin
--%>

<%@page import="quiz.Quiz"%>
<%@page import="history.QuizHistory"%>
<%@page import="java.util.List"%>
<%@page import="user.User"%>
<%@page import="quiz.QuizDAO"%>
<%@page import="history.QuizHistoryDAO"%>
<%@page import="history.QuizHistoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz History</title>
    </head>
    <body>
        <%
            int count = 1;
            QuizHistoryDAO dao = new QuizHistoryDAO();
            QuizDAO quizDAO = new QuizDAO();
            User user = (User) session.getAttribute("user");
            String username = user.getUsername();
            List<QuizHistory> listOfHistories = dao.getAllQuizHistories(username);
            if (listOfHistories != null && !listOfHistories.isEmpty()) {
        %>
        <a href="clearHistory" class="btn btn-danger m-3">Clear All Histories</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Right Answer(s)</th>
                    <th scope="col">Total Score</th>
                    <th scope="col">Taken Date</th>
                    <th scope="col">Quiz</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (QuizHistory quizHistory : listOfHistories) {
                        Quiz quiz = quizDAO.getQuiz(quizHistory.getQuiz_id());
                        int numOfQuestions = quizDAO.getNumOfQuestions(quiz.getId());
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><span class="text-danger font-weight-bold"><%= quizHistory.getRightAnswers()%></span>/<%= numOfQuestions%></td>
                    <td class="text-danger font-weight-bold"><%= quizHistory.getScore()%></td>
                    <td><%= quizHistory.getTakenDate().toString()%></td>
                    <td class="font-weight-bold"><%= quiz.getTitle()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
        } else {
        %>
        <div class="alert alert-danger" role="alert">
            Quiz History is empty now!
        </div>
        <%
            }
        %>

    </body>
</html>
