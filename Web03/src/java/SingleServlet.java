import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.User;

/**
 * Single Servlet.
 */
@WebServlet(urlPatterns = {"/secured/SingleServlet"}, asyncSupported = true)
public class SingleServlet extends HttpServlet {

    private Random random = new Random();

    /**
     * Handles the HTTP <code>POST</code> method.
     * Create maze.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User usr = (User) session.getAttribute("Curr");
        String submit = request.getParameter("button");
       // usr.clean();
        if (submit == null) {
            //noting is press
        } else if (submit.equals("SingleGame")) {
            String msn = "generate maze" + random.nextInt(100) + " 1";
            usr.mode.sendMsn(msn);
            request.getRequestDispatcher("single.jsp").forward(request, response);
        } else {//we chose multiplayer
            request.getRequestDispatcher("GameLounge.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
