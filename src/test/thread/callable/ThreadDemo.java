package thread.callable;

/**
 * Created by junbaoma on 2018/1/29.
 */
public class ThreadDemo extends Thread{
    private int i;
    public void run(){
        for(; i<100 ;i++){
            System.out.println(getName() +" "+ i);
        }
    }
    public static void main(String[] args) {
        for(int i = 0 ;i<100; i++){
            //currentThread是Thread类的静态方法，该方法返回当前正在执行的线程对象
            //getName()返回当前线程对象的名字
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                //启动两个线程，但是实际上有三个线程，即main主线程
                //用户启动的多个线程的名字依次为Thread-0、Thread-1、、、、
                new ThreadDemo().start();
                new ThreadDemo().start();
            }
        }

    }
}
