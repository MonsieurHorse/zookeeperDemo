package thread.test;

/**
 * Created by junbaoma on 2017/4/12.
 */
public class TestMultiThread {

    public static void main(String args[]){

        OneThread thread1 = new OneThread();

        long start = System.currentTimeMillis();
        for (int i = 0; i<1000; i++){
            thread1.run();
        }

        long end = System.currentTimeMillis();
        System.out.println("total: " + (end - start));
    }
}
