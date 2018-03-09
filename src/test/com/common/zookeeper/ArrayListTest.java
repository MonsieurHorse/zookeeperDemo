package com.common.zookeeper;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
        System.out.println("arrayList:     " + arrayList);

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

        System.out.println("******************");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @org.junit.Test
    public void testEmptyList(){
        List<JSONObject> jsonObjectList = Lists.newArrayList();

        System.out.println(jsonObjectList);
        String[] strings = new String[0];
        System.out.println(Arrays.toString(strings));

//        System.arraycopy();
        int[] array = new int[]{2, 3, 9};
        int[] hello = new int[array.length];
        System.arraycopy(array, 0, hello, 0, 2);
        System.out.println(Arrays.toString(hello));
    }
}
