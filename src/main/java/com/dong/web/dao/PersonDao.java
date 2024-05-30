package com.dong.web.dao;

import com.dong.web.entity.Person;
import org.hibernate.SessionFactory;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface PersonDao extends GenericDAO<Person, String> {


}

class PersonDaoImpl extends GenericDAOImpl<Person,String> implements PersonDao {

    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
