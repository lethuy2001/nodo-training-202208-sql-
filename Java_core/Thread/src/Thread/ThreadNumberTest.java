package Thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) throws Exception {
        PrintNumber printNumber = new PrintNumber() ;

        Thread thread = new Thread(printNumber) ;
        thread.setName("Hanoi_Thread");
        thread.setDaemon(true);
        thread.start();

        Thread.currentThread().join();

        while ( thread.isAlive() ){
            if( printNumber.getNumber() % 10 == 0 ){
                printNumber.setAlive(false);
                TimeUnit.SECONDS.sleep(1);
            }
        }

        System.out.println("Main thread say hello ");
        System.out.println("Main thread say goodbye");
    }
}
