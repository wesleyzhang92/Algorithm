package sort;

import java.util.Arrays;

/**
 * Created by wesley on 2016/10/6.
 */
public class SelectSort {
    public static void main(String[] args) {
        SelectSort se = new SelectSort();
        int[] num = {6, 3, 4, 2, 5, 1};
        int[] results = se.select(num);
        System.out.println(Arrays.toString(results));
    }

    public int[] select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
        return nums;

    }
}
