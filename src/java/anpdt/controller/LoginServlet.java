/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.controller;

import anpdt.CV.CVDAO;
import anpdt.CV.CVDTO;
import anpdt.errors.Errors;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import anpdt.registration.RegistrationDAO;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class LoginServlet extends HttpServlet {

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
        String rememberBox = request.getParameter("remeberPassword");
        HttpSession session = request.getSession(true);
        Errors errors = new Errors();
        String url = "";
        try {
            RegistrationDAO dao = new RegistrationDAO();
            boolean result = dao.checkLogin(username, password);
            if (result) {
                CVDAO cvDAO = new CVDAO();
                boolean isAdmin = cvDAO.isAdmin(username);
                if (isAdmin == true) {
                    cvDAO.loadAccounts();
                    ArrayList<CVDTO> accounts = cvDAO.getAccoutns();
                    session.setAttribute("ACCOUNTS_LIST", accounts);
                    url = "adminPage";
                } else {
                    cvDAO.uploadInfor(username);
                    CVDTO cvDTO = cvDAO.getUserCV();
                    session.setAttribute("USER_CV", cvDTO);
                    url = "CVPage";
                }

                if (rememberBox != null) {
                    session.setAttribute("USERNAME", username);
                    session.setAttribute("REMEMBER_CHECK", rememberBox);
                    Cookie cookie = new Cookie(username, password);
                    cookie.setMaxAge(60 * 60);
                    response.addCookie(cookie);
                }
            } else {
                errors.setWrongUsernamePassword("Username or Password is not correct");
                session.setAttribute("LOGIN_ERROR", errors);
                url = "loginPage";
            }
        } catch (SQLException ex) {
            log("LoginServlet _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginServlet _ Naming " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
