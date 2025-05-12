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
public class RemoveBookByTitle extends HttpServlet {

    @EJB
    BookFacadeLocal bfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String title = request.getParameter("title");
            List<Book> books = bfl.findByTitle(title);
            request.setAttribute("title", title);
            if(books.size() > 0 && !books.isEmpty()){
                bfl.remove(books.get(0));
                request.getRequestDispatcher("nbookRemoved.jsp").forward(request, response);
           }else{
                request.getRequestDispatcher("noBookRemoved.jsp").forward(request, response);
            }
    }
}
