package com.example.springsecurity_hibernate.dao.impl;

import com.example.springsecurity_hibernate.dao.UserDao;
import com.example.springsecurity_hibernate.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component("UserDao")
public class UserDaoImpl implements UserDao {

    private final Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    LocalSessionFactoryBean sessionFactory ;

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        session.getTransaction().begin();
        session.save(user);
        session.flush();
        session.getTransaction().commit();
        session.close();
        logger.info("Insert to successful");
    }

    @Override
    public List<User> list(Integer id) {
        Session session = sessionFactory.getObject().openSession();
        Query query = session.createQuery("from User ");
        return null ;
    }

    @Override
    public void delele(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> listUserByGroup( int groupId ) {
        Session session = sessionFactory.getObject().openSession();
        try {
            if( groupId < 0 ){
                Query query = session.createQuery("from User ");
                return query.getResultList() ;
            }

            Query query = session.createQuery("from User where groupId = " + groupId);
            return query.getResultList() ;
        }finally {
            session.close();
        }
    }
}
