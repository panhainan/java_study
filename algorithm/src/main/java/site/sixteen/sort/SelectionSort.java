package site.sixteen.sort;

import java.util.Arrays;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class SelectionSort {

    public static void sort(int[] array){
        if(array!=null){
            int len = array.length;
            int temp,min;
            for(int i=0;i<len;i++){
                min = i;
                for(int j = i+1;j<len;j++){
                    if(array[min]>array[j]){
                        min = j;
                    }
                    System.out.printf("# ");
                }
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
