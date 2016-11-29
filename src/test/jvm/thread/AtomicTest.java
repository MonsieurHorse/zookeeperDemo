package jvm.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by MHorse on 2016/10/24.
 */
public class AtomicTest {
//    public static AtomicInteger race = new AtomicInteger(0);
    public static Integer integer = Integer.valueOf(0);
    public static void increase(){
//        race.incrementAndGet();
        integer++;
    }
    public static final int THREAD_COUNT = 20;

    public static void main(String[] args){
        Thread[] threads = new Thread[THREAD_COUNT];
        for (Thread thread :threads){
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<10000; i++){
                        increase();
                    }
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 1)
            Thread.yield();
//        System.out.println(race);
        System.out.println(integer);
    }
}
