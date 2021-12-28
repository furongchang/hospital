package org.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String user = (String) request.getSession().getAttribute("user");

        if(user != null){
            String per = (String)request.getSession().getAttribute("role");
            if(per.equals("A")){
                filterChain.doFilter(request, response);
            }else{
                response.sendRedirect("/list.jsp");
            }
            return;

        }
        response.sendRedirect("index.jsp");
        return;
    }

    @Override
    public void destroy() {
    }
}
