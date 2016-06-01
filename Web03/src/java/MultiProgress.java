/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Game;
import objects.Model;
import objects.User;
import objects.singleMaze;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author גליתונופר
 */
@WebServlet(name ="MultiProgress", urlPatterns = {"/MultiProgress"},asyncSupported = true)
//@WebServlet(name = "MultiProgress",urlPatterns = {"/MultiProgress"},sayncSupported = true)
public class MultiProgress extends HttpServlet {

      public AsyncContext asyncContext;
    private Model m;//the model to send msn
   private HttpSession session;
  private int counter;
  private User u;
   

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
       session = request.getSession(false);
        AsyncContext async = request.startAsync(request, response);
        async.setTimeout(0);
        asyncContext = async;
        Thread generator = new Thread() {
            @Override
            public void run() {
                Random random = new Random();
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(random.nextInt(200));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        if (asyncContext != null) {
                            u = (User) session.getAttribute("Curr");
                            m = u.mode;
                            JSONObject obj = new JSONObject();
                            if(random.nextInt(10) == 7) {
                                counter += 10;
                                if (counter > 90) {
                                    counter -= 10;
                                }
                            }
                                try {
                                   if ( m.getJson().g!=null) {
                                    Game game = m.getJson().g;
                                    singleMaze s=game.getYou();
                                   singleMaze other=game.getOther();
                                    u.setMaze(s);
                                    m.sendMsn("solve "+game.getName()+" 1");                                    
                                    obj.put("Maze", s.getMaze());
                                    obj.put("Name", s.getName());
                                    obj.put("Start_i", s.getStart().getKey());
                                    obj.put("Start_j", s.getStart().getValue());
                                    obj.put("End_i", s.getEnd().getKey());
                                    obj.put("End_j", s.getEnd().getValue());
                                    ////////
                                    
                                    //obj.put("OpName", s.getName());
                                   obj.put("OpStart_i", other.getStart().getKey());
                                    obj.put("OpStart_j", other.getStart().getValue());
                                    obj.put("OpEnd_i", other.getEnd().getKey());
                                    obj.put("OpEnd_j", other.getEnd().getValue());
                                    counter = 100;
                                }  obj.put("progress", counter);
                                } catch (JSONException ex) {
                                    Logger.getLogger(ProgressServlet.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                HttpServletResponse peer = (HttpServletResponse) asyncContext.getResponse();
                                try {

                                    peer.getWriter().write(obj.toString());

                                } catch (IOException ex) {
                                    Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                peer.setStatus(HttpServletResponse.SC_OK);
                                peer.setContentType("application/json");
                                asyncContext.complete();
                                break;
                            }
                    }
                }
            };  
            generator.start ();
        }

}
