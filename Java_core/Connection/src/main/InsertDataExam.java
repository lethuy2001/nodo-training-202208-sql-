package main;

public class InsertDataExam {
    public static void main(String[] args) throws Exception{
        String sql = "insert into student_LM_THUY values ( SQ_VIETHIEN.nextval , 'Trần Văn B' , 20) " ;
        String sql1 = "insert into student_LM_THUY values ( SQ_VIETHIEN.nextval , 'Trần Văn A' , 21) " ;
        String sql2 = "insert into student_LM_THUY values (SQ_VIETHIEN.nextval ,  'Trần Văn C' , 16) " ;

       UltilsHeper.insert(sql) ;
        UltilsHeper.insert(sql1);
        UltilsHeper.insert(sql2);
    }
}
