/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Mauricio
 */
@WebServlet(urlPatterns = {"/FORMU"})
public class FORMU extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FORMU</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FORMU at " + request.getContextPath() + "</h1>");
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
       
        
           
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *s
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs 
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter salida=response.getWriter();
        
        salida.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"main2.css\"></head><body>");
        
        salida.println("Nombre Introducido: " + request.getParameter("nombre"));
        
        salida.print("<br><br>");
        
        salida.println("Apellido Introducido: " + request.getParameter("apellido"));
        
        salida.print("<br><br>");
        
        salida.println("Fecha de Nacimiento Introducida: " + request.getParameter("fecha"));
        
        salida.print("<br><br>");
        
        salida.println("Correo Introducido: " + request.getParameter("correo"));
        
        salida.print("<br><br>");

        salida.println("Password Introducido: " + request.getParameter("cont"));
        
        salida.print("</body></html>");
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
