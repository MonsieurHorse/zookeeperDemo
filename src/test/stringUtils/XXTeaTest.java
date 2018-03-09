package stringUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.xxtea.XXTEA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by junbaoma on 2017/8/16.
 */
public class XXTeaTest {

    @org.junit.Test
    public void testXXTea(){
//        String str = "Hello World! 你好，中国！";
        String did = "f2d0757a3a0a4ed152fa6114db772eca";
        String key = "1234567890";
        String encrypt_data = XXTEA.encryptToBase64String(did, key);
//        System.out.println(Arrays.toString(Base64.decode(encrypt_data)));
//        System.out.println("QncB1C0rHQoZ1eRiPM4dsZtRi9pNrp7sqvX76cFXvrrIHXL6");
//        System.out.println("QncB1C0rHQoZ1eRiPM4dsZtRi9pNrp7sqvX76cFXvrrIHXL6".equals(encrypt_data));
        System.out.println(encrypt_data);
        assert("eU2kDzZf/hHqEunlxS4rgAdoTJerfHf3xJj2xeELBqcKibJT".equals(encrypt_data));
        String decrypt_data = XXTEA.decryptBase64StringToString(encrypt_data, key);
        System.out.println(decrypt_data);
        assert(did.equals(decrypt_data));
    }

    public boolean didSign(String did, String encryptDid, String XXTeaKey){

        String decryptDid = XXTEA.decryptBase64StringToString(encryptDid, XXTeaKey);
        if (did.equals(decryptDid)){
            return true;
        }else {
            return false;
        }
    }

    @Test
    public void testDidSign(){

        String did = "4236579585919acc5f3de4d11c582784";
        String key = "NAq6S0MDjX0U0UxLKJz1";
        String encrypt_data = XXTEA.encryptToBase64String(did, key);
        System.out.println(didSign(did, encrypt_data, key));
    }

    @Test
    public void testR(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "   " + (i >>>2));
        }

        int a = 1;
        a |= 2;
        System.out.println(a);
        System.out.println((3 ^ 2));
    }

    private final static String APP_VERSION_SPLIT = ".";


    public static boolean isAppVersionNewer(String currentVersion, String comparedVersion) throws Exception{
        //不符合标准的抛出异常
        if(!isAppVersionValid(currentVersion) || !isAppVersionValid(comparedVersion)){
            throw new Exception("appversion参数异常！");
        }
        String[] currentVersionArr = StringUtils.split(currentVersion, APP_VERSION_SPLIT);
        String[] comparedVersionArr = StringUtils.split(comparedVersion, APP_VERSION_SPLIT);
        //逐级比较版本号，判断新旧版本
        for(int i=0;i<currentVersionArr.length;i++){
            System.out.println(currentVersionArr[i]);
            System.out.println(comparedVersionArr[i]);
            if(Integer.valueOf(currentVersionArr[i]) > Integer.valueOf(comparedVersionArr[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
//		System.out.println(isAppVersionValid("1.0.1.1"));
        System.out.println(isAppVersionNewer("1.16","1.6"));
    }

    private static boolean isAppVersionValid(String appVersion) {
        if(StringUtils.isEmpty(appVersion)){
            return false;
        }
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+){2}");
        Matcher matcher = pattern.matcher(appVersion);
        return matcher.matches();
    }


    /*private boolean ifValid(String appVersion, String appId, String did){

        String APPVERSION_1DOT6 = "1.6.0";
        String DidSignKey = "1234567890";
        try {
            if (!StringUtils.isEmpty(appVersion) && (StringUtils.isEmpty(appId)
                    || !AppVersionUtil.isAppVersionEqualsOrHigher(appVersion, APPVERSION_1DOT6)
                    || !ValidateParamsSignUtil.isDidSignValid(did, appId,DidSignKey))){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
        return true;
    }*/
    @Test
    public void testIfValid(){
        String appVersion = "1.6.2";
        String appId = "eU2kDzZf/hHqEunlxS4rgAdoTJerfHf3xJj2xeELBqcKibJT";
        String did = "0e3966fa8ffdc6b6161aef75f0bef569";
//        System.out.println(ifValid(appVersion, appId, did));
        System.out.println(appId.length());
    }

    @Test
    public void testLength(){
        String did = "0e3966fa8ffdc6b6161aef75f0bef569";
        String key = "1234567890";
        System.out.println(XXTEA.encryptToBase64String(did, key));
        for (int i = 0; i < 100; i++){
            did = did + i;
            System.out.println(did);
            String encrypt_data = XXTEA.encryptToBase64String(did, key);
            System.out.println(encrypt_data.length() + "      " + encrypt_data);
        }

    }
    public static boolean isDidSignValid(String did, String didSigned, String XXTeaKey){
        String encryptDid = XXTEA.encryptToBase64String(did, XXTeaKey);
        return didSigned.equals(encryptDid);
    }
    @Test
    public void testisDidSignValid(){
        String did = "0e3966fa8ffdc6b6161aef75f0bef569";
        String didSigned = "eU2kDzZf/hHqEunlxS4rgAdoTJerfHf3xJj2xeELBqcKibJT";
        String key = "1234567890";
        System.out.println(isDidSignValid(did, didSigned, key));
        System.out.println("69642c61-7008-3b00-a99d-5911b5fee916".length());
        System.out.println("715ba11977d9743a7088b99c1c128691".length());
    }

    @Test
    public void testTTT() {
        int number = 10;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
        printInfo(number >>> 3);
        printInfo(number >>> 1);
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }


    @Test
    public void testDecode() {
        String string = "5c0LY01izLulTJyky4GFb9sCC5r31qxtlUwrtCmnB59uiuv4OR1R0FwoUM/O9M2r3fex4HjSpdTsdnXo4H6WEb/wTXinr4xoy5BLzNlM6cZvwc4la6C/oJhe6Le+bvQSX7yM0e5qUOFhOKd5bbB1IB5jUozZ4R+7";

//        String decrypt = ValidateParamsSignUtil.xxTeaDecrypt(string, "gjl7ZyVasJyH3P");
//        System.out.println(decrypt);
    }
}
