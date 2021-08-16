package com.example.quizs_project;

import com.example.quizs_project.DAO.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    private char[] answer;
    private DAO dao;
    private List<List<String>> questions;
    private List<Character> optionList;
    private char[] trueAnswer;

    @Override
    public void init() {
        this.answer = new char[10];
        Arrays.fill(this.answer, 'N');
        this.optionList = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));
        this.dao = new DAO();
        this.questions = dao.getQuizQuestions();
        this.trueAnswer = new char[10];
    }

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
        }else {
            int currentPage = 0;
            if(request.getParameter("goHome") != null) {
                Arrays.fill(this.answer, 'N');
                request.getRequestDispatcher(request.getContextPath()).forward(request, response);
            }
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
            if(request.getParameter("reset") != null) {
                Arrays.fill(this.answer, 'N');
            }
            if (request.getParameter("questionId") != null) {
                String[] options = request.getParameterValues("questionId");
                for (String option : options) {
                    if (option != null) {
                        answer[currentPage] = option.charAt(0);
//                        System.out.println("Your option is: " + answer[currentPage]);
                    }
                }
            }

//            System.out.println("current page is: " + (currentPage + 1));

            if (request.getParameter("movePage") != null) {
                String nextPage = request.getParameter("movePage");
                if ("Next".equals(nextPage)) {
                    currentPage += 1;
                } else if ("Back".equals(nextPage)) {
                    currentPage -= 1;
                } else if ("Submit".equals(nextPage)) {
                    int score = 0;
                    boolean isPass = false;

                    for (int i = 0; i < answer.length; i++) {
                        if (answer[i] == questions.get(i).get(6).charAt(0)) {
                            score++;
                        }
                    }
                    for (int i = 0; i < answer.length; i++) {
                        trueAnswer[i] = questions.get(i).get(6).charAt(0);
                    }
                    if (score >= 6) {
                        isPass = true;
                    }
                    String userName = (String) oldSession.getAttribute("userName");

                    request.setAttribute("userName", userName);
                    request.setAttribute("score", score);
                    request.setAttribute("isPass", isPass);
                    request.setAttribute("answer", answer);
                    request.setAttribute("trueAnswer", trueAnswer);

                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for(char c: answer) {
                        sb.append(c);
                    }
                    for(char c: trueAnswer) {
                        sb2.append(c);
                    }

                    dao.addUserRecord(userName, sb.toString(), "C", sb2.toString(), String.valueOf(isPass));

                    request.getRequestDispatcher("result.jsp").forward(request, response);

                    return;
                } else {
                    currentPage = Integer.parseInt(nextPage) - 1;
                }
            }

            request.setAttribute("question", questions.get(currentPage).get(1));
            request.setAttribute("A", questions.get(currentPage).get(2));
            request.setAttribute("B", questions.get(currentPage).get(3));
            request.setAttribute("C", questions.get(currentPage).get(4));
            request.setAttribute("D", questions.get(currentPage).get(5));
            request.setAttribute("optionList", optionList);
            request.setAttribute("answer", answer);
            request.setAttribute("currentPage", currentPage);

            request.getRequestDispatcher("questionScreen.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
