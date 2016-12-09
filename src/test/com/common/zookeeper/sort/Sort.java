package com.common.zookeeper.sort;

import java.util.Arrays;

/**
 * Created by MHorse on 2016/11/30.
 */
public class Sort {



    public static void main(String[] args){
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//        insertSort(a);
//        mergeSort(a, 0, a.length-1);
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        /*for (int i : a){
            System.out.println(i);
        }*/
    }
    public static void insertSort(int[] array){
        int temp;
        for (int i = 1; i < array.length; i++){
            temp = array[i];
            int j = i -1;
            for (; j>= 0 && array[j] > temp; j--){
                array[j +1] = array[j];
            }
            array[j +1] = temp;
        }

        for (int i:array){
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] array, int left, int right){
        if (left < right){
            int middle = (left + right)/2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right){
        int i = left;
        int j = middle + 1;
        int[] temp = new int[array.length];
        int k = 0;

        while (i <= middle && j <= right) {
            if (array[i] < array[j]){
                temp[k++] = array[j++];
            }else {
                temp[k++] = array[i++];
            }
        }
        while (i <= left){
            temp[k++] = array[i++];
        }
        while (j <= right){
            temp[k++] = array[j++];
        }
        /*for (i = 0; i< k; ++i){
            array[left +i] = temp[i];
        }*/
        while (left < right){
            array[left++] = temp[left++];
        }
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length- i - 1; j++){
                if (array[j] < array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
