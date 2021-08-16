package com.example.quizs_project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginHandleServlet", value = "/login_handle")
public class LoginHandleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession oldSession = request.getSession(false);
        if(oldSession == null) {
            request.getRequestDispatcher("pages/login.html").forward(request, response);
        } else {
            String userName = (String) oldSession.getAttribute("userName");
            if(userName.equals("admin")){
                System.out.println("hi");
                request.getRequestDispatcher("admin").include(request, response);
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print("<html><body>");
                out.println("<h1>" + userName + ", Welcome!"+ "</h1>");
                out.print("</body></html>");
                request.getRequestDispatcher("index.html").include(request, response);

                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
