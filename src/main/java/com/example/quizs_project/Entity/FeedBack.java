package com.example.quizs_project.Entity;

public class FeedBack {
    private String FeedBackId;
    private String UserName;
    private String Message;
    private String Rates;

    FeedBack(String FeedBackId, String UserName, String Message, String Rates){
        this.FeedBackId = FeedBackId;
        this.UserName = UserName;
        this.Message = Message;
        this.Rates = Rates;
    }

    public String getUserName() {
        return UserName;
    }

    @Override
    public String toString() {
        return String.format("FeedBackId: %s  User name: %s  User Message: %s  Rates: %s",
                FeedBackId, UserName, Message, Rates);
    }

    public static class FeedBackBuilder {
        private String FeedBackId;
        private String UserName;
        private String Message;
        private String Rates;

        public FeedBackBuilder setFeedBackId (String FeedBackId) {
            this.FeedBackId = FeedBackId;
            return this;
        }

        public FeedBackBuilder setUserName (String UserName) {
            this.UserName = UserName;
            return this;
        }

        public FeedBackBuilder setMessage (String Message) {
            this.Message = Message;
            return this;
        }

        public FeedBackBuilder setRates (String Rates) {
            this.Rates = Rates;
            return this;
        }

        public FeedBack build() {
            return new FeedBack(FeedBackId, UserName, Message, Rates);
        }

    }
}
