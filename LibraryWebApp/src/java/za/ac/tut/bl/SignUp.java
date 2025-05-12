/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.enttes.Address;
import za.ac.tut.enttes.Book;
import za.ac.tut.enttes.Client;

/**
 *
 * @author Wonder
 */

public class SignUp extends HttpServlet {
    
    @EJB
    ClientFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String passWord1 = request.getParameter("password1");
            String passWord2 = request.getParameter("password2");
            String streetname = request.getParameter("streetname");
            String city = request.getParameter("city");
            Long housenumber = Long.parseLong(request.getParameter("housenumber"));
            String suburb = request.getParameter("suburb");
            List<Book> books = new ArrayList<>();
            Address address = new Address(streetname, housenumber, city, suburb);
            if(checkPasswords(passWord1, passWord2)){
                if(!checkUsernameExistance(username)){
                    Client c = new Client(name, username, passWord2, address, books);
                    cfl.create(c);
                    request.setAttribute("client", c);
                    request.getRequestDispatcher("signnedUp.jsp").forward(request, response);
                }else{
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("usernameExist.jsp").forward(request, response);
                }
            }else{
                request.getRequestDispatcher("passwordDontMatch.html");
            }
    }
    
    public boolean checkPasswords(String pass1, String pass2){
        boolean match = false;
        if(pass1.equals(pass2)){
            match = true;
        }
        return match;
    }
    
    public boolean checkUsernameExistance(String username){
        boolean exists = false;
        Client cs = cfl.findByUsername(username);
        if(cs != null){
            exists = true;
        }
        return exists;
    }
}
