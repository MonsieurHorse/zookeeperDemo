package com.common.zookeeper.factory;

import java.io.Console;

/**
 * Created by MHorse on 2016/6/22.
 */
public class MainTest {

    public static void main(String[] args)
    {
        //region 工场模式
        //第一个工厂 两种产品
        Creator _creator = new OneCreator();
        Product _product = _creator.FactoryMethod("one");
        System.out.println(_product.productName);
        _product = _creator.FactoryMethod("two");
        System.out.println(_product.productName);

        //第二个工厂  造另两种产品
        Creator _tCreator = new TwoCreator();
        Product _tProduct = _tCreator.FactoryMethod("one");
        System.out.println(_tProduct.productName);
        _tProduct = _tCreator.FactoryMethod("two");
        System.out.println(_tProduct.productName);
        //endregion
    }
}
