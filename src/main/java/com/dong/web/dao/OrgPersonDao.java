package com.dong.web.dao;

import com.dong.web.entity.OrgPerson;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface OrgPersonDao extends GenericDAO<OrgPerson, String> {


    void deleteByOrgId(String orgId);

    void deleteByOrgIdAndPersonIdIn(String orgId, List<String> personIds);
}

class OrgPersonDaoImpl extends GenericDAOImpl<OrgPerson,String> implements OrgPersonDao {

    public OrgPersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void deleteByOrgId(String orgId) {

    }

    @Override
    public void deleteByOrgIdAndPersonIdIn(String orgId, List<String> personIds) {

    }
}
