package site.sixteen.sort;

import java.util.Arrays;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class BubbleSort {

    public static void sort(int[] array) {
        if (array != null) {
            int len = array.length;
            int temp;
            boolean isChange;
            for (int i = 0, j; i < len; i++) {
                isChange = false;
                for (j = 0; j < len - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        isChange = true;
                    }
//                    System.out.printf("# ");
                }
                if (!isChange) {
                    break;
                }
//                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
