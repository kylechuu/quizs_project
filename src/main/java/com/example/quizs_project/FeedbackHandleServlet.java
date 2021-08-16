package com.example.quizs_project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FeedbackHandleServlet", value = "/feedback_handle")
public class FeedbackHandleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession oldSession = request.getSession(false);

        if(oldSession == null) {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            request.getRequestDispatcher(request.getContextPath()).include(request, response);
            writer.print(
                    "<div class='container'>" +
                            "<h2 style='color: red;'>Unauthorized access, please login.</h2>" +
                            "</div>"
            );

            writer.close();
        } else {
            request.getRequestDispatcher("pages/feedback.html").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
