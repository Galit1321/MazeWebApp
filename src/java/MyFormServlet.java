/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Model;
import objects.User;


@WebServlet(name = "MyFormServlet", urlPatterns = {"/MyFormServlet"})
public class MyFormServlet extends HttpServlet {

    public Map<String, User> Users;
    public Model m=Model.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
       response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            //no button has been selected
        } else if (act.equals("Subscribe")) {
            response.sendRedirect("Subscribe.jsp");
        }else if (act.equals("Done")) {
           AddUser(request);
            response.sendRedirect("login.jsp");
        }
        else if (act.equals("Enter")) {
            User curr = this.Users.get(request.getParameter("username"));
            if ((curr != null) && (curr.checkPassword(request.getParameter("password")))) {
                request.getSession().setAttribute("Curr", curr);
                request.getRequestDispatcher("secured/MyPrivateData").forward(request, response);                        
            } else {
                request.setAttribute("error", true);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    public void AddUser(HttpServletRequest request) {
        if (Users == null) {
            Users = new HashMap<String, User>();
        }
        String name = request.getParameter("name");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String icon =request.getParameter("myCheck");
        Users.put(userName, new User(name, userName, password, mail, icon));
    }
}
