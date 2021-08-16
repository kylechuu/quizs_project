package com.example.quizs_project.controller;

//import com.google.gson.Gson;
//import com.impressivehen.databaseservlet.domain.common.ServiceStatus;
//import com.impressivehen.databaseservlet.domain.AllPetsResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServerlet", value = "/home")
public class HomeServerlet extends  HttpServlet{
    @Override
    public void init() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/homepage.html").include(request, response);
    }
}


