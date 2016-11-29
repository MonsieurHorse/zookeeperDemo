package syn;

/**
 * Created by MHorse on 2016/6/29.
 */
public class Consumer implements Runnable{
    private Info info = null ;
    public Consumer(Info info){
        this.info = info ;
    }
    public void run(){
        for(int i=0;i<10;i++){
            this.info.get() ;
        }
    }
}
