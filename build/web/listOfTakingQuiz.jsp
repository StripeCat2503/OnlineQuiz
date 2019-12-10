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
            <%
                QuizDAO dao = new QuizDAO();
                List<Quiz> listOfQuiz = dao.getAllQuiz();
                if (listOfQuiz != null && !listOfQuiz.isEmpty()) {
            %>
            <table class="table mt-5">
                <thead>
                    <tr>                        
                        <th scope="col">Title</th>
                        <th scope="col">Questions</th>                       
                        <th scope="col">Taken Time</th>                                                         
                        <th scope="col">Actions</th>                 
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Quiz quiz : listOfQuiz) {
                            int numOfQuestions = dao.getNumOfQuestions(quiz.getId());
                    %>
                    <tr>                
                        <td><%= quiz.getTitle()%></td>                       
                        <td><%= numOfQuestions%></td>
                        <td class="font-weight-bold text-warning"><%= quiz.getTaken_time()%> minutes</td>                       
                        <td>
                            <a href="takeQuiz.jsp?id=<%= quiz.getId()%>" class="mr-3 btn btn-success">Start Quiz</a>                                             
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
