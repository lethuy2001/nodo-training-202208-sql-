package com.example.springsecurity_hibernate.context;

import org.apache.log4j.Logger;
import org.hibernate.boot.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);

    @Autowired
    private DataSource dataSource ;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        LOGGER.info(" context start application " + dataSource );
        try {
            createTable("HN_GROUP" , "create table HN_GROUP( " +
                    " id int primary key identity , " +
                    " name varchar(100)  )");
            createTable("HN_USER" , "create table HN_USER( " +
                       " username varchar(100) primary key ," +
                               "password varchar(100) , " +
                               "email varchar(100) ," +
                               "age int , " +
                               "groupId int , " +
                               "foreign key (groupId) references HN_GROUP (id) )");
        }catch ( Exception e ){
            LOGGER.error( e , e );
        }
    }

    public void createTable( String name , String script ) throws SQLException {
         DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();

        ResultSet rs = dbmd.getTables( null , null , name , null );
        if( rs.next() ){
            LOGGER.info(" Table " + rs.getString("TABLE_NAME") + " already exists!");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script) ;
    }
}
