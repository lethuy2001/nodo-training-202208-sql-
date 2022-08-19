package Thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExam {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ReadWriteLock lock = new ReentrantReadWriteLock() ;
        Map<String , String> map = new HashMap<>() ;

        executor.submit( () -> {
            System.out.println("Start writing");
            lock.writeLock().lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                map.put("foo" , "bar");
            } catch ( Exception e ){
                e.printStackTrace();
            }
            finally {
                lock.writeLock().unlock();
                System.out.println("End Writing");
            }
        });

        Runnable readTask = () -> {
            System.out.println("start reading");
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
            }finally {
                lock.readLock().unlock();
                System.out.println("end reading");
            }
        };

        executor.submit(readTask) ;
        executor.submit(readTask);
    }
}
