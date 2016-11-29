package com.common.zookeeper.sort;

/**
 * Created by MHorse on 2016/9/9.
 */
public class QuickSortTest {
    public static void main(String[] args){
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

        sort(array, 0, array.length -1);
        show(array);
    }

    public static void sort(int[] array, int low, int high){
        if (array.length > 0 && low < high){
            int middle = quickSort(array, low, high);
            sort(array, low, middle -1);
            sort(array, middle + 1, high);
        }
    }
    public static int quickSort(int[] array, int low, int high){
        int temp = array[low];
        while (low < high){
            while (low < high && array[high] >= temp){
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        System.out.println("low: " + low);
        return low;
    }

    public static void show(int[] array){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: array){
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        System.out.println("array: " + stringBuilder.toString());
    }
}
