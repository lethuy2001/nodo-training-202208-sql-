package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFunction {


    public static void getAge( String name , int[] ages ) throws Exception {
        try (Connection con = ConnectionHelp.getConnection() ;
             Statement stm = con.createStatement() ;
        ){
            String sk = "%" + name + "%" ;
            ResultSet rs = stm.executeQuery("select max(age) from student_lm_thuy" +
                    " where name like '" + sk + "'");
            ages[0] = rs.next() ? rs.getInt(1) : -1 ;
        }
    }

    public static void main(String[] args) throws Exception {
         int[] ages = new int[1] ;
         getAge("A" , ages );
        System.out.println(ages[0]);
    }
}
