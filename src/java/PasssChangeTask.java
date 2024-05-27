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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author ankit
 */
public class PasssChangeTask extends HttpServlet {

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
            String email = (String)session.getAttribute("email");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PasssChangeTask</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='profileTask.css'>");

            out.println("</head>");
            out.println("<body>");
            
            out.print("<div class='user-data-container'>");
out.println("<h2>Change Password</h2>");
out.print("<form action='PasssChangeTask'>");
out.println("<table>");
out.println("<tr>");
    out.println("<th>Old password</th>");    
    out.println("<th>New Password</th>");
    out.println("<th>Confirm Password</th>");
out.println("</tr>");

out.println("<tr>");  
    out.println("<td><input type='password' name='opass'></td>");
    out.println("<td><input type='password' name='npass'></td>");
    out.println("<td><input type='password' name='cpass'></td>");   
 out.println("</tr>");

out.println("<tr>");
    out.println("<td colspan='3'>");
    out.println("<input type='submit' value='CHANGE'>");
    out.println("</td>");
out.println("</tr>");

    out.println("</table>");
    out.println("</form>");
    out.println("</div>");
            


            out.println("</body>");
            out.println("</html>");
            
            String opass = request.getParameter("opass");
            String npass = request.getParameter("npass");
            String cpass = request.getParameter("cpass");
            
            if(npass.equals(cpass)){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
                String sql = "update student set password=? where password=? and email=?";
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,npass);
                ps.setString(2, opass);
                ps.setString(3, email);
                
                int i = ps.executeUpdate();
                if (i>0){
                response.sendRedirect("HomeTask");
                }                
            } catch(Exception e) {}
            } else {
            out.print("Enter Write password");
            }
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
