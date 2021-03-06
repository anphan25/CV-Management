<%-- Document : createCV Created on : Aug 18, 2021, 11:06:23 AM Author : ASUS
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/createStyle.css" />
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
        <h1>CREATE YOUR CV</h1>
        <form action="create" method="POST" id="create-form">
          <div class="avt-div">
            <input id="upload-input" type="file" style="display: none" />
            <input
              type="hidden"
              id="hidden-avt-input"
              name="image"
              value="https://firebasestorage.googleapis.com/v0/b/test-4fcbb.appspot.com/o/CV-manager%2Fdefault-avatar.png?alt=media&token=dbe423e5-cdcb-4f52-8f65-59411150b79e"
            />
            <button id="upload-btn">Upload Image</button>
            <img
              class="avt-display"
              src="https://firebasestorage.googleapis.com/v0/b/test-4fcbb.appspot.com/o/CV-manager%2Fdefault-avatar.png?alt=media&token=dbe423e5-cdcb-4f52-8f65-59411150b79e"
              alt=""
              style="width: 300px; height: 370px"
            />
          </div>
          <div class="up-info">
            <p>Fullname</p>
            <input
              type="text"
              name="txtFullname"
              value=""
              required="required"
            />
            <p>Job</p>
            <input type="text" name="txtJob" value="" required="required" />
            <p>Gender</p>
            <input type="text" name="txtGender" value="" required="required" />
            <p>Birthday</p>
            <input
              type="text"
              name="txtBirthday"
              value=""
              required="required"
            />
            <p>Phone Number</p>
            <input type="text" name="txtPhone" value="" required="required" />
            <p>Email</p>
            <input type="text" name="txtEmail" value="" required="required" />
            <p>Address</p>
            <input type="text" name="txtAddress" value="" required="required" />
          </div>
          <div class="down-info">
            <p>Experience</p>
            <textarea
              name="txtExperience"
              id=""
              cols="30"
              rows="10"
              required="required"
            ></textarea>
            <p>Education</p>
            <textarea
              name="txtEducation"
              id=""
              cols="30"
              rows="10"
              required="required"
            ></textarea>
            <p>Certificate</p>
            <textarea
              name="txtCertificate"
              id=""
              cols="30"
              rows="10"
              required="required"
            ></textarea>
          </div>

          <div class="button-decision">
            <input
              id="update-button btn"
              type="submit"
              name="btAction"
              value="Create"
            />
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
    <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-firestore.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-storage.js"></script>
    <script src="./js/createCV.js"></script>
  </body>
</html>
