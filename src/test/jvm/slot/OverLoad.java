package jvm.slot;

import java.io.Serializable;

/**
 * Created by MHorse on 2016/10/19.
 */
public class OverLoad {

//    public static void say(Object obj){ System.out.println("Object"); }

//    public static void say(char obj){ System.out.println("char"); }

//    public static void say(int obj){ System.out.println("int"); }

//    public static void say(long obj){ System.out.println("long"); }

//    public static void say(float obj){ System.out.println("float"); }

//    public static void say(double obj){ System.out.println("double"); }

//    public static void say(Character obj){ System.out.println("Character"); }

//    public static void say(Serializable obj){ System.out.println("Serializable"); }

    public static void say(char... obj){ System.out.println("char..."); }

    public static void main(String[] args) {
        OverLoad.say('a');
//        OverLoad.say('a', 'b');
//        Serializable serializable = new Serializable() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        };
//        OverLoad.say(serializable);
    }
}
