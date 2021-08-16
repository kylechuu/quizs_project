package com.example.quizs_project;

import com.example.quizs_project.DAO.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FeedBacKServlet", value = "/feedback")
public class FeedBacKServlet extends HttpServlet {
    private DAO dao;

    public void init() {
        this.dao = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession oldSession = request.getSession(false);
        if(oldSession == null) {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            request.getRequestDispatcher("index.html").forward(request, response);
            writer.print(
                    "<div class='container'>" +
                            "<h2 style='color: red;'>Unauthorized access, please login.</h2>" +
                            "</div>"
            );

            writer.close();
        } else {
            String userName = (String) oldSession.getAttribute("userName");
            String Rates = request.getParameter("Rate");
            String Message = request.getParameter("Feedback");

            dao.addFeedBack(userName, Message, Rates);
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            request.getRequestDispatcher("index.html").include(request, response);
            writer.print("<html><body>");
            writer.println("<h1> Thanks for your feedback!! </h1>");
            writer.print("</body></html>");
            writer.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
