package com.blue.Filter;

import org.apache.commons.lang3.StringUtils;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author blue
 * @date 2023/4/7 9:19
 **/
@WebFilter(urlPatterns = "/*")
public class D_ForeServletFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String fore = "/fore";
        String context = req.getContextPath();
        String uri = req.getRequestURI();
        uri = StringUtils.remove(uri,context);

        if (uri.startsWith(fore)){
            String path = StringUtils.substringBetween(uri,"_","_");
            String method = StringUtils.substringAfterLast(uri,"_");
            req.setAttribute("method",method);
            req.getRequestDispatcher("/"+path+"Servlet").forward(req,resp);
            return;
        }
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
