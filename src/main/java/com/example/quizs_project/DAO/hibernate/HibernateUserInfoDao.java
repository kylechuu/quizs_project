package com.example.quizs_project.DAO.hibernate;

import com.example.quizs_project.DAO.UserInfoDao;
import com.example.quizs_project.Entity.UserInfo;
import com.example.quizs_project.config.HibernateConfigUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateUserInfoDao implements UserInfoDao {
    public List<UserInfo> getAllUserInfo() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("SELECT u FROM UserInfo u");
            List<UserInfo> userInfo = query.getResultList();

            transaction.commit();
            return userInfo;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
