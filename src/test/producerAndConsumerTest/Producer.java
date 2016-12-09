package producerAndConsumerTest;

/**
 * Created by MHorse on 2016/11/30.
 */
public class Producer extends Thread{
    private int number;
    private Godown godown = new Godown();
    public Producer(int number, Godown godown){
        this.number = number;
        this.godown = godown;
    }
    public void run(){
        godown.produce(number);
    }
}
