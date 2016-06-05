
import java.io.IOException;
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
 * MultiProgress.
 */
@WebServlet(name = "MultiProgress", urlPatterns = {"/secured/MultiProgress"}, asyncSupported = true)
//@WebServlet(name = "MultiProgress",urlPatterns = {"/MultiProgress"},sayncSupported = true)
public class MultiProgress extends HttpServlet {

    public AsyncContext asyncContext;
    public Model m;//the model to send msn
    public HttpSession session;
     private int counter = 0;
    public User u;

    /**
     * init.
     * @throws ServletException 
     */
    @Override
    public void init() throws ServletException {
        counter = 0;
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

        session = request.getSession(false);
        AsyncContext async = request.startAsync(request, response);
        async.setTimeout(0);
        asyncContext = async;
        Thread generator = new Thread() {
            //run the func.
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
                        if (random.nextInt(10) == 7) {
                            counter += 10;
                            if (counter > 90) {
                                counter -= 10;
                            }
                        }
                        // if there is a game send the  values.
                        try {
                            if (m.getJson().g != null) {
                                Game game = m.getJson().g;
                                singleMaze s = game.getYou();
                                singleMaze other = game.getOther();
                                u.setMaze(s);
                                u.setOther(other);
                                m.sendMsn("solve " + game.getName() + " 1");
                                obj.put("Maze", s.getMaze());
                                obj.put("Name", s.getName());
                                obj.put("Start_i", s.getStart().getKey());
                                obj.put("Start_j", s.getStart().getValue());
                                obj.put("End_i", s.getEnd().getKey());
                                obj.put("End_j", s.getEnd().getValue());
                                ////////

                                counter = 100;
                            }
                            obj.put("progress", counter);
                        } catch (JSONException ex) {
                            Logger.getLogger(MultiProgress.class.getName()).log(Level.SEVERE, null, ex);
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
        generator.start();
    }

}
