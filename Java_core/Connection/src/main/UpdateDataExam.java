package main;

public class UpdateDataExam {
    public static void main(String[] args) throws Exception{
        String sql = "select * from student_lm_thuy" ;
        String update = "update student_lm_thuy set name = ? where id = ? " ;

        UltilsHeper.insert( update , "Nguyễn Viết Hiên" , 1);
        UltilsHeper.findAll(sql).forEach( sv -> {
            System.out.println(sv.toString());
        });
    }
}
