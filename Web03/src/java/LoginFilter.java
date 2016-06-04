
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Login - the first page.
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/secured/*"}, asyncSupported = true)
public class LoginFilter implements Filter {

    /**
     * 
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/MyFormServlet");
        }
    }

    /**
     * init.
     * @param filterConfig
     * @throws ServletException 
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * destroy.
     */
    @Override
    public void destroy() {
    }
}
