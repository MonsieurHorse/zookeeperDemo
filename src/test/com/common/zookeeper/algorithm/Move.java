package com.common.zookeeper.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by junbaoma on 2017/12/16.
 */
public class Move {

    public final String string = "move these spaces to beginning";

    @Test
    public void testMoveSpacesToBeginning(){
        System.out.println(string);
        char[] chars = string.toCharArray();
        int count = 0;
        for (char character : chars) {
            if (!Character.isSpaceChar(character)){
//            if (character != '\0'){
                chars[count++] = character;
//                System.out.println(character);
            }
        }
        for (; count < chars.length; count ++) {
            chars[count] = ' ';
        }
        System.out.println(chars);
    }


    @Test
    public void testMove5() {
        char[] array = string.toCharArray();
        System.out.println(array);
        move5(array);
        System.out.println(new String(array));
    }

    public void move5(char[] array) {
        int i = array.length - 1;
        int j = i;
        for (; j >= 0; j--) {
            if (!Character.isSpaceChar(array[j])) {
                swapChar(array, i--, j);
            }
        }
    }

    void swapChar(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void testRotate() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(array));
        rotate(array, 2);
        System.out.println(Arrays.toString(array));
    }

    void rotate(int[] array, int number) {
        reverse(array, 0, number - 1);
        reverse(array, number, array.length - 1);
        reverse(array, 0, array.length -1);
    }

    void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void testMoveNumber() {
        int[] array = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        System.out.println(Arrays.toString(array));
        moveZeroToEnd(array);
        System.out.println(Arrays.toString(array));
    }
    void moveZeroToEnd(int[] array) {

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != 0) {
                swapNumber(array, j++, i);
            }
        }
    }

    void swapNumber(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
