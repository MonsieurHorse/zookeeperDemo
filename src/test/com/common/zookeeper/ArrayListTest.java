package com.common.zookeeper;

import java.util.ArrayList;

/**
 * Created by MHorse on 2016/7/6.
 */
public class ArrayListTest {
    public static void main(String args[]){
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i< 10; i++){
            arrayList.add("a" + i);
            arrayList.add("b" + i);
            arrayList.add("c" + i);
        }

        for (int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.toArray()[i]);
        }
        System.out.println(arrayList);
//        System.out.println(arrayList.toArray());
        arrayList.set(1, "abc");
        System.out.println(arrayList);
        /*for (int i = 1; i< arrayList.size(); i++){
            if ("Abc".equalsIgnoreCase(arrayList.get(i))){
//                arrayList.remove(arrayList.get(i));
                arrayList.remove(i);
            }
        }*/
        /*for (String string: arrayList){
            if ("AbC".equalsIgnoreCase(string)){
                arrayList.remove(string);
            }
        }*/
        System.out.println(arrayList.remove(null));
        System.out.println(arrayList);
    }
}
