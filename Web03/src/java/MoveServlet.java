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
        //  processRequest(request, response);
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
        // processRequest(request, response);
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("Curr");
        this.m = u.mode;
        Pair p = u.getMaze().move(request.getParameter("move"));
        JSONObject obj = new JSONObject();
        int r=(int)u.getMaze().getCurrrnt().getKey();
        int c=(int)u.getMaze().getCurrrnt().getValue();
        int oldpos = (u.getMaze().getSize() * r) + c;     
        try {
            obj.put("Prv",oldpos);
        } catch (JSONException ex) {
            Logger.getLogger(MoveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int myRow = (int) p.getKey();
        int myCol = (int) p.getValue();
        u.getMaze().setCurrent(p);
        //Position in the string.
        int pos = (u.getMaze().getSize() * myRow) + myCol;
        char[] solarr=u.getSolStr().toCharArray();
        if (solarr[pos]=='2'){
            u.getMaze().setClue(pos);
        }
        try {
            obj.put("location", pos);
        } catch (JSONException ex) {
            Logger.getLogger(MoveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("appliation/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(obj);
        }
        
    }

}
