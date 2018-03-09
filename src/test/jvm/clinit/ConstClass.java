package jvm.clinit;

/**
 * Created by junbaoma on 2018/2/23.
 */
public class ConstClass {
    static
    {
        System.out.println("ConstClass init!");
    }
    public static  final String HELLOWORLD = "hello world";
}
