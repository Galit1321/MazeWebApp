/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.User;

/**
 *
 * @author גליתונופר
 */
@WebServlet(urlPatterns = {"/SingleServlet"})
public class SingleServlet extends HttpServlet {

    private Random random = new Random();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User usr = (User) session.getAttribute("Curr");
        String submit = request.getParameter("button");
       // usr.clean();
        if (submit == null) {
            //noting is press
        } else if (submit.equals("SingleGame")) {
           
            String msn = "generate maze" + random.nextInt(100) + " 1";
            usr.mode.sendMsn(msn);
            request.getRequestDispatcher("single.jsp").forward(request, response);
        } else {//we chose multiplayer
             String msn = "multiplayer game" + random.nextInt(100);
            request.getRequestDispatcher("GameLounge.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
