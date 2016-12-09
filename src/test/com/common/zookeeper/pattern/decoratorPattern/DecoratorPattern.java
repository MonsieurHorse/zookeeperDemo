package com.common.zookeeper.pattern.decoratorPattern;

/**
 * Created by MHorse on 2016/12/9.
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        // TODO code application logic here
        Basket basket = new Original();
        //一个装饰的过程
        Basket myBasket =new AppleDecorator(new BananaDecorator(new OrangeDecorator(basket)));
        myBasket.show();
    }
}
