package thread.callable;

/**
 * Created by junbaoma on 2018/1/29.
 */
public class RunnableDemo implements Runnable {
    private int i;
    public void run(){
        for(; i<100 ;i++){
            //当线程类实现Runnable接口时，只能通过Thread.currentThread()方法获得当前线程
            System.out.println(Thread.currentThread().getName() +" "+ i);
        }
    }
    public static void main(String[] args) {
        for(int i = 0 ;i<100; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                ThreadDemo td = new ThreadDemo();
                //创建两个Thread对象，并且均把Runnable接口实例对象作为target
                new Thread(td).start();
                new Thread(td).start();
            }
        }

    }
}
