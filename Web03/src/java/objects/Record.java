/*
 
package Controller;

import Model.MazeClass;
import Model.Point;
import Model.SingleAnswer;
import Model.TCPClient;
import Model.User;
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
import org.json.simple.JSONObject;



@WebServlet(name = "MazeServlet", urlPatterns = {"/secured/MazeServlet"},sayncSupported = true)
public class MazeServlet extends HttpServlet {

    private AsyncContext asyncContext;
    private TCPClient socket;
    private HttpSession session;
    
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
                       User usr = (User) session.getAttribute("user");
                       socket = usr.getSocket();
                       while (!socket.dataRecived())
                       {
                           Thread.sleep(random.nextInt(200));
                           //wait//
                       }
                       SingleAnswer a = socket.getData();
                       JSONObject obj = new JSONObject();
                       MazeClass maze = a.getContent();
                       Point start = maze.getStart();
                       maze.setStart(new Point(2*start.getRow(),2*start.getCol()));
                       session.setAttribute("restart", maze.getStart());
                       Point end = maze.getEnd();
                       maze.setEnd(new Point(2*end.getRow(),2*end.getCol()));
                       session.setAttribute("maze", maze);
                       String m = maze.getMaze();
                       obj.put("maze", m);
                       HttpServletResponse peer = (HttpServletResponse) asyncContext.getResponse();
                       try {
                           
                           peer.getWriter().write(obj.toString());
                           
                       } catch (IOException ex) {
                           Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       peer.setStatus(HttpServletResponse.SC_OK);
                       peer.setContentType("application/json");
                       asyncContext.complete();
                       break;
                   }
               } catch (InterruptedException ex) {
                   Logger.getLogger(MazeServlet.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    };
    generator.start();
    }
}*/