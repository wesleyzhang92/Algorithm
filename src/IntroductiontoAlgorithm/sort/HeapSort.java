package IntroductiontoAlgorithm.sort;

import IntroductiontoAlgorithm.util.Utils;

import java.util.Arrays;

/**
 * Created by wesley on 2016/10/5.
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        int[] num = {6, 3, 4, 2, 5, 1, 7};
        int[] results = heap.heapsort(num);
        System.out.println(Arrays.toString(results));
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    public void maxHeapify(int[] nums, int i, int length) {
        int l = 2 * i + 1;
        int r = l + 1;
        int large = i;
        if (l < length && nums[l] > nums[i]) {
            large = l;
        }
        if (r < length && nums[r] > nums[large]) {
            large = r;
        }
        if (large != i) {
            Utils.swap(nums, i, large);
            maxHeapify(nums, large, length);
        }
    }

    public int[] heapsort(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            Utils.swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
        return nums;
    }
}
