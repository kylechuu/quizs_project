package com.example.quizs_project.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class AuthenticatedFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null && oldSession.getAttribute("userName") != null){
            System.out.println("pass");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("not pass");
            servletRequest.getRequestDispatcher("index.html").include(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
