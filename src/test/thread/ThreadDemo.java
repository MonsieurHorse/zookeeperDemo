package thread;

import org.junit.Test;

/**
 * Created by MHorse on 2016/9/17.
 */
public class ThreadDemo {

    @Test
    public void testMyThread(){
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }

    @Test
    public static void main(String[] args){
        MyThread my = new MyThread();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}
