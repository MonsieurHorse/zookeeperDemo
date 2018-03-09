package interview.pattern;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * Created by MHorse on 2016/11/29.
 */
public class Test {

    @org.junit.Test
    public void test(){
        /*SingletonSafe singletonSafe = SingletonSafe.getSingletonSafe();
        singletonSafe.print();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("", "");
        HashMap hashMap = new HashMap();
        hashMap.put(1, 2);*/
        String hello = "hello";
        hello.toCharArray();
        char[] chars = ArrayUtils.add(hello.toCharArray(), 's');
        String string = Arrays.toString(chars);
//        ArrayUtils.
        System.out.println(string);
    }
}
