<%-- 
    Document   : aceptable
    Created on : 15/03/2019, 08:27:59 PM
    Author     : Luis Mauricio
--%>
<%@page import="Modelo.Usuario"%>
<%
   Usuario u1 = (Usuario) request.getSession().getAttribute("usuario1");
%>    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos Correctamente Escritos y Resividos</h1>
        <p>Nombre:<%=u1.getNombre()%> </p>
        <p>Apellido:<%=u1.getApellido()%> </p>
         <p>Edad:<%=u1.getEdad()%> </p>
    </body>
</html>
