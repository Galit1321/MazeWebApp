/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Model;
import objects.User;
import objects.singleMaze;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author revit
 */
@WebServlet(urlPatterns = {"/MoveServlet"})
public class MoveServlet extends HttpServlet {
    private Model m;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MoveServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MoveServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("Curr");
        this.m = u.mode;
            Pair p = u.myMaze.move(request.getParameter("move"));
            if (u.myMaze.getCurrrnt().equals(p))//we didnt move at all 
            {
                return;
            }
            int myRow = (int) p.getKey();
            int myCol = (int) p.getValue();
            u.myMaze.setCurrent(p);
            //Position in the string.
            int pos = (u.myMaze.getSize() * myRow) + myRow;
           // if (MyMaze.solv[pos].Equals('2'))
           // {
            //    MyMaze.lastClue.Add(pos);
            //}
           //     if ((this.Coordinate.Equals(MyMaze.End)))//we reach goal in maze;
            //{
              //  Winner = true;
           // }
        JSONObject obj = new JSONObject();
        if (m.getJson() != null) {
            try {
                int id = (myRow * 10) + myCol;
                obj.put("location", id);
               // this.sendrq = false;
               // counter = 100;
            } catch (JSONException ex) {
                Logger.getLogger(ProgressServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
