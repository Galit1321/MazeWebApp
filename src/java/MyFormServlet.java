/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * *
 *
 * @author galit
 */
@WebServlet(name = "MyFormServlet", urlPatterns = {"/MyFormServlet"})
public class MyFormServlet extends HttpServlet {

    public Map<String,String> ls;
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
        } else if (act.equals("Enter")) {
             HttpSession session = request.getSession();
            response.sendRedirect("secured/MyPrivateData");
        } else {
             request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}