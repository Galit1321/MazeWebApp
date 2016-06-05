
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
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
 * Move. - 
 */
@WebServlet(name = "MoveServlet" ,urlPatterns = {"/secured/MoveServlet"}, asyncSupported = true)
public class MoveServlet extends HttpServlet {
    
    public Model m;

    /**
     * Handles the HTTP <code>POST</code> method.
     * Send the moves as Json.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("Curr");
        this.m = u.mode;
        String move = request.getParameter("move");
        Pair p = u.getMaze().move(u.getMaze().getCurrrnt(),move);
        if (request.getParameter("game").equals("m")) {
            m.sendMsn("play " + move);
        }
        JSONObject obj = new JSONObject();
        int r = (int) u.getMaze().getCurrrnt().getKey();
        int c = (int) u.getMaze().getCurrrnt().getValue();
        int oldpos = (u.getMaze().getSize() * r) + c;        
        int myRow = (int) p.getKey();
        int myCol = (int) p.getValue();
        u.getMaze().setCurrent(p);

        //Position in the string.
        int pos = (u.getMaze().getSize() * myRow) + myCol;
        char[] solarr = u.getSolStr().toCharArray();
        if (solarr[pos] == '2') {
            u.getMaze().setClue(pos);
        }
        try {
            obj.put("Prv", oldpos);
            obj.put("location", pos);
            obj.put("Won", u.getMaze().getEnd().equals(p));
        } catch (JSONException ex) {
            Logger.getLogger(MoveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("appliation/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(obj);
        }
        
    }
    
}
