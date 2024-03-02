<%-- 
    Document   : login
    Created on : Feb 23, 2024, 8:00:26 AM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <div>${requestScope.ms}</div>
        <form action="login" method="post">
            Username <input type="text" name="username"></br>
            Password <input type="password" name="password"></br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
