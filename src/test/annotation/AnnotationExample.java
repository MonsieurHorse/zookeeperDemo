package annotation;

import java.lang.annotation.Annotation;

/**
 * Created by junbaoma on 2018/1/2.
 */
public class AnnotationExample {

    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> classTest=Class.forName("annotation.LockTest");
        Annotation[] ann=classTest.getAnnotations();
        for(Annotation aa:ann){
            User u=(User)aa;
            System.out.println(u.name());
        }
    }
}
