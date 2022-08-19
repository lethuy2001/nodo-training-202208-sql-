package Thread;

public class PrintNumber2 implements Runnable {

    private Integer number = new Integer(1) ;

    @Override
    public void run() {
        Thread current = Thread.currentThread() ;
        synchronized (number) {
        while ( number < 15 ){
            number++ ;
            System.out.println(current.getName() + " number is " + number );
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }}
        System.out.println(current.getName() + " is stopped");
    }
}
