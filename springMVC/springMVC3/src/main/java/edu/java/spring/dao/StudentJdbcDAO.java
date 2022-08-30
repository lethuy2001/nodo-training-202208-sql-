package edu.java.spring.dao;

import edu.java.spring.controller.Student;
import org.apache.log4j.Logger;
import org.apache.log4j.jdbc.JDBCAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentJdbcDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    private String insertQuery ;
    private String updateAgeByNameSQL  ;
    private String deleteId ;

    @Autowired
    private PlatformTransactionManager transactionManager ;

    public StudentJdbcDAO(){
        transactionManager = new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
                return null;
            }

            @Override
            public void commit(TransactionStatus transactionStatus) throws TransactionException {

            }

            @Override
            public void rollback(TransactionStatus transactionStatus) throws TransactionException {

            }
        };
    }

    public void save( Object name , Object age ){
        TransactionDefinition def = new DefaultTransactionDefinition() ;
        TransactionStatus status = transactionManager.getTransaction(def) ;
        String countQuery = "Select count(*) from studentsv" ;

        try {
            int total = jdbcTemplate.queryForObject( countQuery , Integer.class) ;
            LOGGER.info( "Before save data, total record iss " + total );

            String sql = "insert into studentsv (name , age ) values( ? , ? )";
            jdbcTemplate.update(sql , name  , age );

            LOGGER.info("Affter save data, total record is " + total);


            transactionManager.commit(status);
        }catch ( Exception e ){
            transactionManager.rollback(status);
            int total = jdbcTemplate.queryForObject( countQuery , Integer.class) ;
            LOGGER.info("After rollback, total record iss " + total );
        }
    }

    public int[] add(List<Student> students ){
        List<Object[]> batch = new ArrayList<>() ;
        students.forEach( sv -> batch.add( new Object[] { sv.getName() , sv.getAge()} ));
        return jdbcTemplate.batchUpdate( insertQuery , batch );
    }

    public void deleteId( int id ){
        jdbcTemplate.update( deleteId , id ) ;
    }

    public void updateAgeByNameSQL( int age , String name  ){
        jdbcTemplate.update( updateAgeByNameSQL , age , name  ) ;
    }

    public int totalRecord( ){
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet rs = statement.executeQuery("select COUNT(*) from studentsv" );
                return rs.next() ? rs.getInt(1) : 0 ;
            }
        });
    }
    public void insert( String name , int age ){
        jdbcTemplate.update( insertQuery , name , age ) ;
        LOGGER.info("Create record name: " + name + " Age: " + age );
    }

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null, null, "studentsv", null);

        if (rs.next()) {
            LOGGER.info("Table student already exists !");
            return;
        }

        jdbcTemplate.execute("create table studentsv (\n" +
                "\tid   int primary key identity ,\n" +
                "\tname varchar(1000), \n" +
                "\tage  int\n" +
                ")");

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery ;
    }

    public void setUpdateAgeByNameSQL(String updateAgeByNameSQL) {
        this.updateAgeByNameSQL = updateAgeByNameSQL ;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId ;
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

    public List<Student> loadStudent(String name ){
        return  jdbcTemplate.query("Select * from studentsv where name like '%" + name + "%'" ,
                new StudentRowMapper() );
    }
}