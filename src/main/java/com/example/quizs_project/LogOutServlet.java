package com.example.quizs_project;

import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogOutServlet", value = "/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            request.getRequestDispatcher(request.getContextPath()).include(request, response);
            writer.print(
                    "<div class='container'>" +
                            "<h2 style='color: red;'>Log out success!!.</h2>" +
                            "</div>"
            );
            writer.close();
        }

        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
