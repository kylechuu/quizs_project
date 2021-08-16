package com.example.quizs_project;
import com.example.quizs_project.DAO.DAO;
import com.mysql.cj.Session;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null){
            oldSession.invalidate();
        }

        HttpSession newSession = request.getSession(true);
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        newSession.setAttribute("userName", userName);
        newSession.setAttribute("password", passWord);

        DAO dao = new DAO();
        dao.addUserInfo(userName, passWord);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Registration success!! " + userName +", Welcome!"+ "</h1>");
        out.println("</body></html>");

        request.getRequestDispatcher("index.html").include(request, response);
    }


    public void destroy() {
    }
}