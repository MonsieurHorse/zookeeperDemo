package runnable;

/**
 * Created by MHorse on 2016/6/30.
 */
public class MyThread implements Runnable {
    private int ticket = 5;
    public void run(){
        for (int i=0;i<10;i++)
        {
            synchronized (this){

                if(ticket > 0){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ticket = " + ticket--);
                }
            }

        }
    }
}
