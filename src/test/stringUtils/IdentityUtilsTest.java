package stringUtils;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by junbaoma on 2017/8/23.
 */
public class IdentityUtilsTest {

    @org.junit.Test
    public void testIsValidate(){
        System.out.println(IdentityUtils.IDCardValidate("210603199207070519"));

        for (int i = 0; i < 1000; i++){
            String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
            System.err.println(idCard);
//            assertNotNull(idCard);
//            assertEquals(IdentityUtils.IDCardValidate(idCard), true);
        }
    }
}
