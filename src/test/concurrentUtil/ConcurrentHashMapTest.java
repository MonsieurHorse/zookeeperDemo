package concurrentUtil;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by junbaoma on 2018/1/26.
 */
public class ConcurrentHashMapTest {

    @Test
    public void testHaMap() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.toString());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("key:" + entry.getKey());
        }

        System.out.println(Integer.parseInt("0011111", 2));
        System.out.println(Integer.parseInt("0001111", 2) & 15);
    }
}
