package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstExam {

    public static void main(String[] args) throws SQLException {
        String sql = " create table student_LM_THUY (" +
                     " id int primary key ," +
                     " name varchar2(1000) ," +
                     " age int default 20 )" ;
        try ( Connection con = ConnectionHelp.getConnection() ;
              Statement stm = con.createStatement() ;
        ){
             boolean sk = stm.execute(sql) ;
            System.out.println(sk);
        }
    }
}
