package com.example.quizs_project.Entity;

import javax.persistence.*;

@Entity
@Table(name="Accounts")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_name")
    private String userName;

    @Column(name = "passwords")
    private String password;

    public UserInfo(String UserName, String Passwords) {
        this.userName = UserName;
        this.password = Passwords;
    }

    @Override
    public String toString() {
        return String.format("User name: %s  User password: %s", userName, password);
    }

    public void setUserName(String UserName) { this.userName = UserName;}

    public void setPasswords(String PassWords) { this.password = PassWords;}

    public String getUserName() {
        return userName;
    }

    public String getPasswords() {
        return password;
    }

//    public static class UserInfoBuilder {
//        private String UserName;
//        private String Passwords;
//
//        public UserInfoBuilder setUserName (String UserName) {
//            this.UserName = UserName;
//            return this;
//        }
//
//        public UserInfoBuilder setPassWords (String Passwords) {
//            this.Passwords = Passwords;
//            return this;
//        }
//
//        public UserInfo build() {
//            return new UserInfo(UserName, Passwords);
//        }
//    }
}

