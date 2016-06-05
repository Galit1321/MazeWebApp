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
import javafx.util.Pair;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Model;
import objects.User;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author גליתונופר
 */
@WebServlet(urlPatterns = {"/secured/Moves"}, asyncSupported = true)
public class Moves extends HttpServlet {

    private AsyncContext asyncContext;
    private Model m;
    private HttpSession session;
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
        AsyncContext async = request.startAsync();
        async.setTimeout(0);
        asyncContext = async;
        Thread generator = new Thread() {
            @Override
            public void run() {
                try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Moves.class.getName()).log(Level.SEVERE, null, ex);
                    }
                /*while ((m.getJson().getInSession()) && (m.getJson().getGotMove())) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Moves.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                if (asyncContext != null) {
                   // u = (User) session.getAttribute("Curr");
                   // m = u.mode;
                    JSONObject obj = new JSONObject();
                   // Pair p = u.getMaze().move(u.getOther().getCurrrnt(), m.getJson().getMove());
                   // int HimRow = (int) p.getKey();
                   // int HimCol = (int) p.getValue();
                   // u.getOther().setCurrent(p);
                   // u.mode.getJson().setGotMove(Boolean.FALSE);
                    //int pos = -1 * ((HimRow * u.getOther().getSize()) + HimCol);
                    
                    try {
                        obj.put("Pos", -1);
                        obj.put("stop",true);
                       // obj.put("Won", u.getOther().getEnd().equals(p));
                    } catch (JSONException ex) {
                        Logger.getLogger(MoveServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                    
                }
            }  
    }

    ;
    generator.start ();
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
        //processRequest(request, response);

    }

    
}
