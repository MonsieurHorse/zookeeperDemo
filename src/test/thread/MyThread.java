package thread;

/**
 * Created by MHorse on 2016/9/17.
 */
public class MyThread extends Thread {
    private int ticket = 5;
    public void run(){
        for (int i=0;i<10;i++)
        {
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
