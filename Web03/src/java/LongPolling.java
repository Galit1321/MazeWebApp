
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
import objects.Model;
import objects.User;
import objects.singleMaze;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Long polling.
 */
@WebServlet(name = "LongPolling", urlPatterns = {"/secured/LongPolling"}, asyncSupported = true)
public class LongPolling extends HttpServlet {

   public AsyncContext asyncContext;
    private Model m;
    public HttpSession session;
    private int counter = 0;
    private User u;

    /**
     * do get.
     * @param request - get request.
     * @param response - the response.
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        AsyncContext async = request.startAsync();
        async.setTimeout(0);
        asyncContext = async;
        Thread generator = new Thread() {
            @Override
            //run.
            public void run() {
                Random random = new Random();
                //while for thread.
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
                                    //if there is a mase send all the values for maze.
                                    if ( m.getJson().maze!=null) {
                                    singleMaze s = m.getJson().maze;
                                    u.setMaze(s);
                                    m.sendMsn("solve "+s.getName()+" 1");
                                    obj.put("Maze", s.getMaze());
                                    obj.put("Name", s.getName());
                                    obj.put("Start_i", s.getStart().getKey());
                                    obj.put("Start_j", s.getStart().getValue());
                                    obj.put("End_i", s.getEnd().getKey());
                                    obj.put("End_j", s.getEnd().getValue());
                                    counter = 100;
                                   
                                }  obj.put("progress", counter);
                                } catch (JSONException ex) {
                                    Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
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
