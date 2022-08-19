package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPoolTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber() ;
        ExecutorService executor = Executors.newFixedThreadPool(2) ;
        IntStream.range(0, 6).forEach( i -> executor.submit(number));
    }
}
