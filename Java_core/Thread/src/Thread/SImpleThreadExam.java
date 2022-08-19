package Thread;

import java.util.Arrays;

public class SImpleThreadExam {
    public static void main(String[] args) throws Exception{
        int[] arr = { 2, 5  ,6 ,88 ,9 ,55 ,3 } ;
        new Thread( () -> {
            Arrays.stream(arr).forEach( a ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(a);
            });
        }).start();
    }
}
