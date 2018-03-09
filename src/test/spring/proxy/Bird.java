package spring.proxy;

/**
 * Created by junbaoma on 2018/2/11.
 */
public class Bird implements Fly {
    @Override
    public void gotoFly() {
        System.out.println("鸟儿张开翅膀要飞起来了。。。。");
    }

    @Override
    public void stopFly() {
        System.out.println("准备停飞。。。。");
    }

    public void eatBug(){
        System.out.println("鸟要吃虫子，补充体力。。。");
    }
}
