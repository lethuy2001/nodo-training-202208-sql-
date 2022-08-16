package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
    public static List<student> filter( List<student> students , Filter<student> pred){
        List list = new ArrayList() ;
        for( student sv: students ){
            if( pred.valid(sv) ) list.add(sv);
        }
        return list ;
    }

    public static void main(String[] args) {
        List<student> students = new ArrayList<>() ;
        students.add( new student("Trần văn A" , 23 )  );
        students.add( new student("Trần văn B" , 16 )  );
        students.add( new student("Trần văn C" , 24 )  );

//        Filter<student> older = student -> student.getAge() >= 20 ;
//        List<student> filted = filter( students , older ) ;
//
//        for( student sv : filted ){
//            System.out.println(sv);
//        }
//        Collections.sort( students , (a , b ) -> b.getAge() - a.getAge() );
//        students.stream().filter( sv -> sv.getAge() >= 20 ).forEach( x -> System.out.println(x));
        Comparator<student> comparator = ( a , b ) ->  a.getAge() - b.getAge() ;
        students.stream().sorted(comparator)
                .forEach( sv -> System.out.println(sv) );
        System.out.println( "Tên sinh viên có tuổi lớn nhất: " + students.stream().max( comparator ).get());

        int sum = students.stream().mapToInt( student -> student.getAge() ).sum() ;
        System.out.println("Tổng số tuổi: " + sum );
    }
}
