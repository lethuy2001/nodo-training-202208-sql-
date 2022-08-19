package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FeatureExamTest {
    public static void main(String[] args) throws Exception {
        CallableSample callableSample = new CallableSample();
        ExecutorService executors = Executors.newFixedThreadPool(1) ;
        Future<Integer> future = executors.submit(callableSample);

        System.out.println("Future Done ?" + future.isDone() );
//        Integer result = future.get() ;
        Integer result = future.get( 3 , TimeUnit.SECONDS) ;
        System.out.println("Future Done ? "  + future.isDone() + " -result = " + result);
    }
}
