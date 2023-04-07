package com.blue.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
/**
 * @author blue
 * @date 2023/4/1 10:29
 **/
@WebFilter(urlPatterns = "/*")
public class C_Base_Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String admin = "/admin";
        String context = req.getContextPath();
        String uri = req.getRequestURI();
        uri = StringUtils.remove(uri,context);

        if (uri.startsWith(admin)){
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
