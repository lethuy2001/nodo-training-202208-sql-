package com.example.springsecurity_hibernate.dao.impl;

import com.example.springsecurity_hibernate.dao.GroupDao;
import com.example.springsecurity_hibernate.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;


@Component("dao")
public class GroupDaoImpl implements GroupDao {
    private final Logger logger = Logger.getLogger(GroupDaoImpl.class);
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean ;
    @Override
    public void insert(Group group) {
        System.out.println(sessionFactoryBean + " :Insert group " + group );
        Session session = sessionFactoryBean.getObject().openSession();

        try {
            session.getTransaction().begin();
            session.save(group) ;
            session.flush();
            logger.info("Save group " + group.getName() + " done!");
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Group> list() {
        Session session = sessionFactoryBean.getObject().openSession() ;
        Query query = session.createQuery("from Group");
        try {
            return (List<Group>) query.getResultList();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactoryBean.getObject().openSession() ;
        try {
            session.getTransaction().begin();
           Group group = session.get( Group.class , id ) ;
           if( group == null ) return ;
           session.delete(group) ;
           session.flush();
           logger.info("Delete group: " + group.getName() + " successfully");
           session.getTransaction().commit();
       }finally {
           session.close();
       }
    }

    @Override
    public void update(Group group) {
        Session session = sessionFactoryBean.getObject().openSession() ;
        try {
            session.getTransaction().begin();
            Group group1 = (Group) session.merge( group );
            session.merge(group) ;
            session.flush();
            session.getTransaction().commit();
            logger.info("Update group: " +  group1.getName() + " Successful");
        }finally {
            session.close();
        }
    }

    @Override
    public Group findById( int id ) {
        Session session = sessionFactoryBean.getObject().openSession() ;
        session.getTransaction().begin();
        Group group = session.find( Group.class , id ) ;
        session.flush();
        session.getTransaction().commit();
        session.close();
        return group ;
    }

    @Override
    public List<Group> listByName(String name) {
        Session session = sessionFactoryBean.getObject().openSession() ;
        if( name == null || name.length() < 1 ){
            Query query = session.createQuery("from Group ");
            return query.getResultList();
        }
//        Query query = session.createQuery("from Group where name like '%" + name + "%'");

        Query query = session.createQuery("from Group where name like :svName");
        query.setParameter("svName" , "%" + name + "%");
        return query.getResultList() ;
    }
}
