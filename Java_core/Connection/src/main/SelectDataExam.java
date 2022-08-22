package main;

import java.util.List;

public class SelectDataExam {
    public static void main(String[] args) throws Exception{
        String sql = "select * from STUDENT_LM_THUY" ;
        String sql1 = "select * from STUDENT_LM_THUY where age > ? " ;

        List<student> listsv = UltilsHeper.findAll(sql ) ;

        listsv.forEach( sv -> {
            System.out.println(sv.toString() );
        });
    }
}
