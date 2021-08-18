<%-- 
    Document   : updatePage
    Created on : Aug 16, 2021, 3:23:33 PM
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
        <link rel="stylesheet" href="css/updatePageStyle.css" />
        <script
            src="https://kit.fontawesome.com/1b1fb57155.js"
            crossorigin="anonymous"
        ></script>
        <title>Update Page</title>
    </head>
    <body>
        <header>
            <p id="text-logo">
                <span id="CV-text">CV</span> <span id="Project-text">Project </span>
            </p>
            <div>
                <form action="logout">
                    <input id="logout-button" type="submit" value="Log Out" />
                </form>
            </div>
        </header>
        <section>
            <div class="container">
                <h1>UPDATE YOUR INFORMATION</h1>
                <form action="updateDecision">
                    <c:set var="userCV" value="${sessionScope.USER_CV}"/>
                    <div class="up-info">
                        <p>Fullname</p>
                        <input type="text" name="txtFullname" value="${userCV.fullname}" required="required"/>
                        <p>Job</p>
                        <input type="text" name="txtJob" value="${userCV.job}" required="required"/>
                        <p>Gender</p>
                        <input type="text" name="txtGender" value="${userCV.gender}" required="required"/>
                        <p>Birthday</p>
                        <input type="text" name="txtBirthday" value="${userCV.birthday}" required="required"/>
                        <p>Phone Number</p>
                        <input type="text" name="txtPhone" value="${userCV.phoneNumber}" required="required"/>
                        <p>Email</p>
                        <input type="text" name="txtEmail" value="${userCV.email}" required="required"/>
                        <p>Address</p>
                        <input type="text" name="txtAddress" value="${userCV.address}" required="required"/>
                    </div>
                    <div class="down-info">
                        <p>Experience</p>
                        <textarea name="txtExperience" id="" cols="30" rows="10" required="required" >${userCV.expierence}</textarea>
                        <p>Education</p>
                        <textarea name="txtEducation" id="" cols="30" rows="10" required="required">${userCV.education}</textarea>
                        <p>Certificate</p>
                        <textarea name="txtCertificate" id="" cols="30" rows="10" required="required">${userCV.certificate}</textarea>     

                    </div>

                    <div class="button-decision">
                        <input id="update-button" type="submit" name="btAction" value="Update" />
                        <input id="cancel-button" type="submit" name="btAction" value="Cancel" />
                    </div>
                </form>
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