package Thread;

public class PrintNumber implements Runnable{
    private int number = 1 ;
    private boolean alive = true ;

    public int getNumber( ){
        return number ;
    }

    public void setAlive( boolean alive ){
        this.alive = alive ;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread() ;
        while ( true ){
            number++ ;
            System.out.println( current.getName() + " number is " + number );
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if( number % 10 == 0 ) break;
        }
        System.out.println( current.getName() + " is stoped");
    }
}
