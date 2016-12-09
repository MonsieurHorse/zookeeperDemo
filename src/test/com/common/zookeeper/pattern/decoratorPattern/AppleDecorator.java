package com.common.zookeeper.pattern.decoratorPattern;

/**
 * Created by MHorse on 2016/12/9.
 */
public class AppleDecorator implements Basket {
    private Basket basket;
    public AppleDecorator( Basket basket){
        super();
        this.basket = basket;
    }

    public void show(){
        basket.show();
        System.out.println("An Apple");
    }
}
