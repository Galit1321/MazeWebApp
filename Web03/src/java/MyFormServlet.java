/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Model;
import objects.User;

@WebServlet(name = "MyFormServlet", urlPatterns = {"/MyFormServlet"}, asyncSupported = true)
public class MyFormServlet extends HttpServlet {

    //   public Model m=Model.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SharedInfo si = SharedInfo.getSharedInfo();
        Map<String, User> Users = si.getUserList();
        User curr = Users.get(request.getParameter("username"));
        if ((curr != null) && (curr.checkPassword(request.getParameter("password")))) {
            curr.mode.Start();
            HttpSession session = request.getSession();
            session.setAttribute("Curr", curr);
           // request.setAttribute("Curr", curr);
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/secured/MyPrivateData");
            //d.forward(request, response);
            //request.getRequestDispatcher("secured/MyPrivateData").forward(request, response);  
             response.sendRedirect("/secured/MyPrivateData");
        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
