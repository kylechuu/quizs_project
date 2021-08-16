//package com.example.quizs_project.DAO;
//
//import com.example.quizs_project.Entity.FeedBack;
//import com.example.quizs_project.config.MySqlDS;
//import com.example.quizs_project.Entity.UserInfo;
//import com.example.quizs_project.Entity.Record;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DAO {
//    private DataSource ds;
//    private Connection conn;

//    private static final String SELECT_ALL_USERS = "SELECT * FROM Accounts;";
//    private static final String SELECT_ALL_RECORDS = "SELECT * FROM Record;";
//    private static final String SELECT_ALL_FEEDBACK = "SELECT * FROM FeedBack;";
//    private static final String INSERT_USERS = "INSERT INTO Accounts(`UserName`, `PassWords`) VALUES (?, ?);";
//    private static final String INSERT_FEEDBACK = "INSERT INTO FeedBack(`UserName`, `Message`, `Rates`) VALUES (?, ?, ?);";
//    private static final String INSERT_Records = "INSERT INTO Record(`UserName`, `Questions`, `QuestionType`, `Answers`, `PassOrNot`) VALUES (?, ?, ?, ?, ?);";
//    private static final String GET_QUESTIONS_WITH_TYPE = "SELECT * FROM C_Question;";
//
//    private PreparedStatement getAllUserAccount;
//    private PreparedStatement getQuestionWithType;
//    private PreparedStatement getAllUserRecords;
//    private PreparedStatement getAllUserFeedback;
//    private PreparedStatement insertUserInfo;
//    private PreparedStatement insertRecords;
//    private PreparedStatement insertFeedBack;
//
//    public DAO() {
//        this.ds = MySqlDS.getDs();
//    }

//    public List<UserInfo> getAllUserInfo() {
//        List<UserInfo> userInfos = new ArrayList<>();
//
//        try {
//            this.conn = ds.getConnection();
//            this.getAllUserAccount = conn.prepareStatement(SELECT_ALL_USERS);
//
//            ResultSet rs = getAllUserAccount.executeQuery(SELECT_ALL_USERS);
//            while (rs.next()) {
//                UserInfo userInfo = new UserInfo.UserInfoBuilder()
//                        .setUserName(rs.getString("UserName"))
//                        .setPassWords(rs.getString("PassWords"))
//                        .build();
//
//                userInfos.add(userInfo);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            try {
//                if (getAllUserAccount != null) getAllUserAccount.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return userInfos;
//    }

//    public List<Record> getUserRecord() {
//        List<Record> userRecords = new ArrayList<>();
//
//        try {
//            this.conn = ds.getConnection();
//            this.getAllUserRecords = conn.prepareStatement(SELECT_ALL_RECORDS);
//
//            ResultSet rs = getAllUserRecords.executeQuery(SELECT_ALL_RECORDS);
//            while (rs.next()) {
//                Record record = new Record.RecordBuilder()
//                        .setIndexs(rs.getString("Indexs"))
//                        .setUserName(rs.getString("UserName"))
//                        .setQuestions(rs.getString("Questions"))
//                        .setQuestionType(rs.getString("QuestionType"))
//                        .setAnswers(rs.getString("Answers"))
//                        .setPassOrNot(rs.getString("PassOrNot"))
//                        .build();
//
//                userRecords.add(record);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            try {
//                if (getAllUserRecords != null) getAllUserRecords.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return userRecords;
//    }
//
//    public List<FeedBack> getFeedBack() {
//        List<FeedBack> userFeedback = new ArrayList<>();
//
//        try {
//            this.conn = ds.getConnection();
//            this.getAllUserFeedback = conn.prepareStatement(SELECT_ALL_FEEDBACK);
//
//            ResultSet rs = getAllUserFeedback.executeQuery(SELECT_ALL_FEEDBACK);
//            while (rs.next()) {
//                FeedBack feedBack = new FeedBack.FeedBackBuilder()
//                        .setFeedBackId(rs.getString("FeedBackId"))
//                        .setUserName(rs.getString("UserName"))
//                        .setMessage(rs.getString("Message"))
//                        .setRates(rs.getString("Rates"))
//                        .build();
//
//                userFeedback.add(feedBack);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            try {
//                if (getAllUserFeedback != null) getAllUserFeedback.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return userFeedback;
//    }

//    public void addUserInfo(String userName, String passWords) {
//        try {
//            this.conn = ds.getConnection();
//            this.insertUserInfo = conn.prepareStatement(INSERT_USERS);
//
//            insertUserInfo.setString(1, userName);
//            insertUserInfo.setString(2, passWords);
//            insertUserInfo.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (insertUserInfo != null) insertUserInfo.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void addUserRecord(String userName, String questions, String questionType, String answer, String isPass) {
//        try {
//            this.conn = ds.getConnection();
//            this.insertRecords = conn.prepareStatement(INSERT_Records);
//
//            insertRecords.setString(1, userName);
//            insertRecords.setString(2, questions);
//            insertRecords.setString(3, questionType);
//            insertRecords.setString(4, answer);
//            insertRecords.setString(5, isPass);
//            insertRecords.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (insertRecords != null) insertRecords.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void addFeedBack(String userName, String Message, String Rates) {
//        try {
//            this.conn = ds.getConnection();
//            this.insertFeedBack = conn.prepareStatement(INSERT_FEEDBACK);
//
//            insertFeedBack.setString(1, userName);
//            insertFeedBack.setString(2, Message);
//            insertFeedBack.setString(3, Rates);
//            insertFeedBack.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (insertFeedBack != null) insertFeedBack.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public boolean checkCredentials(List<UserInfo> userInfo, String name, String password) {
//        if(name == null || password == null) return false;
//
//        for(UserInfo u: userInfo) {
//            if (u.getUserName().equals(name) && u.getPasswords().equals(password)) return true;
//        }
//
//        return false;
//    }
//
//    public List<List<String>> getQuizQuestions() {
//        List<List<String>> questions = new ArrayList<>();
//
//        try {
//            this.conn = ds.getConnection();
//            this.getQuestionWithType = conn.prepareCall(GET_QUESTIONS_WITH_TYPE);
//
//            ResultSet rs = getQuestionWithType.executeQuery();
//
//            while (rs.next()) {
//                List<String> question = new ArrayList<>();
//                question.add(rs.getString("Id"));
//                question.add(rs.getString("QuestionDescription"));
//                question.add(rs.getString("A"));
//                question.add(rs.getString("B"));
//                question.add(rs.getString("C"));
//                question.add(rs.getString("D"));
//                question.add(rs.getString("Answer"));
//                questions.add(question);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (getQuestionWithType != null) getQuestionWithType.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return questions;
//    }
//}


