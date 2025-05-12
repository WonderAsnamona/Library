<%-- 
    Document   : usernameExist
    Created on : 12 May 2025, 7:32:54 PM
    Author     : Wonder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getAttribute("username").toString();
        %>
        <h1>Library</h1>
        <p>
            Sorry the username <b><%=username%></b> exists choose another name. Click <a href="signUp.html">here</a> to try again or go to <a href="index.html">start</a> page.
        </p>
    </body>
</html>
