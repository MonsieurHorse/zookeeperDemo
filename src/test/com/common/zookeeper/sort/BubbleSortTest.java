package com.common.zookeeper.sort;

import org.junit.Test;

/**
 * Created by MHorse on 2016/9/16.
 */
public class BubbleSortTest {
    @Test
    public void testBubbleSort(){
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(array);
        show(array);
    }

    public void sort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void show(int[] array){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: array){
            if (stringBuilder.length() > 0){
                stringBuilder.append(",");
            }
            stringBuilder.append(i);
//            stringBuilder.append(",");
        }
        System.out.println("array: " + stringBuilder.toString());
    }

    @Test
    public void testInsertSort(){
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        insertSort(array);
        show(array);
    }

    public void insertSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int value = array[i];
            int pre = i;
            for (int j = i - 1; j >= 0; j--){
                if (value < array[j]){
                    array[j + 1] = array[j];
                    pre--;
                }
            }
            array[pre] = value;
        }
    }

    @Test
    public void testSelectSort(){
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        insertSort(array);
        show(array);
    }

    public void selectSort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length; i++){
            temp = array[i];
//            for ()
//            java.lang.reflect.Method.
        }
    }
}
