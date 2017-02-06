package IntroductiontoAlgorithm.sort;

import java.util.Arrays;

/**
 * Created by wesley on 2016/10/6.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 3, 5, 2};
        CountingSort cs = new CountingSort();
        nums = cs.counting_sort(nums, 8);
        System.out.println(Arrays.toString(nums));
    }

    public int[] counting_sort(int[] nums, int k) {
        int[] c = new int[k];
        for (int i = 0; i < k; i++)
            c[i] = 0;
        for (int j = 0; j < nums.length; j++) {
            c[nums[j]]++;
        }
        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }
        int[] b = new int[nums.length];
        for (int j = nums.length - 1; j >= 0; j--) {
            b[c[nums[j]] - 1] = nums[j];
            c[nums[j]]--;
        }
        return b;
    }
}
