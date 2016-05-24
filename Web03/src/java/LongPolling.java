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
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author גליתונופר
 */
@WebServlet(urlPatterns = {"/LongPolling"})
public final class LongPolling extends HttpServlet {

    private AsyncContext asyncContext;
    private final Random random = new Random();
    private final Thread generator = new Thread() {
        private int counter = 0;

        @Override
        public void run() {
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
                } catch (InterruptedException | IOException | JSONException ex) {

                    Logger.getLogger(LongPolling.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };

    @Override
    public void init() throws ServletException {
        generator.start();
    }

    @Override
    public void destroy() {
        generator.interrupt();
    }

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException,
            IOException {
        AsyncContext async = req.startAsync();
        async.setTimeout(0);
        asyncContext = async;
    }
}
