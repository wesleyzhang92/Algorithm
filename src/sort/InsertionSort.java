package sort;

/**
 * Created by wesley on 2016/10/2.
 */

import util.Utils;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort in = new InsertionSort();
        int[] num = {6, 3, 4, 2, 5, 1};
        int[] results = in.insertion(num);
        int[] res = in.insertion_test(num, false);
        System.out.println(Arrays.toString(results));
        Utils.printArray(res);
    }

    public int[] insertion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public int[] insertion_test(int[] nums, boolean assending) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            if (assending) {
                while (j >= 0 && nums[j] > key) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = key;
            } else {
                while (j >= 0 && nums[j] < key) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = key;
            }
        }
        return nums;
    }
}
