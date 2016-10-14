package sort;

/**
 * Created by wesley on 2016/10/6.
 */

import java.util.Arrays;

public class RadixSort {
    private static void radix_sort(int[] array, int radix, int distance) {
        //array为待排序数组
        //radix，代表基数
        //distance 代表排序元素的位数
        int length = array.length;
        int[] temp = new int[length];//用于暂存元素
        int[] count = new int[radix];//用于计数排序
        int divide = 1;

        for (int i = 0; i < distance; i++) {
            System.arraycopy(array, 0, temp, 0, length);
            Arrays.fill(count, 0);
            for (int j = 0; j < length; j++) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            //个人觉的运用计数排序实现基数排序的重点在下面这个方法
            for (int j = length - 1; j >= 0; j--) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]--;
                array[count[tempKey]] = temp[j];
            }
            System.out.println(Arrays.toString(array));
            divide = divide * radix;

        }

    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 2, 5, 333, 45566, 2345678, 78, 990, 12, 432, 56};
        radix_sort(nums, 10, 7);
        System.out.println(Arrays.toString(nums));
    }
}

