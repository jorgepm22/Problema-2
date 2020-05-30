package service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/FilerServices")
public class FilterServices implements Filter {
    private ServletContext _context;

    public void init(FilterConfig filterConfig) throws ServletException {
        this._context = filterConfig.getServletContext();
        this._context.log("RequestLoggingFilter initialized");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) servletRequest;


        String ipAddress = req.getRemoteAddr();
        System.out.println("IP Address "+ipAddress + ", Time is"
                + new Date().toString());

        // pass the request along the filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}