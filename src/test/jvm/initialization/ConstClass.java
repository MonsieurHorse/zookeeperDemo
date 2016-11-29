package jvm.initialization;

/**
 * Created by MHorse on 2016/10/17.
 */
public class ConstClass {
    static{
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}
