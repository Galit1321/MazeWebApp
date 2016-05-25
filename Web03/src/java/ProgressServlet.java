/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objects.Model;
import objects.singleMaze;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author revit
 */
@WebServlet(urlPatterns = {"/Progress"})
public class ProgressServlet extends HttpServlet {

    private static int counter = 0;
    private Random random = new Random();
    private Boolean sendrq = false;
    private Model m = Model.getInstance();

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
            out.println("<title>Servlet ProgressServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProgressServlet at " + request.getContextPath() + "</h1>");
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
        if (!this.sendrq) {
            String msn = "generate maze" + " 1";
            m.sendMsn(msn);
            this.sendrq = true;
            m.getMsn();
        }
        if (random.nextInt(10) == 7) {
            counter += 10;
            if (counter > 90) {
                counter -= 10;
            }
        }
        
      
        JSONObject obj = new JSONObject();
        singleMaze s= m.getJson().maze;
        if (m.getJson() != null) {
            try {
                obj.put("Maze",s.getMaze());
                obj.put("Name", s.getName());
                obj.put("Start_i", s.getStart().getKey());
                obj.put("Start_j", s.getStart().getValue());
                
                
                counter = 100;
            } catch (JSONException ex) {
                Logger.getLogger(ProgressServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            obj.put("progress", counter);
        } catch (JSONException ex) {
            Logger.getLogger(ProgressServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("appliation/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(obj);
        }
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
