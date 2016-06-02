/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.User;


/**
 *
 * 
 */
@WebServlet(name = "MyPrivateData", urlPatterns = {"/secured/MyPrivateData"}, asyncSupported = true)
public class MyPrivateData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession(false);
        //  User u=(User)request.getAttribute("curr");
     // session.setAttribute("Curr", u);
       request.getRequestDispatcher("data.jsp").forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     // HttpSession session = request.getSession(false);
     // User u=(User)request.getAttribute("curr");
      //.setAttribute("Curr", u);
      request.getRequestDispatcher("data.jsp").forward(request, response);
    }

}
