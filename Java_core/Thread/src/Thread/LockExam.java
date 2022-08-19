package Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockExam {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newWorkStealingPool(4);
        CallableSample sample = new CallableSample() ;
        List callables = Arrays.asList( sample , sample ,sample );

        executor.invokeAll(callables) ;
    }
}
