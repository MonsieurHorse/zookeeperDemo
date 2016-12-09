package com.common.zookeeper.sort;

import org.junit.*;

/**
 * Created by MHorse on 2016/12/9.
 */
public class Search {

    @org.junit.Test
    public void testSearch(){

        int[] array = {1,2,3,4,5,6,7,8,9,10};
//        binarySearch_circle(array, 11);
        System.out.println(binarySearch_circle(array, 6));

    }

    public int binarySearch_circle(int[] array, int num){
        int high = array.length-1;
        int low = 0;

        while (low < high){
            int middle = (low + high)/2;
            if (array[middle] == num){
                return middle;
            }else {
                if (array[middle] > num){
                    high = middle -1;
                }else {
                    low = middle +1;
                }
            }
        }
        return -1;
    }
}
