package jvm.outOfMemory;

/**
 * Created by MHorse on 2016/10/14.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {

        stackLength++;

        stackLeak();

    }



    public static void main(String[] args) throws Throwable {

        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {

            oom.stackLeak();

        } catch (Throwable e) {

            System.out.println("stack length:" + oom.stackLength);

            throw e;

        }

    }
}
