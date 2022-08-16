package enumExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class array {
    public void SortArray( Integer[] da) {
        System.out.println("Hàm trước khi sắp xếp");
        Arrays.stream(da).forEach( v -> System.out.println(v));

        Arrays.sort(da , ( a , b ) ->  b.compareTo(a) );

        System.out.println("Hàm sau khi sắp xếp");
        for( Integer x : da ){
            System.out.println(x);
        }
    }
}
