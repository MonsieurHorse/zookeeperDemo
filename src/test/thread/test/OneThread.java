package thread.test;

/**
 * Created by junbaoma on 2017/4/12.
 */
public class OneThread implements Runnable {

    public void run(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("period: " + (end - start));
    }
}
