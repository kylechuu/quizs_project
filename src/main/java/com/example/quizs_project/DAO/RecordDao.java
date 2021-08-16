package com.example.quizs_project.DAO;

import com.example.quizs_project.Entity.Record;

import java.util.List;

public interface RecordDao {
    List<Record> getUserRecord();

    void addUserRecord(String userName, String questions, String questionType, String answer, String isPass);
}
