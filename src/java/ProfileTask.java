/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author ankit
 */
public class ProfileTask extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession session = request.getSession();
            ArrayList nm = (ArrayList)session.getAttribute("userData");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Profiletask</title>"); 
            
        out.println("<link rel='stylesheet' type='text/css' href='profileTask.css'>");
            
            out.println("</head>");
            out.println("<body>");
            
            out.print("<div class='user-data-container'>");
            out.println("<h2>User Data</h2>");

out.println("<table>");
out.print("<tr>");
    out.println("<th>Name</th>");    
    out.println("<th>Father Name</th>");
    out.println("<th>Phone Number</th>");
    out.println("<th>Email</th>");  
out.println("</tr>");

out.println("<tr>");  
    out.println("<td> "+ nm.get(0)+"</td>");    
    out.println("<td>"+nm.get(1)+"</td>");
    out.println("<td>"+nm.get(2)+"</td>");
    out.println("<td>"+nm.get(3)+"</td>");
out.print("</tr>");
            

out.println("<tr>");
    out.println("<td colspan='4'>");
    out.println("<a href='UpdateProfileTask'>"+"Update Profile"+"</a>");
    out.println("</td>");
out.println("</tr>");

    out.println("</table>");
    out.println("</div>");

            
            out.println("</body>");
            out.println("</html>");
            
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
