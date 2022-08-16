package comparator;

import java.util.Arrays;

public class ComparatorSortExam {
    public static void main(String[] args) {
        Integer[] values = { 2,5 , 7,3,33, 9 , 10 } ;

        Arrays.sort( values , (a , b) -> b.compareTo(a) );


        for( Integer x : values ){
            System.out.println(x);
        }
    }
}
