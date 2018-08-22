package site.sixteen.sort;

import java.util.Arrays;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class InsertionSort {

    public static void sort(int[] array) {
        if (array != null) {
            int len = array.length;
            int temp;
            for (int i = 1; i < len; i++) {
                for(int j = i;j>0 && array[j-1]>array[j];j--){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
