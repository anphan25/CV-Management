<%-- 
    Document   : adminPage
    Created on : Aug 15, 2021, 3:45:47 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/adminPageStyle.css" />
        <script
            src="https://kit.fontawesome.com/1b1fb57155.js"
            crossorigin="anonymous"
        ></script>
        <title>Admin Page</title>
    </head>
    <body>
        <header>
            <p id="text-logo">
                <span id="CV-text">CV</span> <span id="Project-text">Project </span>
            </p>
            <div>
                <form action="logout">
                    <button id="logout-button">Log Out</button>
                </form>
            </div>
        </header>

        <section class="body-content">
            <div class="container">
                <h2>List of accounts:</h2>
                <table>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="accounts" value="${sessionScope.ACCOUNTS_LIST}"/>
                        <c:forEach var="dto" items="${accounts}" varStatus="counter">
                        <form action="viewOrDelete">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="usernameView" value="${dto.username}" />
                                </td>
                                <td>
                                    ${dto.fullname}
                                </td>
                                <td>
                                    <input class="view-button btn" name="btAction" type="submit" value="View" />
                                </td>
                                <td>
                                    <input class="view-button btn" name="btAction" type="submit" value="Delete" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

        <footer>
            <a href="https://www.facebook.com/AnBM.02/"
               ><i class="fab fa-facebook"></i
                ></a>
            <a href="https://github.com/anphan25"><i class="fab fa-github"></i></a>
        </footer>
    </body>
</html>
