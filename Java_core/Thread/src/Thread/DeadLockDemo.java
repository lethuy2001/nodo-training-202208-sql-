package Thread;

public class DeadLockDemo extends Thread{

    private Object lock1 ;
    private Object lock2 ;

    public DeadLockDemo ( Object lock1 ,Object lock2 ){
        this.lock1 = lock1 ;
        this.lock2 = lock2 ;
    }

    public synchronized void run( Object run ){
        System.out.println(Thread.currentThread().getName() + " Holding " + lock1 );
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "-------->" + lock2 + lock1);
    }

    public static void main(String[] args) {
        Object obj1 = new Object() ;
        Object obj2 = new Object() ;

        Thread thread1 = new DeadLockDemo( obj1 , obj2 );
        Thread thread2 = new DeadLockDemo( obj1 , obj2 );

        thread1.start();
        thread2.start();

    }
}
