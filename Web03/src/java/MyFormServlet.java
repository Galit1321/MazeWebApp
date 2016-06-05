
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.User;

/**
 * MyFromServlet - relate to the login.
 */
@WebServlet(name = "MyFormServlet", urlPatterns = {"/MyFormServlet"}, asyncSupported = true)
public class MyFormServlet extends HttpServlet {

    /**
     * Open the login - Start page.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    /**
     * Get the user to the menu.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SharedInfo si = SharedInfo.getSharedInfo();
        Map<String, User> Users = si.getUserList();
        String sizeFromWeb = getServletContext().getInitParameter("size");
        int s = (parseInt(sizeFromWeb) * 2) - 1;
        sizeFromWeb = Integer.toString(s);
        User curr = Users.get(request.getParameter("username"));
        if ((curr != null) && (curr.checkPassword(request.getParameter("password")))) {
            curr.mode.Start(getServletContext().getInitParameter("IP"), getServletContext().getInitParameter("port"));
            HttpSession session = request.getSession(true);
            session.setAttribute("Curr", curr);
            session.setAttribute("Size", sizeFromWeb);
            response.sendRedirect("/secured/MyPrivateData");
        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
