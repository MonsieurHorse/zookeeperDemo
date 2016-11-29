package com.common.zookeeper.pattern;

/**
 * Created by MHorse on 2016/6/21.
 */
public class Singleton {
    private static Singleton instance = new Singleton();
//    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }
    public void getName() {// 使用普通方法输出皇帝的名字
        System.out.println("我是皇帝：明日科技");
    }
}