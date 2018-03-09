package jvm.clinit;

/**
 * Created by junbaoma on 2018/2/23.
 */
public class NotInitialization extends ConstClass{
    public static void main(String[] args)
    {
        System.out.println(HELLOWORLD);
        System.out.println(ConstClass.HELLOWORLD);
    }
}
