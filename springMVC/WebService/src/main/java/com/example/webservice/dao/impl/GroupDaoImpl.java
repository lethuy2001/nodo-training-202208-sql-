package com.example.webservice.dao.impl;

import com.example.webservice.dao.GroupDao;
import com.example.webservice.model.Group;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

@Component("groupDao")
public class GroupDaoImpl implements GroupDao {

    private LocalSessionFactoryBean sessionFactory ;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory( LocalSessionFactoryBean factory ){
        this.sessionFactory = factory ;
    }

    @Override
    public List<Group> list() {
        Session session = sessionFactory.getObject().openSession() ;
        try {
            Query query = session.createQuery("from Group ");
            return query.getResultList() ;
        }finally {
            session.close();
        }
    }
}
