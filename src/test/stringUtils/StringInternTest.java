package stringUtils;

import org.junit.Test;

/**
 * Created by MHorse on 2016/10/14.
 */
public class StringInternTest {

    @Test
    public void testIntern3(){
        String s0= "kvill";
        String s1=new String("kvill");
        String s2=new String("kvill");
        System.out.println( s0==s1 );
        System.out.println( "**********" );
        s1.intern();
        s2=s2.intern(); //把常量池中“kvill”的引用赋给s2
        System.out.println( s0==s1);
        System.out.println( s0==s1.intern() );
        System.out.println( s0==s2 );
    }

    @Test
    public void testIntern4(){
        String s1=new String("kvill");
        String s2=s1.intern();
        System.out.println( s1==s1.intern() );
        System.out.println( s1+" "+s2 );
        System.out.println( s2==s1.intern() );
    }
}
