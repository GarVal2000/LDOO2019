<%-- 
    Document   : TAREA3
    Created on : 5/03/2019, 01:15:36 PM
    Author     : Luis Mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO</h1>
        
       Nombre Ingresado: <%=request.getParameter("nombre")%>
       <br><br>
      
       Apellido Ingresado:<%=request.getParameter("apellido")%>
       <br><br>
       
       Fecha de Nacimiento: <%=request.getParameter("fecha")%>
       <br><br>
       
       Correo Ingresado: <%=request.getParameter("correo")%>
       <br><br>
       
       Contraseña Ingrasada: <%=request.getParameter("cont")%>
       <br><br>
    </body>
</html>
