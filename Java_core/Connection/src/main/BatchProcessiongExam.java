package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchProcessiongExam {
    public static void main(String[] args) throws Exception {
        Connection con = null ;
        String sql = "insert into STUDENT_LM_THUY values(SQ_VIETHIEN.nextval , ? , ? )";
        try {
            con = ConnectionHelp.getConnection() ;
            PreparedStatement stm = con.prepareStatement(sql) ;
            int i = 0 ;

            while ( i< 10 ){
                String name = "Trần Văn " + i ;
                int age = i + 10 ;
                stm.setString(1 , name);
                stm.setInt( 2 , age );
                stm.addBatch();
                i++ ;
            }
            stm.executeBatch() ;

            ResultSet rs = stm.executeQuery("select count(*) from student_lm_thuy ") ;
            if( rs.next() ){
                System.out.println("tổng: " + rs.getInt(1));
            }
        }catch ( Exception e ){
            e.printStackTrace();
        }

    }
}
