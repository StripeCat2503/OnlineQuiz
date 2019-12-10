<%-- 
    Document   : login
    Created on : Dec 7, 2019, 12:27:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <form class="custom-form" action="newAccount" method="POST">
                <h2 class="mt-5 mb-3">Create new account</h2>
                <div class="form-group">
                    <label for="usernameInput">Username</label>
                    <input name="txtUsername" type="text" class="form-control" id="usernameInput" placeholder="Username" required>             
                </div>
                <div class="form-group">
                    <label for="passwordInput">Password</label>
                    <input name="txtPassword" type="password" class="form-control" id="passwordInput" placeholder="Password" required>             
                </div>
                <div class="form-group">
                    <label for="roleSelect">User Type</label>
                    <select class="form-control" id="roleSelect" name="selectRole">
                        <option>Teacher</option>
                        <option>Normal User</option>                        
                    </select>
                </div>
                <div class="form-group">
                    <label for="emailInput">Password</label>
                    <input name="txtEmail" type="email" class="form-control" id="emailInput" placeholder="Email" required>             
                </div>
                <button type="submit" class="btn btn-primary">Register</button>                
            </form>
        </div>
    </body>
</html>
