package jvm.initialization;

/**
 * Created by MHorse on 2016/10/17.
 */
public class SuperClass {
    static{
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}
