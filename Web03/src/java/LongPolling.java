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
import javafx.util.Pair;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Model;
import objects.Receiver;
import objects.User;
import objects.singleMaze;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sechiya Zori
 */
@WebServlet(name = "LongPolling", urlPatterns = {"/LongPolling"}, asyncSupported = true)
public class LongPolling extends HttpServlet {

    private AsyncContext asyncContext;
    private Model m;
    private HttpSession session;
 private  int counter = 0;
 private User u;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        AsyncContext async = request.startAsync();
          async.setTimeout(0);
          asyncContext = async;
        Thread generator = new Thread() {       
        @Override
        public void run() {
           Random random = new Random();
           while (!Thread.currentThread().isInterrupted()) {
               try {
                   Thread.sleep(random.nextInt(200));
                   if (asyncContext != null) {
                       User usr = (User) session.getAttribute("Curr");
                       m= usr.mode;
                        JSONObject obj = new JSONObject();
                        m.getMsn();
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
               } catch (InterruptedException ex) {
                   Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JSONException ex) {
                   Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    };
    generator.start();
    }
}

                
            
        
    

