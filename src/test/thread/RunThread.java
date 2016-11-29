package thread;

/**
 * Created by MHorse on 2016/9/17.
 */
public class RunThread implements Runnable {
    private int ticket = 5;
    public void run(){
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}
