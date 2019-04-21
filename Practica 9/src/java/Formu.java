/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
         Connection con;
         Statement stm; 
        if ("6".equals(control)) {
    
            String nom = request.getParameter("nombre");
            String corre = request.getParameter("correo");
            String cont = request.getParameter("contra");
            String fe = request.getParameter("fecha");
            Registrar r = new Registrar();
            r.setNombre(nom);
            r.setCorreo(corre);
            r.setCont(cont);
            
           
            String inj = "INSERT INTO ROOT.USUARIOS (NOMUSUARIO, CORREO, PASSWORD, FECHANACIMIENTO, TIPOUSUARIO)"; 
            try  { 
             Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/Usuarios","root","root"); 
                stm = con.createStatement();
                stm.executeUpdate(inj+"VALUES ('"+nom+"','"+corre+"', '"+cont+"','"+fe+"','Administardor')");
                
        
            } catch(ClassNotFoundException | SQLException e) {
             request.getRequestDispatcher("Error.html").forward(request, response); 
            }
            
            
            

            salida.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"main3.css\"></head><body>");
        
            salida.println("Nombre Introducido: " + request.getParameter("nombre"));
        
            salida.println("<br><br>");
            
            salida.println("Fecha de Nacimiento Introducida: " + request.getParameter("fecha"));
            
            salida.println("<br><br>");
            
            salida.println("Correo Introducido: " + request.getParameter("correo"));
            
            salida.println("<br><br>");

            salida.println("Password Introducido: " + request.getParameter("contra"));
            
            salida.println("<br><br>");
            
            salida.println("<a href='LoginAdministrador.html'>Iniciar sesión</a>");
            
            salida.println("</body></html>");
        }else {
           
            String cCorreo = request.getParameter("correo");
            String cContra = request.getParameter("contra");
            
            Comprobar c = new Comprobar();
            c.setCCorreo(cCorreo);
            c.setCContra(cContra);
           
           try  { 
               ResultSet rst;
               
             Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/Usuarios","root","root"); 
                stm = con.createStatement();
                rst = stm.executeQuery("select * from ROOT.\"ADMINISTRADOR\"");
                while(rst.next()){
                    String atrcor = rst.getString("CORREO");
                    String atrcon = rst.getString("PASSWORD");
                    if(atrcor.equals(cCorreo)&atrcon.equals(cContra)){
                     c.setPCorreo(atrcor);
                     c.setPContra(atrcon);
                     
                    }
                    
                }
            } catch(ClassNotFoundException | SQLException e) {
             request.getRequestDispatcher("Error.html").forward(request, response); 
            }
            c.Comprobar();
            
            if (c.getCom()){
                Cookie micookie = new Cookie("Loggeo","Exitoso");
                micookie.setMaxAge(60*60*24);
                salida.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"main3.css\"></head><body>");
                salida.println("<br><br>");
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
