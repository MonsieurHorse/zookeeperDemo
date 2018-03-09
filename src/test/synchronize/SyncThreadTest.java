package synchronize;

/**
 * Created by junbaoma on 2018/1/29.
 */
public class SyncThreadTest {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
