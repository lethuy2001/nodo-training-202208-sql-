package runnable;

public class RunnableTest {
    public void RunableTestExam(){
        //   Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println( Thread.currentThread().getName() + " say hello java class") ;
//            }
//        };
//        new Thread(runnable).start();

        Runnable runnable = ( ) -> {
            System.out.println( Thread.currentThread().getName() );
        };
        new Thread(runnable).start();
    }
}
