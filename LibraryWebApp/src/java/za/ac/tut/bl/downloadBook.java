/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.enttes.Book;

/**
 *
 * @author Wonder
 */
public class downloadBook extends HttpServlet {

     @EJB
    BookFacadeLocal bfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        List<Book> books = bfl.findByTitle(title); 

        if (books.get(0) != null && books.get(0).getBookCopy() != null) {
            response.setContentType("application/pdf"); 
            response.setHeader("Content-Disposition", "attachment; filename=\"" + books.get(0).getTitle() + ".pdf\"");
            OutputStream out = response.getOutputStream();
            out.write(books.get(0).getBookCopy());
            out.flush();
        } else {
            response.setContentType("text/html");
            response.getWriter().write("Book not found or file missing.");
        }
    }
}
