package interview.pattern;

/**
 * Created by MHorse on 2016/11/29.
 */
public class SingletonSafe {

    private SingletonSafe(){};
    private static SingletonSafe singletonSafe = new SingletonSafe();
    public static SingletonSafe getSingletonSafe(){
        return singletonSafe;
    }

    public void print() {
        System.out.println("hello");
    }
}
