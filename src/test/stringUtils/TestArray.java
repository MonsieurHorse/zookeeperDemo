package stringUtils;

import org.junit.Test;

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
}
