package com.dong.web.action;

import com.dong.web.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author liudong 2024-05-14 16:52:28
 */
public class HelloAction {

    private String username = "世界";

    public String hello() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Account account = session.get(Account.class, "0b968dab73fb443fa8e65f402a47583d");
        System.out.println("id=6的产品名称是: " + account.getUsername());
        username = account.getUsername();
        session.getTransaction().commit();
        session.close();
        factory.close();

        return "hello";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
