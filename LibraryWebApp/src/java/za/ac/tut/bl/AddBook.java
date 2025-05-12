/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.enttes.Author;
import za.ac.tut.enttes.Book;

/**
 *
 * @author Wonder
 */
@MultipartConfig
public class AddBook extends HttpServlet {
    
    @EJB
    BookFacadeLocal bfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String title = request.getParameter("title");
            String isbn =                       request.getParameter("isbn");
            String author1NameAndSurname = request.getParameter("author1");
            String author2NameAndSurname = request.getParameter("author2");
            System.out.println(request.getParameter("publishDate"));
            String dateString = request.getParameter("publishDate");
            System.out.println(dateString);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date publishDate = new Date();
            try {
                publishDate = sdf.parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            double price = Double.parseDouble(request.getParameter("price"));
            Part p = request.getPart("bookCopy");
            byte[] bookCopy = createBookCopy(p);
            List<Author> authors = new ArrayList<>();
            Author a = createAuthor(author1NameAndSurname);
            authors.add(a);
            if(author2NameAndSurname != null && author2NameAndSurname.length() > 0){
                Author b = createAuthor(author2NameAndSurname);               
                authors.add(b);
            } 
            Book b = new Book(title, isbn, authors, publishDate, price,bookCopy );
            bfl.create(b);
            
            request.setAttribute("book", b);
            request.getRequestDispatcher("bookAdded.jsp").forward(request, response);
    }
    
    public Author createAuthor(String nameAndSurname){
        String[] nameAndS = nameAndSurname.split(" ");
        String name = nameAndS[0];
        String surname = nameAndS[1];
        Author a = new Author(name, surname);
        return a;
    }
    
    public byte[] createBookCopy(Part p) throws IOException {
    try (InputStream input = p.getInputStream()) {
        byte[] data = new byte[(int) p.getSize()];
        int totalBytesRead = 0;
        while (totalBytesRead < data.length) {
            int bytesRead = input.read(data, totalBytesRead, data.length - totalBytesRead);
            if (bytesRead == -1) break;
            totalBytesRead += bytesRead;
        }
        return data;
    }
    }

}
