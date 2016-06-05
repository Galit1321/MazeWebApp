
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * MyPrivteData. - the menu.
 */
@WebServlet(name = "MyPrivateData", urlPatterns = {"/secured/MyPrivateData"}, asyncSupported = true)
public class MyPrivateData extends HttpServlet {

    /**
     * Open the menu.
     * @param request - session
     * @param response - 
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession(false);
       request.getRequestDispatcher("data.jsp").forward(request, response); 
    }

    /**
     * Open the menu.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      request.getRequestDispatcher("data.jsp").forward(request, response);
    }

}
