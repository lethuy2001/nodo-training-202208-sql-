package Thread;

public class ThreadTest {
    public static void main(String[] args) {
//        synchronized: chạy lần lượt các thread
        new Thread( new PrintMessage("Say hello to everyone")).start(); ;
        new Thread( new PrintMessage("Ta là siêu nhân")).start();
    }
}
