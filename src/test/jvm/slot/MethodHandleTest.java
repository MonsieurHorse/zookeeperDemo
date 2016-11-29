package jvm.slot;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by MHorse on 2016/10/19.
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable{
        Object obj = new ClassA();
        getPrintlnMH(obj).invokeExact("Hello world.");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable{
        MethodType mt = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }
}/*Output:
Hello world.
*///:~

