/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.IOException;
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
public class viewAllBooks extends HttpServlet {
    
    @EJB
    BookFacadeLocal bfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Book> books = bfl.findAll();
            if(books != null){
                request.setAttribute("books", books);
                request.getRequestDispatcher("viewAllBooks.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("noBooks.html").forward(request, response);
            }
    }

}
