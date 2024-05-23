package com.dong.web.service.impl;

import com.dong.constant.CommonConstant;
import com.dong.util.SessionUtils;
import com.dong.web.entity.Account;
import com.dong.web.model.LoginDTO;
import com.dong.web.model.UpdatePasswordDTO;
import com.dong.web.model.UserDetail;
import com.dong.web.service.LoginService;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.http.HttpSession;

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

    @Override
    public void updatePassword(UpdatePasswordDTO dto) {
        UserDetail userDetail = SessionUtils.getUserDetail();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Account account = session.get(Account.class, userDetail.getUserId());
            account.setPassword(dto.getNewPassword());
            session.update(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
