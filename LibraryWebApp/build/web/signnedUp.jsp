<%-- 
    Document   : signnedUp
    Created on : 12 May 2025, 7:25:17 PM
    Author     : Wonder
--%>

<%@page import="za.ac.tut.enttes.Address"%>
<%@page import="za.ac.tut.enttes.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Client c = (Client)request.getAttribute("client");
            Address a = c.getAddress();
        %>
        <h1>Library</h1>
        <p>
            You have successfully signed up yout details are as follows
        </p>
        <table>
            <tr>
                <td>Name:</td>
                <td><%=c.getName()%></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><%=c.getUsername()%></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><%=a.getCity()%></td>
            </tr>
            <tr>
                <td>House Number:</td>
                <td><%=a.getHouseNumber()%></td>
            </tr>
            <tr>
                <td>Suburb:</td>
                <td><%=a.getSuburb()%></td>
            </tr>
        </table>
            <p>
                Click <a href="index.html">here</a> to login.
            </p>
    </body>
</html>
