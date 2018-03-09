package test;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by junbaoma on 2018/1/25.
 */
public class ConstantModel {
    public static long time = 1;
    static {
        final String timeEnv = System.getenv("");
        if (StringUtils.isNumeric(timeEnv)) {
            time = Long.parseLong(timeEnv);
        }
    }

    public static long getTime() {
        return time;
    }
}
