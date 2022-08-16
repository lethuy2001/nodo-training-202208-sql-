package enumExample;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArrayExam {
    public void streamArr( Integer[] da ){
        Arrays.sort( da , ( a , b ) -> b.compareTo(a) );

        Stream<Integer> stream = Arrays.stream(da) ;
//        stream.forEach( v -> System.out.println(v) );

        Consumer<Integer> c = v -> System.out.println(v) ;
        Predicate<Integer> p = v -> v >= 4 ;
        Optional<Integer> ma =   stream.filter(p).max( (a , b) -> a - b );
        System.out.println( "Giá trị lớn nhất là:  "  + ma.get());
    }

    public void ConcatenateStringTest( ){
        int max = 1000 ;
        StringBuilder builder = new StringBuilder() ;
        long start = System.currentTimeMillis() ;

        for( int i=0 ; i<max ; i++ ){
            builder.append(i) ;
        }

        System.out.println( "Time 1: " + ( System.currentTimeMillis() + start ));

        StringBuffer buffer = new StringBuffer() ;
         Long start_time = System.currentTimeMillis() ;
         for ( int i = 0 ; i<max ; i++ ){
             buffer.append( i) ;
         }
        System.out.println("Time2 = " + ( System.currentTimeMillis() - start));
        String text = "" ;
        start = System.currentTimeMillis() ;
        for( int i=0 ; i<max ; i++ ){
            text += i ;
        }
        Long end = System.currentTimeMillis() ;
        System.out.println("Time 3 = " + ( end - start));
    }

    public void IntStreamExam() {
        StringBuilder builder = new StringBuilder( );
        IntStream stream =  IntStream.range(0, 10 );
        stream.forEach( v -> {
            if( builder.length() > 0) builder.append(",");
            builder.append(v) ;
        });
        System.out.println("Text value = " + builder);
    }
}
