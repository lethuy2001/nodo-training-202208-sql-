package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String[] args) {
//        List<student> students = new ArrayList<>( );
//
//        Consumer<student> c = student -> {
//            if( student.getAge() > 23 )
//                student.setAge(23);
//            students.add(student);
//        };
//        c.accept( new student( "Nguyễn Văn A" , 35 ));
//        c.accept( new student( "Nguyễn Văn B" , 20 ));
//
//        for( student sv : students ){
//            System.out.println(sv);
//        }

//          Func();
        FuncTest();
    }

    public static void Func( ){
        String[] names = {"Trần Văn A" , "Trần Văn B" , "Hiên Cứt trâu" , "Lê Minh Thụy" } ;
        int[] ages = { 23 , 20 , 30 , 45 } ;
        IntStream intStream = IntStream.rangeClosed( 0 , names.length - 1 );
        Stream stream = intStream.mapToObj( value -> new student( names[value] , ages[value] )) ;

        Consumer<student> c = a -> System.out.println(a) ;
        stream.forEach(c);
    }

    public static void FuncTest( ){
        String[] names = {"Trần Văn A" , "Trần Văn B" , "Hiên Cứt trâu" , "Lê Minh Thụy" } ;
        int[] ages = { 23 , 20 , 30 , 45 } ;
        IntStream intStream = IntStream.rangeClosed( 0 , names.length - 1 );
        Stream stream = intStream.mapToObj( value -> new student( names[value] , ages[value] )) ;

        Function<student, String > jsonToFunction = student ->  {
            StringBuilder builder = new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid: ").append(student.getId()).append("\n") ;
            builder.append("\tname: ").append(student.getName()).append("\n") ;
            builder.append("\tage: ").append(student.getAge()).append("\n") ;
            builder.append("}");
            return builder.toString() ;
        } ;

         Consumer<student> c = student -> {
            System.out.println(jsonToFunction.apply(student));
        };

//        stream.forEach(c);

        Predicate<student> predicate = student ->  student.getAge() > 25 ;
        Stream<student> older = stream.filter(predicate) ;
        older.forEach(c);
    }
}
