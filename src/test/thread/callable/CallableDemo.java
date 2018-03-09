package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by junbaoma on 2018/1/29.
 */
public class CallableDemo implements Callable<Integer> {
    //实现call()方法，作为线程执行体
    public Integer call(){
        int i = 5;
        for( ; i<100 ; i++){
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" +i);
        }
        //call()方法可以有返回值
        return i;
    }
    public static void main(String[] args) {
        //创建Callable对象
        CallableDemo cd = new CallableDemo();
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>(cd);
        for(int i=0 ; i<100 ; i++){
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" +i);
            if(i==20){
                //实质还是以Callable对象来创建并启动线程
                new Thread(task,"有返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程的返回值" + task.get());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
