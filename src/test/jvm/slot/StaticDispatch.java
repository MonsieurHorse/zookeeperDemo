package jvm.slot;

/**
 * Created by MHorse on 2016/10/19.
 */
public class StaticDispatch {

    static abstract class Human{};
    static class Man extends Human{} ;
    static class Woman extends Human{} ;

    public void say(Human human) {
        System.out.println("hi,you are a good human!");
    }
    public void say(Man human) {
        System.out.println("hi,gentleman!");
    }
    public void say(Woman human) {
        System.out.println("hi,yong lady!");
    }
    /**
     * @param args
     * @Author YHJ create at 2012-2-24 下午08:20:00
     */
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.say(man);
        dispatch.say(woman);
        dispatch.say((Man) man);
        Man man1 = new Man();
        dispatch.say(man1);
    }
}
