package interview.pattern;

/**
 * Created by MHorse on 2016/11/29.
 */
public class Singleton {

    private Singleton(){};
    private static Singleton singleton = null;
    public Singleton getSingleton(){
        if (null == singleton){
            singleton = new Singleton();
        }
        return singleton;
    }
}
