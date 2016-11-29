package jvm;

import java.io.PrintStream;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MHorse on 2016/10/17.
 */
public class Test {

    @org.junit.Test
    public void test(){
       /* static{
            i = 0;
            System.out.println(i);
        }
        static int i = 1;*/
//        PrintStream printStream = new PrintStream();

        Integer integer = 1;
        integer.intValue();
        integer.toString();
        System.out.println(integer);
        AtomicLong atomicLong;
        AtomicInteger atomicInteger;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abv");
        stringBuilder.append(new String());
        System.out.println(stringBuilder.toString());
    }
}
