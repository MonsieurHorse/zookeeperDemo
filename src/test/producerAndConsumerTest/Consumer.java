package producerAndConsumerTest;

import com.sun.org.apache.bcel.internal.generic.GOTO;

/**
 * Created by MHorse on 2016/11/30.
 */
public class Consumer extends Thread{
    private int number;
    private Godown godown = new Godown();
    public Consumer(int number, Godown godown){
        this.number = number;
        this.godown = godown;
    }
    public void run(){
        godown.consume(number);
    }
}
