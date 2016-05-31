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
import objects.Model;
import objects.Receiver;
import objects.User;
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
 private User usr;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
         usr = (User) session.getAttribute("user");
         m=usr.mode;
         
        AsyncContext async = request.startAsync();
        async.setTimeout(0);
        asyncContext = async;

        Thread generator = new Thread() {
            @Override
            public void run() {
                Random random = new Random();
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(random.nextInt(1000));
                        if (counter >= 100) {
                            break;
                        } else if (random.nextInt(10) == 7) {
                            counter += 10;
                            if (counter > 100) {
                                counter = 100;
                            }
                            if (asyncContext != null) {
                                
                                JSONObject obj = new JSONObject();
                                obj.put("progress", counter);
                                HttpServletResponse peer = (HttpServletResponse) asyncContext.getResponse();
                                peer.getWriter().write(obj.toString());
                                peer.setStatus(HttpServletResponse.SC_OK);
                                peer.setContentType("application/json");
                                asyncContext.complete();
                            }
                        }
                    } catch (InterruptedException | IOException e) {
                    } catch (JSONException ex) {
                        Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        generator.start();
    }
}

                
            
        
    

