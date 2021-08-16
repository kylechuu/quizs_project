package com.example.quizs_project.Entity;

public class Record {
    private String Indexs;
    private String UserName;
    private String Questions;
    private String QuestionType;
    private String Answers;
    private String PassOrNot;

    public Record(String Indexs, String UserName, String Questions, String QuestionType, String Answer, String PassOrNot) {
        this.Indexs = Indexs;
        this.UserName = UserName;
        this.Questions = Questions;
        this.QuestionType = QuestionType;
        this.Answers = Answer;
        this.PassOrNot = PassOrNot;
    }

    public String getUserName() {
        return UserName;
    }

    @Override
    public String toString() {
        return String.format("User name: %s  User answer: %s  Question type: %s  Question answer: %s  Pass: %s",
                UserName, Questions, QuestionType, Answers, PassOrNot);
    }

    public static class RecordBuilder {
        private String Indexs;
        private String UserName;
        private String Questions;
        private String QuestionType;
        private String Answers;
        private String PassOrNot;

        public RecordBuilder setIndexs (String Indexs) {
            this.Indexs = Indexs;
            return this;
        }

        public RecordBuilder setUserName (String UserName) {
            this.UserName = UserName;
            return this;
        }

        public RecordBuilder setQuestions (String Questions) {
            this.Questions = Questions;
            return this;
        }

        public RecordBuilder setQuestionType (String QuestionType) {
            this.QuestionType = QuestionType;
            return this;
        }

        public RecordBuilder setAnswers (String Answers) {
            this.Answers = Answers;
            return this;
        }

        public RecordBuilder setPassOrNot (String PassOrNot) {
            this.PassOrNot = PassOrNot;
            return this;
        }

        public Record build() {
            return new Record(Indexs, UserName, Questions, QuestionType, Answers, PassOrNot);
        }
    }
}


