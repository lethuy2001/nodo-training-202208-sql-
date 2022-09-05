package com.example.webservice.dao.impl;

import com.example.webservice.dao.UserDao;
import com.example.webservice.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    private final static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private LocalSessionFactoryBean sessionFactory ;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory( LocalSessionFactoryBean factory ){
        this.sessionFactory = factory ;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getObject().openSession() ;
        try{
            Query query = session.createQuery("from User order by age desc ");
            return query.getResultList() ;
        }finally {
            session.close();
        }
    }

    @Override
    public String insert(User user){
        Session session = sessionFactory.getObject().openSession();
        try{
            session.getTransaction().begin();
            Serializable value = session.save(user );
            session.flush();
            session.getTransaction().commit();
            return value.toString() ;
        }finally {
            session.close();
        }
    }

    @Override
    public User getByName(String username) {
        try(Session session = sessionFactory.getObject().openSession()  ){
            return session.get( User.class , username ) ;
        }
    }

    @Override
    public void delete(String name) {
        try( Session session = sessionFactory.getObject().openSession() ){
            session.getTransaction().begin();
            User user = session.get(User.class , name ) ;
            if( user != null ){
                session.delete(user);
            }
            session.flush();
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User user) {
        try ( Session session = sessionFactory.getObject().openSession() ){
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        }
    }
}
