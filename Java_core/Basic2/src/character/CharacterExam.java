package character;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterExam {
    public  int countDigit( String value ){
        int i=0 , count = 0 ;
        while ( i < value.length() ){
            char c = value.charAt(i) ;
            if( Character.isDigit(c) ){
                count++ ;
            }
            i++ ;
        }
        return count ;
    }

    public int countDigit2( String value ){
//      Cho phép ngăn chặn được giao thao luồng mà k cần đến đồng bộ hóa
        AtomicInteger count = new AtomicInteger(0) ;
        IntStream stream = value.chars();
        stream.forEach( c -> {
            if( Character.isDigit(c)) {
//              Hàm tăng giá trị nên một
                count.incrementAndGet() ;
            }
        });
        return count.get() ;
    }
}
