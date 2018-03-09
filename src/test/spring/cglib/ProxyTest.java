package spring.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by junbaoma on 2018/2/11.
 */
public class ProxyTest {
    @Test
    public void demo2(){
        // cglib 动态代理  在目标业务类没有实现接口的情况下

        // 1、创建真实业务对象的引用
        Cat cat = new Cat();
        // 2、创建真实业务类的子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cat.getClass());

        // 3、设置回调函数
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object proxy, Method method, Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("run")){
                    System.out.println("cat的run方法被拦截了。。。。");
                    Object invoke = method.invoke(proxy, args);
                    System.out.println("真实方法拦截之后。。。。");
                    return invoke;
                }

                // 不拦截
                return method.invoke(proxy, args);
            }
        });
        Cat proxy = (Cat) enhancer.create();

        proxy.run();
    }
}
