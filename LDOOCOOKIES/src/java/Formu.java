/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Luis Mauricio
 */
@WebServlet(urlPatterns = {"/Formu"})
public class Formu extends HttpServlet {

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
        PrintWriter salida=response.getWriter();
        
        String control = request.getParameter("control");

        if ("1".equals(control)) {
    
            String nom = request.getParameter("nombre");
            String apel = request.getParameter("apellido");
            String fechaC = request.getParameter("fecha");
            String corre = request.getParameter("correo");
            String contra = request.getParameter("cont");
            Registrar r = new Registrar();
            r.setNombre(nom);
            r.setApellido(apel);
            r.setFecha(fechaC);
            r.setCorreo(corre);
            r.setCont(contra);

            HttpSession sessionL = request.getSession();
            sessionL.setAttribute("id", corre);
            sessionL.setAttribute("con", contra);
            sessionL.setAttribute("nom", nom);

            salida.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"main3.css\"></head><body>");
        
            salida.println("Nombre Introducido: " + request.getParameter("nombre"));
        
            salida.println("<br><br>");
        
            salida.println("Apellido Introducido: " + request.getParameter("apellido"));
        
            salida.println("<br><br>");
            
            salida.println("Fecha de Nacimiento Introducida: " + request.getParameter("fecha"));
            
            salida.println("<br><br>");
            
            salida.println("Correo Introducido: " + request.getParameter("correo"));
            
            salida.println("<br><br>");

            salida.println("Password Introducido: " + request.getParameter("cont"));
            
            salida.println("<br><br>");
            
            salida.println("<a href='index2.html'>Iniciar sesión</a>");
            
            salida.println("</body></html>");
        }else {
            HttpSession miSession = request.getSession();
            String cCorreo = request.getParameter("correo");
            String cContra = request.getParameter("cont");
            String pCorreo = (String)miSession.getAttribute("id");
            String pContra = (String)miSession.getAttribute("con");
            Comprobar c = new Comprobar();
            c.setCCorreo(cCorreo);
            c.setPCorreo(pCorreo);
            c.setCContra(cContra);
            c.setPContra(pContra);
            c.Comprobar();
            if (c.getCom()){
                Cookie micookie = new Cookie("Loggeo","Exitoso");
                micookie.setMaxAge(60*60*24);
                salida.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"main3.css\"></head><body>");
                salida.println("<br><br>");
                salida.println("Bienvenido " + miSession.getAttribute("nom"));
                salida.println("<br>Cookie: <br>" );
                salida.println(micookie.getName() + " " + micookie.getValue());
                salida.println("<br><a href='index.html'>Cerrar Session</a>");
                salida.println("</body></html>");
            } else { 
                  
            Registrar r1 = new Registrar();
            request.getSession().setAttribute("usuario1", r1);
                request.getRequestDispatcher("error.jsp").forward(request, response); 
                
            }
        
    }
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
