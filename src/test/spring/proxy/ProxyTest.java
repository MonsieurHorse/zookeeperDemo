package spring.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by junbaoma on 2018/2/11.
 */
public class ProxyTest {
    @Test
    public void demo1(){
        // JDK 自动代理 的原理是  根据 类加载器和接口  创建代理类（此代理类是接口的实现类，所以必须使用接口

        // 1、 创建真是业务对象的引用
        Fly fly = new Bird();

        Fly proxy = (Fly) Proxy.newProxyInstance(fly.getClass().getClassLoader(), fly.getClass().getInterfaces(), new InvocationHandler() {
            // 2、使用真是业务对象类加载器和接口，在内存中创建代理对象
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                // 拦截方法
                if(method.getName().equals("gotoFly")){
                    System.out.println("被拦截了，鸟飞不走了。。。");
                    return null;
                }
                // 不拦截就invoke
                return method.invoke(proxy, args);
            }
        });

        proxy.gotoFly();

    }
}
