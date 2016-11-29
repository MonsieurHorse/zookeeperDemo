package runnable;

/**
 * Created by MHorse on 2016/6/30.
 */
public class RunnableDemo {
    public static void main(String[] args){
        MyThread my = new MyThread();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}
