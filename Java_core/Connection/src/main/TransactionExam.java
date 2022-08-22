package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionExam {
    public static void main(String[] args) throws Exception {
        List<Integer> lists = Arrays.asList( 1 ,5 ,6 ,8, 9 , 3 ) ;
        String sql = "insert into student_lm_thuy( id , name ,age ) values ( SQ_VIETHIEN.nextval , ? , ? ) " ;
        String sql1 = "select * from student_lm_thuy" ;

        UltilsHeper.insertAll( sql , lists );

        UltilsHeper.findAll( sql1 ).forEach( sv -> {
            System.out.println(sv.toString());
        });
    }
}
