package com.common.zookeeper.sort;

import java.util.Arrays;

import static com.common.zookeeper.sort.QuickSortTest.show;

/**
 * Created by MHorse on 2016/9/9.
 */
public class Test {

    @org.junit.Test
    public void test(){
        int a[] = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quick(a);
        show(a);
    }
        public int getMiddle(int[] list, int low, int high) {

        int tmp = list[low];    //数组的第一个作为中轴

        while (low < high) {

            while (low < high && list[high] >= tmp) {

                high--;

            }

            list[low] = list[high];   //比中轴小的记录移到低端

            System.out.println("tmp:  " + tmp);
            while (low < high && list[low] <= tmp) {

                low++;

                System.out.println("tmp: " + tmp);
            }

            list[high] = list[low];   //比中轴大的记录移到高端

        }

        list[low] = tmp;              //中轴记录到尾

            System.out.println("low: " + low);
            show(list);
        return low;                   //返回中轴的位置

    }

    public void _quickSort(int[] list, int low, int high) {

        if (low < high) {

            int middle = getMiddle(list, low, high);  //将list数组进行一分为二

            _quickSort(list, low, middle - 1);        //对低字表进行递归排序

            _quickSort(list, middle + 1, high);       //对高字表进行递归排序

        }

    }

    public void quick(int[] a2) {

        if (a2.length > 0) {    //查看数组是否为空

            _quickSort(a2, 0, a2.length - 1);

        }

    }


    public void insertSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int temp = 0;
            temp = array[i];
            int j = i - 1;
            for (; j >= 0 && temp < array[j]; j--){
                array[j + 1] = array[j];
            }
            array[j +1] = temp;
        }
    }

    @org.junit.Test
    public void testSort(){

        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
