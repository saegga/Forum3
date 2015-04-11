package mypackage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by sergei on 31.03.2015.
 */
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if((((HttpServletRequest) req).getSession().getAttribute("flag") != null)){
            chain.doFilter(req, resp);
        }
        else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
