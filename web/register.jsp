<%-- 
    Document   : register
    Created on : Aug 5, 2021, 2:21:34 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/registerStyle.css">
        <title>Register</title>
    </head>
    <body>
        <div class="container">
            <form action="createAccount" method="POST">
                <h1>CREATE YOUR ACCOUNT</h1>
                <c:set var="errors" value="${requestScope.REGISTER_ERROR}"/>
                <input class="input-field" type="text" name="txtUsername" value="${param.txtUsername}" placeholder="Username"/><br/>
                <c:if test="${not empty errors.usernameLengthErr}">
                    <font color="red">
                        <p>${errors.usernameLengthErr}</p>
                    </font>
                </c:if>
                <c:if test="${not empty errors.usernameIsExisted}">
                    <font color="red">
                        <p>${errors.usernameIsExisted}</p>
                    </font>
                </c:if>
                <input class="input-field" type="password" name="txtPassword" value="${param.txtPassword}" placeholder="Password" /><br/>
                <c:if test="${not empty errors.passwordLengthErr}">
                    <font color="red">
                        <p>${errors.passwordLengthErr}</p>
                    </font>
                </c:if>
                <input class="input-field" type="password" name="txtConfirmPassword" value="${param.txtConfirmPassword}" placeholder="Confirm Password" /><br/>
                <c:if test="${not empty errors.confirmNotMatched}">
                    <font color="red">
                        <p>${errors.confirmNotMatched}</p>
                    </font>
                </c:if>
                <input class="input-field" type="text" name="txtFullname" value="${param.txtFullname}" placeholder="Full Name" /><br/>
                <c:if test="${not empty errors.fullnameLengthErr}">
                    <font color="red">
                        <p>${errors.fullnameLengthErr}</p>
                    </font>
                </c:if>
                <div class="aggree-checkbox">
                    <input type="checkbox" name="acceptBox" value="ON" /> I accept <span class="text-policy">Terms of Use</span> & <span class="text-policy">Privacy Policy</span><br/>
                </div>
                    <c:if test="${not empty errors.notCheckedAcceptBox}">
                    <font color="red">
                        <p>${errors.notCheckedAcceptBox}</p>
                    </font>
                </c:if>
                <input class="register-button" type="submit" value="Register" />
            </form>
        </div>
    </body>
</html>
