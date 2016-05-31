/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/Progress"})
public class ProgressServlet extends HttpServlet {

   // public Model model;
    private static int counter = 0;
    private Random random = new Random();
    private Boolean sendrq = false;
    private Model m;// = Model.getInstance();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  //  public 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("Curr");
        this.m = u.mode;
        if (!this.sendrq) {
            counter=0;
            this.sendrq = true;
           Thread t = new Thread(() -> {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgressServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.getMsn();
        m.sendMsn("solve "+m.getJson().maze.getName()+" 0");
        m.getMsn();    
    });
           t.start();
        }
        if (random.nextInt(10) == 7) {
            counter += 10;
            if (counter > 90) {
                counter -= 10;
            }
        }
        JSONObject obj = new JSONObject();
        if (m.dataReceive) {
            try {
                singleMaze s = m.getJson().maze;
                u.setMaze(s);
              // singleMaze sol = m.getJson().solv;
               // u.setSolStr(sol.getMaze());
                obj.put("Maze", s.getMaze());
                obj.put("Name", s.getName());
                obj.put("Start_i", s.getStart().getKey());
                obj.put("Start_j", s.getStart().getValue());
                obj.put("End_i", s.getEnd().getKey());
                obj.put("End_j", s.getEnd().getValue());
                this.sendrq = false;
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

 

}