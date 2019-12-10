<%-- 
    Document   : makeQuiz
    Created on : Dec 8, 2019, 3:58:26 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="quiz.Quiz"%>
<%@page import="quiz.Quiz"%>
<%@page import="quiz.QuizDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>

        <div class="container">
            <a href="newQuiz.jsp" class="btn btn-success mt-5 mb-3">Create new Quiz</a>
            <%
                int count = 1;
                QuizDAO dao = new QuizDAO();
                List<Quiz> listOfQuiz = dao.getAllQuiz();
                if (listOfQuiz != null && !listOfQuiz.isEmpty()) {
            %>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Questions</th>                       
                        <th scope="col">Taken Time</th>                       
                        <th scope="col">Created Date</th>                 
                        <th scope="col">Actions</th>                 
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Quiz quiz : listOfQuiz) {
                            int numOfQuestions = dao.getNumOfQuestions(quiz.getId());
                    %>
                    <tr>                
                        <td><%= count++ %></td>
                        <td>
                            <a href="questions?id=<%= quiz.getId()%>"><%= quiz.getTitle()%></a>
                        </td>
                        <td><%= numOfQuestions%></td>
                        <td class="font-weight-bold text-warning"><%= quiz.getTaken_time()%> minutes</td>
                        <td><%= quiz.getCreated_date().toString()%></td>
                        <td>
                            <a class="btn btn-primary" href="addQuestion?id=<%= quiz.getId()%>" class="mr-3">Add question</a>
                            <a class="btn btn-success" href="editQuiz?id=<%= quiz.getId()%>" class="mr-3">Edit</a>
                            <a class="btn btn-danger" href="deleteQuiz?id=<%= quiz.getId()%>">Delete</a>                           
                        </td>
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
                There's no any available Quiz!
            </div>           
            <%
                }
            %>

        </div>
    </body>
</html>
