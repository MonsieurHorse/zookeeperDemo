package jvm;

/**
 * Created by MHorse on 2016/10/17.
 */
public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4;
        /**
         * 如果注释了Sub类中的 public static int A = 4; 接口与父类同时存在字段A，那编译器
         * 将提示 “the field Sub.A is ambiguous”，并且拒绝编译
         */
    }

    public static void main(String[] args) {
        System.out.println(Sub.A); // output: 4
    }
}
