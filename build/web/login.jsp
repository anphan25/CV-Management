<%-- 
    Document   : login
    Created on : Aug 4, 2021, 7:17:08 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <title>Login Page</title>
    </head>
    <body>
            <div class="container">
            <form action="login" method="POST">
                <h1>LOGIN</h1>
                <input class="input-field" type="text" name="txtUsername" value="" placeholder="Username"/><br/>
                <input class="input-field" type="password" name="txtPassword" value="" placeholder="Password" /><br/>
                <c:set var="error" value="${sessionScope.LOGIN_ERROR}"/>
                <c:if test="${not empty error.wrongUsernamePassword}">
                    <font color="red">
                        ${error.wrongUsernamePassword}
                    </font>
                </c:if>
                <div class="remember-password">
                    <input type="checkbox" name="remeberPassword" value="ON" /> Remember Password<br/>
                </div>
                <input class="login-button" type="submit" value="Login" />
                <div class="create-link">
                <a href="createAccountPage">Create an Account</a>
                </div>
            </form>
           </div>
    </body>
</html>
