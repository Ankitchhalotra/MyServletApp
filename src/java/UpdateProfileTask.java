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
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author ankit
 */
public class UpdateProfileTask extends HttpServlet {

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
            ArrayList al = (ArrayList)session.getAttribute("userData");
            
            String name = (String)al.get(0);
            String fname = (String)al.get(1);
            String contact = (String)al.get(2);
            String email = (String) al.get(3);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProfileTask</title>");
        out.println("<link rel='stylesheet' type='text/css' href='profileTask.css'>");
            
            out.println("</head>");
            out.println("<body>");
            
            out.print("<div class='user-data-container'>");
out.println("<h2>Update User Data</h2>");
out.print("<form action='UpdateProfileTask' method='post'>");
out.println("<table>");
out.println("<tr>");
    out.println("<th>Name</th>");    
    out.println("<th>Father Name</th>");
    out.println("<th>Phone Number</th>");
    //out.println("<th>Email</th>");
out.println("</tr>");

out.println("<tr>");  
    out.println("<td><input type='text' name='name1' value='"+name+"'></td>");
    out.println("<td><input type='text' name='fname1' value='"+fname+"'></td>");
    out.println("<td><input type='text' name='contact1' value='"+contact+"'></td>");   
 out.println("</tr>");

out.println("<tr>");
    out.println("<td colspan='3'>");
    out.println("<input type='submit' value='UPDATE' name='updateBtn'>");
    out.println("</td>");
out.println("</tr>");

    out.println("</table>");
    out.println("</form>");
    out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
            
            String setName = request.getParameter("name1");
            String setFname = request.getParameter("fname1");
            String setContact = request.getParameter("contact1");
            String btn = request.getParameter("updateBtn");
            
            if(btn.equals("UPDATE")){
            try {
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
                String sql = "update student set name=?,fname=?,contact=? where email=?";
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, setName);
                ps.setString(2, setFname);
                ps.setString(3, setContact);
                ps.setString(4, email);
                
                int i = ps.executeUpdate();

                if(i > 0) {
                    al.set(0, setName);
                    al.set(1, setFname);
                    al.set(2, setContact);
                    //out.print("Data Update Sucessfull");
                    response.sendRedirect("HomeTask");
                } 
                
                con.close();
            } catch (Exception e) {}
            } else {
            response.sendRedirect("UpdateProfileTask");
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
