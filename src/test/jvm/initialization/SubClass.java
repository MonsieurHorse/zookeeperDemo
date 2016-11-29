package jvm.initialization;

/**
 * Created by MHorse on 2016/10/17.
 */
public class SubClass extends SuperClass {
    static{
        System.out.println("SubClass init!");
    }
//    public static final int num = 321;
}
