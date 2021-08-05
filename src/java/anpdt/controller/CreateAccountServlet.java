/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.controller;

import anpdt.errors.Errors;
import anpdt.registration.RegistrationDAO;
import anpdt.registration.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirmPassword");
        String fullname = request.getParameter("txtFullname");
        String acceptBox = request.getParameter("acceptBox");
        ServletContext context = request.getServletContext();
        Map<String,String> roadmap = (Map<String,String>) context.getAttribute("ROADMAP");
        Errors errors = new Errors();
        boolean foundErr = false;
        String url = roadmap.get("createAccountPage");
        try {
            if(username.trim().length() < 6 || username.trim().length() > 12){
                foundErr = true;
                errors.setUsernameLengthErr("Username is required 6 to 12 chars");
            }
            if(password.trim().length() < 6 || password.trim().length() > 20){
                foundErr = true;
                errors.setPasswordLengthErr("Password is required 6 to 20 chars");
            }else if(!confirm.trim().equals(password.trim())){
                foundErr = true;
                errors.setConfirmNotMatched("Confirm must be matched with password");
            }
            if(fullname.trim().length() < 1 || fullname.trim().length() > 50){
                foundErr = true;
                errors.setFullnameLengthErr("Full name is required 1 to 50 chars");
            }
            if(acceptBox == null){
                foundErr = true;
                errors.setNotCheckedAcceptBox("Please check this box");
            }
            if(foundErr){
                request.setAttribute("REGISTER_ERROR", errors);
            }else{
                RegistrationDAO dao = new RegistrationDAO();
                RegistrationDTO dto = new RegistrationDTO(username, password, fullname, "User");
                dao.createAccount(dto);
                url = roadmap.get("loginPage");
            }
            
        }catch(SQLException ex){
            String msg = ex.getMessage();
            log("CreateAccountServlet _ SQL "+ ex.getMessage());
            if(msg.contains("duplicate")){
                errors.setUsernameIsExisted(username + " is existed !!!");
                request.setAttribute("REGISTER_ERROR", errors);
            }
        }catch(NamingException ex){
            log("CreateAccountServlet _ Naming"+ ex.getMessage());
        }
        finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
