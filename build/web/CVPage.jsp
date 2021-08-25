<%-- 
    Document   : CVPage
    Created on : Aug 4, 2021, 10:58:11 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/CVPageStyle.css" />
        <script src="https://kit.fontawesome.com/1b1fb57155.js" crossorigin="anonymous"></script>
        <title>CV Page</title>
    </head>
    <body>
        <c:set var="userCV" value="${sessionScope.USER_CV}"/>
        <c:if test="${not empty userCV}">
            <header>
                <p id="text-logo">
                    <span id="CV-text">CV</span> <span id="Project-text">Project </span>
                </p>
                <div id="function-button">
                    <form action="updatePage">
                        <input id="update-button" type="submit" value="Update" />
                    </form>
                    <form action="logout">
                        <input id="logout-button" type="submit" value="Log Out" />
                    </form>
                </div>
            </header>
            <p class="title">YOUR CV</p>
            <div class="container">
                <div class="header">
                    <div class="full-name">${userCV.fullname}</div>
                    <div class="Job">${userCV.job}</div>
                </div>
                <div class="body">
                    <div class="body-left">
                        <div class="img">
                            <img src="image/messi.jpg" alt="" />
                        </div>
                        <div class="left-infor">
                            <div class="left-infor-div">
                                <p class="left-infor-text">Birthday</p>
                                ${userCV.birthday}
                                <p class="left-infor-text">Gender</p>
                                ${userCV.gender}
                                <p class="left-infor-text">Phone Number</p>
                                ${userCV.phoneNumber}
                                <p class="left-infor-text">Email</p>
                                ${userCV.email}
                                <p class="left-infor-text">Address</p>
                                ${userCV.address}
                            </div>
                        </div>
                    </div>
                    <div class="body-right">
                        <div class="right-div-content">
                            <h1>Experience</h1>
                            <p>${userCV.expierence}</p>
                        </div>
                        <div class="right-div-content">
                            <h1>Education</h1>
                            <p>${userCV.education}</p>
                        </div>
                        <div class="right-div-content">
                            <h1>Certification</h1>
                            <p>${userCV.certificate}</p>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <a href="https://www.facebook.com/AnBM.02/"><i class="fab fa-facebook"></i></a>
                <a href="https://github.com/anphan25"><i class="fab fa-github"></i></a>
            </footer>           
        </c:if>
        <c:if test="${empty userCV}">
            <header>
                <p id="text-logo">
                    <span id="CV-text">CV</span> <span id="Project-text">Project </span>
                </p>
                <div id="function-button">
                    <form action="logout">
                        <input id="logout-button" type="submit" value="Log Out" />
                    </form>
                </div>
            </header>
            <div class="container-sub">
                <h1>YOU DON'T HAVE CV</h1>
                <form action="createPage">
                    <input id="logout-button btn" type="submit" value="Create One" />
                </form>
            </div>
            <footer>
                <a href="https://www.facebook.com/AnBM.02/"><i class="fab fa-facebook"></i></a>
                <a href="https://github.com/anphan25"><i class="fab fa-github"></i></a>
            </footer>
        </c:if>

    </body>
</html>
