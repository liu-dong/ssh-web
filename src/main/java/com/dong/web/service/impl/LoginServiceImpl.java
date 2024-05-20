package com.dong.web.service.impl;

import com.dong.web.entity.Account;
import com.dong.web.model.UserDetail;
import com.dong.web.service.LoginService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author liudong 2024-05-20 09:57:41
 */
public class LoginServiceImpl implements LoginService {

    private SessionFactory sessionFactory;

    @Override
    public UserDetail login(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            // 这里的查询应该是根据用户名和密码查询，而不是硬编码的id
            Account account = (Account) session.createQuery("FROM Account WHERE username = :username")
                    .setParameter("username", username)
                    .uniqueResult();

            session.getTransaction().commit();

            if (account != null && account.getPassword().equals(password)) {

                return new UserDetail(account);
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
