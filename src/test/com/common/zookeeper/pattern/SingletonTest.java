package com.common.zookeeper.pattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MHorse on 2016/6/21.
 */
public class SingletonTest {
    public static void main(String args[]){
        Singleton singleton = Singleton.getInstance();
        singleton.getName();
        Singleton singleton2 = Singleton.getInstance();
        singleton2.getName();
        Integer b;
        Singleton singleton1 = new Singleton();
//        singleton1.
    }

    Integer a = new Integer(3);

    @Test
    public void testBig(){
        System.out.println(2<<3);
        String a = null;
        a.length();
        String[] abc = {};
        int i = abc.length;
        List list = new ArrayList();
        list.size();
    }
}
