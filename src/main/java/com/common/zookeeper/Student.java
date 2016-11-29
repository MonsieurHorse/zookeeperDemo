package com.common.zookeeper;

/**
 * Created by MHorse on 2016/6/29.
 */
public class Student {

    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String id;


    @Override
    public String toString(){
        return "name: "+ name+ ", id: "+ id;
    }
}
