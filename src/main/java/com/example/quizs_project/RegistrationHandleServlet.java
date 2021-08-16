package com.example.quizs_project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationHandleServlet", value = "/registration_handle")
public class RegistrationHandleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            String userName = (String)oldSession.getAttribute("userName");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Hi " + userName +", Welcome!"+ "</h1>");
            out.println("</body></html>");
            request.getRequestDispatcher("pages/registration_page.html").include(request, response);
            out.close();
        } else {
            request.getRequestDispatcher("pages/registration_page.html").include(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
