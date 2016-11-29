package jvm.thread;

import java.util.Vector;

/**
 * Created by MHorse on 2016/10/24.
 */
public class VectorThread {

    public static Vector<Integer> integerVector = new Vector<Integer>();

    public static void main(String[] args){
        try {


        while (true){
            for (int i = 0; i <1000; i++){
                integerVector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i= 0; i<integerVector.size(); i++){
                        integerVector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<integerVector.size(); i++){
                        System.out.println(integerVector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 20);
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Thread.yield();
            Thread.yield();
        }
    }
}
