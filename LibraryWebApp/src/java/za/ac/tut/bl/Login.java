/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import com.sun.faces.application.resource.LibraryInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.enttes.Client;

/**
 *
 * @author Wonder
 */
public class Login extends HttpServlet {

    @EJB
    ClientFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Client c  = cfl.findByUsernameAndPassword(username, password);
            System.out.println(c);
            if(c != null){
                HttpSession session = request.getSession(true);
                session.setAttribute("client", c);
                request.getRequestDispatcher("clientMenuPage.html").forward(request, response);
            }
            else{
                request.getRequestDispatcher("noAcc.html").forward(request, response);
            }
    }

}
