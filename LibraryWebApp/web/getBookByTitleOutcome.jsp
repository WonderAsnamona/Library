<%-- 
    Document   : getBookByTitleOutcome
    Created on : 11 May 2025, 9:23:27 PM
    Author     : Wonder
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="za.ac.tut.enttes.Client"%>
<%@page import="za.ac.tut.enttes.Author"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.enttes.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Client c = (Client)session.getAttribute("client");
            List<Book> book = (List<Book>) request.getAttribute("books");
            String title = book.get(0).getTitle();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
        %>
        <h1>Library</h1>
        <p>
            Results for <b><%=title%></b>
        </p>
        <table>
            <th>Title</th>
            <th>ISBN</th>
            <th>Price</th>
            <th>Publish Date</th>
            <th>Author(s)</th>
            <th>Buy or Download</th>
            <%
                for(Book b: book){
            %>
            <tr>
                <td><%=b.getTitle()%></td>
                <td><%=b.getIsbn()%></td>
                <td>R <%=b.getPrice()%></td>
                <td><%=sdf.format(b.getPublishDate())%></td>
                <td>
                    <%
                    List<Author> authors = b.getAuthor();
                    for(Author a: authors){
                    %>
                     <%=a.getName()%> <%=a.getSurname()%>    
                    <%
                    }
                    %>
                </td>
                <td>
                    <%
                        if(b.getPrice() > 0.00 && !c.getBooksOwned().contains(b)){
                    %>
                    <a href="buyBook.jsp">Buy</a>
                    <%
                        }
                        else{
                            %>
                            <a href="downloadBook.do?title=<%=b.getTitle()%>">Download</a>
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <p>
            Click <a href="searchBook.html">here</a> to search again or go to <a href="clientMenuPage.html">menu</a>.
        </p>
    </body>
</html>
