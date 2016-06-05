
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objects.SharedInfo;
import objects.User;

/**
 * Subscribe servlet.
 */
@WebServlet(urlPatterns = {"/SubscribeServlet"}, asyncSupported = true)
public class SubscribeServlet extends HttpServlet {

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
        response.sendRedirect("Subscribe.jsp");
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
        String act = request.getParameter("act");
         if (act==null) {
           //no button was press 
        }else if (act.equals("Done")) {
           AddUser(request);
           response.sendRedirect("MyFormServlet");
        }
    }

    /**
     * Add user to user list.
     * @param request - values of the user.
     */
    public void AddUser(HttpServletRequest request) {
        SharedInfo si = SharedInfo.getSharedInfo();
        String name = request.getParameter("name");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String icon = request.getParameter("myCheck");
        User u =new User(name, userName, password, mail, icon);
        si.addUserList(userName, u);
       
    }
}
