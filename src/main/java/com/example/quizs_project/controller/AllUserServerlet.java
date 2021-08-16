package com.example.quizs_project.controller;



//import com.google.gson.Gson;
import com.example.quizs_project.DAO.DAO;
//import com.impressivehen.databaseservlet.domain.common.ServiceStatus;
//import com.impressivehen.databaseservlet.domain.AllPetsResponse;
import com.example.quizs_project.Entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "allUserInfoServlet", value = "/userinfo")
public class AllUserServerlet extends  HttpServlet{
    private DAO userDAO;

    @Override
    public void init() {
        this.userDAO = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserInfo> usersInfos = userDAO.getAllUserInfo();
        System.out.println(usersInfos);
//        PrintWriter writer = resp.getWriter();
//        writer.append(usersInfos);
//        writer.close();
    }
}


