package Thread;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecuteServiceTest {
    public static void main(String[] args) throws Exception {
        PrintNumber number = new PrintNumber();
        Callable<Object> value = Executors.callable(number);
        System.out.println("Main say hello");
        value.call();
        System.out.println("main say goodbye");
        value.call();
    }
}
