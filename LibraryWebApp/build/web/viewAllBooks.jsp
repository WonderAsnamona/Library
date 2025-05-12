<%@page import="java.text.SimpleDateFormat"%>
<%@page import="za.ac.tut.enttes.Author"%>
<%@page import="za.ac.tut.enttes.Client"%>
<%@page import="za.ac.tut.enttes.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Book List</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: 'Georgia', serif;
                color: #fff;
            }

            .overlay {
                background-color: rgba(0, 0, 0, 0.75);
                min-height: 100vh;
                padding: 40px;
            }

            h1 {
                text-align: center;
                font-size: 3em;
                margin-bottom: 10px;
                color: #f9d342;
                text-shadow: 2px 2px 4px #000;
            }

            p {
                text-align: center;
                font-size: 1.2em;
                color: #e0e0e0;
                margin-bottom: 30px;
            }

            table {
                width: 95%;
                margin: 0 auto;
                border-collapse: collapse;
                background-color: rgba(255, 255, 255, 0.95);
                color: #333;
                border-radius: 10px;
                box-shadow: 0 8px 16px rgba(0,0,0,0.5);
                overflow: hidden;
            }

            th, td {
                padding: 15px;
                text-align: left;
            }

            th {
                background-color: #6c4c2b;
                color: #fff;
                font-size: 1.1em;
            }

            tr:nth-child(even) {
                background-color: #f9f6f1;
            }

            tr:hover {
                background-color: #e7dfd6;
            }

            a {
                color: #007bff;
                text-decoration: none;
                font-weight: bold;
            }

            a:hover {
                text-decoration: underline;
            }

            .footer {
                text-align: center;
                margin-top: 30px;
                font-size: 1em;
            }
        </style>
    </head>
    <body>
        <div class="overlay">
        <%
            Client c = (Client)session.getAttribute("client");
            List<Book> book = (List<Book>) request.getAttribute("books");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        %>

        <h1>Welcome to the Library</h1>
        <p>Explore books available in our collection:</p>

        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>ISBN</th>
                    <th>Price</th>
                    <th>Publish Date</th>
                    <th>Author(s)</th>
                    <th>Buy or Download</th>
                </tr>
            </thead>
            <tbody>
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
                         <%=a.getName()%> <%=a.getSurname()%><br>   
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
            </tbody>
        </table>

        <div class="footer">
            Click <a href="clientMenuPage.jsp">here</a> to return to the main menu.
        </div>
        </div>
    </body>
</html>
