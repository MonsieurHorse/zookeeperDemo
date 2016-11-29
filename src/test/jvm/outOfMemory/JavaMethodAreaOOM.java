//package jvm.outOfMemory;
//
///**
// * Created by MHorse on 2016/10/14.
// */
//public class JavaMethodAreaOOM {
//    public static void main(String[] args) {
//
//        while (true) {
//
//            Enhancer enhancer = new Enhancer();
//
//            enhancer.setSuperclass(OOMObject.class);
//
//            enhancer.setUseCache(false);
//
//            enhancer.setCallback(new MethodInterceptor() {
//
//                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//
//                    return proxy.invokeSuper(obj, args);
//
//                }
//
//            });
//
//            enhancer.create();
//
//        }
//
//    }
//
//
//
//    static class OOMObject {
//
//
//
//    }
//}
