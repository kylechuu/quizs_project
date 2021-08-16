package com.example.quizs_project;

import com.example.quizs_project.DAO.DAO;
import com.example.quizs_project.Entity.Record;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RecordServlet", value = "/record")
public class RecordServlet extends HttpServlet {
    private DAO dao;

    @Override
    public void init() {
        this.dao = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession oldSession = request.getSession(false);
        if (oldSession == null) {
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
            String userName = (String) oldSession.getAttribute("userName");

            List<Record> Records = dao.getUserRecord();
            List<Record> userRecord = new ArrayList<>();

//            System.out.println(userName);
//            System.out.println(Records.get(0).toString());

            for(int i = 0; i < Records.size(); i++){
                if(Records.get(i).getUserName().equals(userName)) {
                    userRecord.add(Records.get(i));
                    System.out.println(Records.get(i).toString());
                }
            }

            request.setAttribute("userRecord", userRecord);
            request.getRequestDispatcher("record.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
