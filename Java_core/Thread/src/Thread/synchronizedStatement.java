package Thread;

public class synchronizedStatement {
    public static void main(String[] args) {
        PrintNumber2 number2 = new PrintNumber2() ;
        Thread thread =  new Thread(number2) ;
        thread.setName("FSoft_Thread 1");
        thread.start();

        Thread thread1 = new Thread(number2);
        thread1.setName("FSoft_Thread 2");
        thread1.start();
    }
}
