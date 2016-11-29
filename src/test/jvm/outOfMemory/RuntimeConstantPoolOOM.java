package jvm.outOfMemory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MHorse on 2016/10/14.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        // 使用List保持着常量池引用，压制Full GC回收常量池行为

        List<String> list = new ArrayList<String>();

        // 10M的PermSize在integer范围内足够产生OOM了

        int i = 0;

        while (true) {

            list.add(String.valueOf(i++).intern());

        }
    }

    @Test
    public void testRuntimeConstantPoolOOM(){
        String string1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(string1.intern() == string1);

        String string2 = new StringBuilder("ja").append("va").toString();
        System.out.println(string2.intern() == string2);

        String string3 = string1.intern();
        System.out.println(string3 == string1);

        String s1 = new String("jiauanjiruanjian");
        System.out.println(s1.intern() == s1);
    }
}
