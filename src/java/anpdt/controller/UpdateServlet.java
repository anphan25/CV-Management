/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.controller;

import anpdt.CV.CVDAO;
import anpdt.CV.CVDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        CVDTO cvDTO = (CVDTO) session.getAttribute("USER_CV");
        String username = cvDTO.getUsername();
        String fullname = request.getParameter("txtFullname");
        String job = request.getParameter("txtJob");
        String gender = request.getParameter("txtGender");
        String birthday = request.getParameter("txtBirthday");
        String phoneNumber = request.getParameter("txtPhone");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String experience = request.getParameter("txtExperience");
        String education = request.getParameter("txtEducation");
        String certificate = request.getParameter("txtCertificate");
 
        String url = "";
        try {
            CVDTO dto = new CVDTO(username, birthday, fullname, gender, phoneNumber, email, address, job, experience, education, certificate);
            CVDAO dao = new CVDAO();
            boolean result = dao.updateInfo(dto);
            if(result){
                dao.uploadInfor(username);
                CVDTO userInfor = dao.getUserCV();
                session.setAttribute("USER_CV", userInfor);
                url = "CVPage";
            }
        }catch(SQLException ex){
            log("UpdateServlet _ SQL"+ ex.getMessage());
        }catch(NamingException ex){
            log("UpdateServlet _ Naming"+ ex.getMessage());
        }
        finally{
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
