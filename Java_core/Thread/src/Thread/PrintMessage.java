package Thread;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class PrintMessage implements Runnable {

    private String mesage ;

    public PrintMessage( String param) {
        this.mesage = param ;
    }

    @Override
    public synchronized void run() {
        String[] element = mesage.split(" " );
        Arrays.stream(element).forEach( ee ->{
            System.out.println(Thread.currentThread().getName() + " Print " + ee );
            try {
//                TimeUnit.SECONDS.sleep(1);
                int k = (int) (Math.random()*3)*1000 ;
                Thread.sleep( k);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
