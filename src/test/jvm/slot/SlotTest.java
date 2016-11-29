package jvm.slot;

/**
 * Created by MHorse on 2016/10/18.
 */
public class SlotTest {

    int abc;
    public static void main(String[] args){
        {
            byte[] placeholder = new byte[64 * 1024 *1024];
        }
        int a = 0;
        System.gc();
    }
}
