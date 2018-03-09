package interview.regularExpression;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by junbaoma on 2017/8/17.
 */
public class APPVersionRegexTest {

    private final static String APP_VERSION_SPLIT = ".";


    public static boolean isAppVersionEqualOrNewer(String currentVersion, String comparedVersion) throws Exception{
        //不符合标准的抛出异常
        if(!isAppVersionValid(currentVersion) || !isAppVersionValid(comparedVersion)){
            throw new Exception("appversion参数异常！");
        }
        //判断版本相同
        if(currentVersion.equals(comparedVersion)){
            return true;
        }
        String[] currentVersionArr = StringUtils.split(currentVersion, APP_VERSION_SPLIT);
        String[] comparedVersionArr = StringUtils.split(comparedVersion, APP_VERSION_SPLIT);
        //逐级比较版本号，判断新旧版本
        for(int i=0;i<currentVersionArr.length;i++){
            if(Integer.valueOf(currentVersionArr[i]) > Integer.valueOf(comparedVersionArr[i])){
                return true;
            }else if(Integer.valueOf(currentVersionArr[i]) < Integer.valueOf(comparedVersionArr[i])){
                return false;
            }
        }
        return false;
    }

    private static boolean isAppVersionValid(String appVersion) {
        if(StringUtils.isEmpty(appVersion)){
            return false;
        }
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+){2}");
        Matcher matcher = pattern.matcher(appVersion);
        return matcher.matches();
    }

    @Test
    public void testIsAppVersionEqualOrNewer(){


        try {
            System.out.println(isAppVersionEqualOrNewer("v1.1.2","1.6.0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testisAppVersionValid(){
        System.out.println(isAppVersionValid("v1.2.0"));
    }
}
