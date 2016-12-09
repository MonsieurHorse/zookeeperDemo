package producerAndConsumerTest;

/**
 * Created by MHorse on 2016/11/30.
 */
public class Godown {

    public static Integer maxNum = 100;
    public int current;
    public Godown(){};
    public Godown(int current){
        this.current = current;
    }

    public synchronized void produce(int number){
        while (number + current > maxNum){
            System.out.println(number +"超过了，wait"+ current);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        current += number;
        System.out.println("生产： " + number + " 库存： " + current);
        notifyAll();
    }

    public synchronized void consume(int number){
        while (current < number){
            System.out.println(number + "库存不够： " + current);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        current -= number;
        System.out.println("消费: " + number + " 库存： " + current);
        notifyAll();
    }


}
