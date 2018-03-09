package annotation;

import java.lang.annotation.*;

/**
 * Created by junbaoma on 2018/1/2.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface User {
    String name() default "张三";
}