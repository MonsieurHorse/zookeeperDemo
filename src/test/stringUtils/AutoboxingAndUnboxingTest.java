package stringUtils;

import org.junit.*;
import org.junit.Test;

/**
 * Created by junbaoma on 2017/8/7.
 */
public class AutoboxingAndUnboxingTest {

    @Test
    public void testLongTolong(){
        int time = 10000 * 100000;
        long startTime = System.currentTimeMillis();
        Long valueLong = Long.valueOf(1L);
        for (int i = 0; i < time; i++){
            long getlong = valueLong;
        }
        System.out.println(System.currentTimeMillis() - startTime);

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < time; i++){
            Long getLong = valueLong;
        }
        System.out.println(System.currentTimeMillis() - startTime2);
    }
}
