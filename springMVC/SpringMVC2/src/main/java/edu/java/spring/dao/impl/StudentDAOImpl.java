package edu.java.spring.dao.impl;

import edu.java.spring.controller.Student;
import edu.java.spring.dao.StudentDAO;
import edu.java.spring.dao.StudentJdbcDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO , DisposableBean {

    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);
    DataSource dataSource ;
    JdbcTemplate jdbcTemplate ;
    String insertQuery ;
    String updateQuery ;
    String deleteById ;
    String findAll ;


    @Override
    public void insert(Student student) {
        jdbcTemplate.update( insertQuery ,
                            student.getName() , student.getAge() );
        LOGGER.info("Create record name = " + student.getName() );
    }

    @Override
    public List<Student> list() {
        return jdbcTemplate.query( findAll , new StudentRowMapper() ) ;
    }

    @Override
    public void DeleteById( int id ) {
        jdbcTemplate.update( deleteById , id ) ;
    }

    @Override
    public Student FindById(Integer id) {
        String sql = "select * from studentsv where id = " ;
        return jdbcTemplate.queryForObject( sql + id , new StudentRowMapper()) ;
    }

    @Override
    public void Update(Student student) {
        String sql = "update studentsv set name = ? , age = ? where id = ? " ;
        jdbcTemplate.update(sql , student.getName() , student.getAge() , student.getId() );
    }

    @Override
    public List<Student> findByName(String name) {
        String sql = "select * from studentsv where name like '%" + name + "%'" ;
        return jdbcTemplate.query( sql , new StudentRowMapper() ) ;
    }


    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery ;
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:");
    }

    public void setFindAll(String findAll) {
        this.findAll = findAll ;
    }

    public void setDeleteById(String deleteById) {
        this.deleteById = deleteById ;
    }

    private final static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                Student student = new Student() ;
                student.setId( resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge( resultSet.getInt("age"));
                return student ;
            }catch ( Exception e ){
                LOGGER.error(e );
                return null ;
            }
        }
    }
}
