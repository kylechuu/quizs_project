package com.example.quizs_project;

import com.example.quizs_project.DAO.DAO;
import com.example.quizs_project.Entity.UserInfo;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private DAO dao;

    public void init() {
        this.dao = new DAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
        }

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        List<UserInfo> userInfos = dao.getAllUserInfo();
        boolean userIsValid = dao.checkCredentials(userInfos, userName, passWord);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if(userIsValid) {
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("userName", userName);
            newSession.setAttribute("password", passWord);
            newSession.setMaxInactiveInterval(10 * 60);

            writer.print("<html><body>");
            writer.println("<h1>" + "(Login success!!!)" + "</h1>");
            writer.print("</body></html>");
//                request.getRequestDispatcher("index.html").include(request, response);
        } else {
            writer.print("<html><body>");
            writer.println("<h1>" + "(Login failed!!!)" + "</h1>");
            writer.print("</body></html>");
//                request.getRequestDispatcher(request.getContextPath()).include(request, response);
        }
        request.getRequestDispatcher("index.html").include(request, response);
        writer.close();
    }


    public void destroy() {
    }
}