package com.common.zookeeper.sort;

import org.junit.*;

/**
 * Created by MHorse on 2016/9/16.
 */
public class MergeSortTest {
    @org.junit.Test
    public void testMergeSort(){
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(array, 0, array.length- 1);
        show(array);
    }

    public void sort(int[] array, int i, int j){
        if (i< j){
            int middle = (i+j)/2;
            sort(array, i, middle);
            sort(array, middle+ 1, j);
            merge(array, i, middle, j);
        }
    }

    public void merge(int[] array, int i, int middle, int j){
        int[] temp = new int[array.length];
        int k = i;//temp位置
        int m = i;
        int n = middle+ 1;
        while (m<= middle && n<= j){
            if (array[m] < array[n]){
                temp[k++] = array[m++];
            }else {
                temp[k++] = array[n++];
            }
        }
        while (m<= middle){
            temp[k++] = array[m++];
        }
        while (n<= j){
            temp[k++] = array[n++];
        }
        while (i<= j){
            array[i] = temp[i++];
        }
        show(array);
    }

    public void show(int[] array){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: array){
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        System.out.println("array: " + stringBuilder.toString());
    }
}
