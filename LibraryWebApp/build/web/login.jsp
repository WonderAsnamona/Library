<%-- 
    Document   : login.jsp
    Created on : 12 May 2025, 10:14:09 PM
    Author     : Sihle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        <h1>Hello There</h1>
        <form method="POST" action="j_security_check">
    <label>Username: <input type="text" name="j_username" /></label><br/>
    <label>Password: <input type="password" name="j_password" /></label><br/>
    <input type="submit" value="Login" />
</form>
    </body>
</html>
