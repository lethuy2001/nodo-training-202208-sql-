package main;

import java.util.List;
import java.util.stream.IntStream;

public class DataAccessTest {
    public static void main(String[] args) throws Exception {
        DataAccessLogic data = new DataAccessLogic();
        List<String> names = data.loadNames(0);
        names.forEach(System.out::println);
        System.out.println("Total page: " + data.numberOfPage() );

        IntStream.range( 1 , data.numberOfPage() + 1 ).forEach( page -> {
            System.out.println("=========" + page );
//            names = data.loadNames(page) ;
        });
    }
}
