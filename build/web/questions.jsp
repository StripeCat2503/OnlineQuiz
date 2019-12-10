<%-- 
    Document   : questions
    Created on : Dec 8, 2019, 9:11:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>

        <div class="container">
            <h2 class="mt-5 mb-3">Questions:</h2>
            <c:if test="${not empty questions}">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Content</th>
                            <th scope="col">Options</th>                            
                            <th scope="col">Answer</th>    
                            <th scope="col">Actions</th>                               
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="question" items="${questions}">
                            <tr>                               
                                <td>${question.content}</td>
                                <td>
                                    <select class="form-control" disabled>
                                        <option value="1" <c:if test="${question.answer == 1}">selected</c:if>>${question.op1}</option>
                                        <option value="2" <c:if test="${question.answer == 2}">selected</c:if>>${question.op2}</option>
                                        <option value="3" <c:if test="${question.answer == 3}">selected</c:if>>${question.op3}</option>
                                        <option value="4" <c:if test="${question.answer == 4}">selected</c:if>>${question.op4}</option>
                                        </select>
                                    </td>                              
                                    <td class="text-danger font-weight-bold">${question.answer}</td>                               
                                <td>
                                    <a href="editQuestion?id=${question.id}" class="mr-3 btn btn-primary">Edit</a>
                                    <a href="deleteQuestion?id=${question.id}&quizId=${question.quiz_id}" class="btn btn-danger">Delete</a>
                                </td>                               
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
                <c:forEach var="question" items="${questions}">

                </c:forEach>
            </c:if>
            <c:if test="${empty questions}">
                <div class="alert alert-danger" role="alert">
                    There's no available question!
                </div>
            </c:if>

        </div>
    </body>
</html>
