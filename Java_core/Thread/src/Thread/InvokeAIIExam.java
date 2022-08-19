package Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class InvokeAIIExam {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newWorkStealingPool() ;
        List callables = Arrays.asList(
                new CallableSample() , new CallableSample() , new CallableSample()
        );

        Stream stream = executor.invokeAll(callables).stream();
//        Stream stream = executor.invokeAny(callables).stream();
        Stream resultStream = stream.map( f -> {
           return f.getClass() ;
        });
        Object[] results = resultStream.toArray(Integer[]::new) ;
        Arrays.stream(results).forEach(System.out::println);

    }
}
