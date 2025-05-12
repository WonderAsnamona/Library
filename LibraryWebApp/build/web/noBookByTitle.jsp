<%-- 
    Document   : noBookByTitle
    Created on : 11 May 2025, 9:20:31 PM
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
            Sorry there's no book with title <b><%=title%></b>. Click <a href="searchBook.html">here</a> to search again or go to <a href="clientMenuPage.html">menu</a>. 
        </p>
    </body>
</html>
