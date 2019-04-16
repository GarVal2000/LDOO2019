<%-- 
    Document   : index
    Created on : 15/03/2019, 07:18:05 PM
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
        <h1>Formulario</h1>
        <form action="procesar.do" method="post">
                    <label>Nombre: </label> 
                     <br>
                     <input type="text" name="nombre">
                     <br><br>


                     <label>Apellido: </label>
                     <br>
                     <input type="text" name="apellido">
                     <br><br>

                    <label>Edad: </label>
                    <br>
                    <input type="text" name="edad">
                    <br><br>
                    
                    <label>Correo: </label>
                    <br>
                    <input type="email" name="correo">
                    <br><br>
                    
                    <label>Contraseña: </label>
                    <br>
                    <input type="password" name="contraeña">
                    <br><br>

                    <input type="submit" value="Enviar Datos">
        </form>
    </body>
</html>
