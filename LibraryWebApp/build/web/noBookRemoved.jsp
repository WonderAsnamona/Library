<%-- 
    Document   : noBookRemoved
    Created on : 12 May 2025, 5:45:39 PM
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
            String title = request.getAttribute("title").toString();
            
        %>
        <h1>Library</h1>
        <p>
            Sorry there's no book removed since there's no book with the title <b><%=title%></b>. Click <a href="removeBookByTitle">here</a> to search again or or go to <a href="bookKeeperMenu.html">menu</a>.
        </p>
    </body>
</html>
