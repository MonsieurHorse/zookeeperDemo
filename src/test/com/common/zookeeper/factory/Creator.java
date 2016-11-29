package com.common.zookeeper.factory;

/**
 * Created by MHorse on 2016/6/22.
 */
// 建造者
//工厂方法是创建一个框架，让子类决定要如何实现具体的产品
public abstract class Creator
{
    public Product FactoryMethod(String f_ProductType)
    {
        Product _product;
        _product=CreateProduct(f_ProductType);
        //可对产品做其它的操作......
        return _product;
    }
    //让子类去实现要生产什么产品
    public abstract Product CreateProduct(String f_Type);

}