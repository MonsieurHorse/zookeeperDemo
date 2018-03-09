package stringUtils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by MHorse on 2016/9/28.
 */
public class TestArray {

    @Test
    public void testArray(){
        char[] chars = {'a', 'b', 'B', 'g', 'L', 'M', 'u','Y'};
        array(chars);
        System.out.println(chars);
    }

    public void array(char[] chars){
        for (int i = chars.length -1; i >= 0; i--){
            for (int low = chars.length - 1; low >= 0; low--){
                if (Character.isLowerCase(chars[low])){
                    System.out.println("low  " +low);
                    if (!Character.isLowerCase(chars[i])){
                        if (i < low){
                            char temp = chars[i];
                            for (int m = i; m < low; m++){
                                chars[m] = chars[m +1];
                            }
                            chars[low] = temp;
                        }
                    }
                }
            }
            System.out.println(chars);
        }
    }

    @Test
    public void testSearch(){
        int[] array = {1002,1001,1003,1004,2001,1009,1008};
        System.out.println(Arrays.binarySearch(array, 1002));
    }

   /* @LockTest
    public void testTimeStamp(){
        Long time = 1497843353000L;

        Timestamp ts = new Timestamp();
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            //方法一
            tsStr = sdf.format(ts);
            System.out.println(tsStr);
            //方法二
            tsStr = ts.toString();
            System.out.println(tsStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

   @Test
    public void testTime(){

       String s;
       String res;
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       long lt = 1498182178208L;
       Date date = new Date(lt);
       res = simpleDateFormat.format(date);
//       return res;
       System.out.println(res);
   }


    /**
     * sign生成函数，
     * @param jsonObject
     * @return
     */
   /* public String getSign(JSONObject jsonObject, final String secret) {
        Set<String> keySet = jsonObject.keySet();
        Iterator<String> it = keySet.iterator();
        List<String> list = new ArrayList<String>();
        while (it.hasNext()) {
            String key = it.next();
            String value=jsonObject.getString(key);
            list.add(key+"="+value);
        }
        if(list.size()==0)
        {
            return "";
        }
        Collections.sort(list);
        StringBuilder buf = new StringBuilder();
        for (String s : list) {
            buf.append(s);
        }
        buf.append(secret);
        return MD5.crypt(buf.toString(), "UTF-8");
    }*/

    @Test
    public void testSign(){
        JSONObject jsonObject = new JSONObject();
        String secret = "";
        System.out.println();
    }
}
