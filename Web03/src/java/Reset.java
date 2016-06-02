

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.User;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author גליתונופר
 */
@WebServlet(urlPatterns = {"/secured/Reset"}, asyncSupported = true)
public class Reset extends HttpServlet {

   
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
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("Curr");
         JSONObject obj = new JSONObject();
          int r=(int)u.getMaze().getCurrrnt().getKey();
        int c=(int)u.getMaze().getCurrrnt().getValue();
        int oldpos = (u.getMaze().getSize() * r) + c; 
        int myRow = (int) u.getMaze().getStart().getKey();
        int myCol = (int) u.getMaze().getStart().getValue();
        int pos= (u.getMaze().getSize() * myRow) + myCol;
        u.getMaze().setCurrent(u.getMaze().getStart());
        try {
            obj.put("Prv",oldpos);
            obj.put("Start", pos);
        } catch (JSONException ex) {
            Logger.getLogger(MoveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         response.setContentType("appliation/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(obj);
        }
    }

   


}
