package com.common.zookeeper.factory;

/**
 * Created by MHorse on 2016/6/22.
 */
//第二个建造工厂
public class TwoCreator extends Creator {

    public Product CreateProduct(String f_Type) {

        if (f_Type.equals("one")) {

            return new FirstProduct();

        } else if (f_Type.equals("two")) {

            return new SecondProduct();

        }

        return null;

    }

}