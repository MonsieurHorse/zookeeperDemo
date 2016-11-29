package com.common.zookeeper.factory;

/**
 * Created by MHorse on 2016/6/22.
 */
//第一个建造工厂
public class OneCreator extends Creator
{
    public Product CreateProduct(String f_Type)
{
    if (f_Type.equals("one")) {
        return new OneProduct();
    } else if (f_Type.equals("two")) {
        return new TwoProduct();
    }

    return null;
}
}
