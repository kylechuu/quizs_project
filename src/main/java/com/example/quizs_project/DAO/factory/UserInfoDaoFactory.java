package com.example.quizs_project.DAO.factory;

import com.example.quizs_project.DAO.UserInfoDao;
import com.example.quizs_project.DAO.hibernate.HibernateUserInfoDao;

public class UserInfoDaoFactory {
    public static UserInfoDao getUserInfoDao(DaoType daoType) {
        switch(daoType) {
            case HIBERNATE:
                return new HibernateUserInfoDao();
            default:
                throw new UnsupportedOperationException("Dao type not supported.");
        }
    }
}