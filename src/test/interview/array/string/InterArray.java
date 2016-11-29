package interview.array.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MHorse on 2016/11/28.
 */
public class InterArray {

    @Test
    public void testInterArray(){
        int[] arrayA = { 2, 3, 4, 4, 4, 4, 7, 8, 8, 8, 8, 9, 100, 130, 150, 160 };
        int[] arrayB = { 4, 6, 7, 7, 7, 7, 8, 8, 9, 10, 100, 130, 130, 140, 150 };
        ArrayList list = interArray(arrayA, arrayB);
        System.out.println(list);
    }

    public ArrayList interArray(int arrA[], int arrB[]){
        ArrayList<Integer> list = new ArrayList<Integer>(16);
        int a = 0;
        int b = 0;
        while (a < arrA.length && b < arrB.length){
            if (arrA[a] < arrB[b]){
                a++;
            }else {
                b++;
            }
            if (arrA[a] == arrB[b]){
                list.add(arrA[a]);
                a++;
                b++;
            }
        }
        return list;
    }
}
