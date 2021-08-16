package com.example.quizs_project;

import com.example.quizs_project.DAO.DAO;
import com.example.quizs_project.Entity.FeedBack;
import com.example.quizs_project.Entity.Record;
import com.example.quizs_project.Entity.UserInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private DAO dao;

    @Override
    public void init() {
        this.dao = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfo> userInfos = dao.getAllUserInfo();
        List<Record> Records = dao.getUserRecord();
        List<FeedBack> feedBacks = dao.getFeedBack();
        request.setAttribute("Records", Records);
        request.setAttribute("userInfos", userInfos);
        request.setAttribute("feedBacks", feedBacks);

        request.getRequestDispatcher("admin.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
