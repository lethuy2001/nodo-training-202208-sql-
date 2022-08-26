import edu.java.spring.Student;
import edu.java.spring.StudentJdbcDAO;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        Logger logger = Logger.getLogger(JdbcApp.class);
////        logger.info(" create bean " + jdbc );
//        jdbc.insert( "Cao Cao" , 29 ) ;
//        jdbc.insert( "Ta Ka Ta" , 16 ) ;
//        jdbc.insert( "Sao Sao" , 35 ) ;
//        jdbc.insert( "Tanaka" , 29 ) ;

//        logger.info("Total students is " + jdbc.totalRecord() );
//        jdbc.deleteId(2);
//        List<Student> students = new ArrayList<>() ;
//        students.add( new Student( "CCC" , 2));
//        students.add( new Student( "AAA" , 44));
//        students.add( new Student("BBB" , 56));
//        int[] values = jdbc.add(students) ;
//
//        for( int i=0 ; i<values.length ; i++ ){
//            logger.info("add record " + i + ": " + (values[i] == 0 ? "failed" : "Success"));
//        }

        jdbc.save( "nnnn" , "99");

        jdbc.loadStudent("").forEach( x -> {
            logger.info(x);
        });
    }
}
