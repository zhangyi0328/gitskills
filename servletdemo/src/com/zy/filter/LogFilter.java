package com.zy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    private FilterConfig config ;

    public void init(FilterConfig config) throws ServletException {
        this.config = config ;
    }

    public void destroy() {
        this.config = null ;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletContext context = this.config.getServletContext() ;
        Long before = System.currentTimeMillis() ;

        System.out.println("开始过滤.......");
        HttpServletRequest hrequest = (HttpServletRequest) req ;
        System.out.println("Filter拦截到用户请求地址： " + hrequest.getServletPath());
        chain.doFilter(req, resp);

        Long after = System.currentTimeMillis() ;
        System.out.println("过滤结束.......");
        System.out.println("请求地址： " + hrequest.getRequestURI() + " 所花时间： " + (after - before) );
    }


}
