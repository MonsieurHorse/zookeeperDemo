package stringUtils;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by junbaoma on 2017/12/26.
 */
public class MapTest {

    @org.junit.Test
    public void testValueNull() {

        HashMap hashMap = new HashMap();
//        hashMap.put("a", "a");
        hashMap.put("b", null);
//        hashMap
//        hashMap.put("c", "c");
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
        System.out.println(MapUtils.isEmpty(hashMap));
    }

    @Test
    public void testNewMap() {
        HashMap hashMap = new HashMap(2);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.toString());
        System.out.println(hashMap.get(1).toString());
        hashMap.hashCode();
//        hashMap.put(3, 3);
//        hashMap.put(4, 4);

    }
}
