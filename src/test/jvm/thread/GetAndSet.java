package jvm.thread;

/**
 * Created by MHorse on 2016/10/21.
 */
public class GetAndSet {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args){
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        new Thread(threadA).start();
        new Thread(threadB).start();
    }
}
