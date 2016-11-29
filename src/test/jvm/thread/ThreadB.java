package jvm.thread;

import org.junit.Assert;

/**
 * Created by MHorse on 2016/10/21.
 */
public class ThreadB extends Thread{
    GetAndSet getAndSet = new GetAndSet();
    public void run(){
        for (int i =  0; i<100; i++){
            getAndSet.setValue(-1);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        System.out.println("-1: " + getAndSet.getValue());
            Assert.assertEquals("false", -1, getAndSet.getValue());
        }
    }
}
