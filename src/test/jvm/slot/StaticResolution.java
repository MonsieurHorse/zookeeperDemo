package jvm.slot;

/**
 * Created by MHorse on 2016/10/19.
 */
public class StaticResolution {
    public static void sayHello(){
        System.out.println("hello world");
    }
    public static void main(String[] args){
        StaticResolution.sayHello();
        sayHello();
    }
}
