package IntroductiontoAlgorithm.sort;

import IntroductiontoAlgorithm.util.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wesley on 2016/10/6.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = {6, 1, 4, 7, 3, 5, 2};
        qs.quick_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= x) {
                i++;
                Utils.swap(nums, i, j);
            }
        }
        Utils.swap(nums, i + 1, r);
        return i + 1;
    }

    //Random Partition
    public int randomized_partition(int[] nums,int p,int r) {
        Random rand = new Random();
        int i = rand.nextInt(r-p)+p;
        Utils.swap(nums,r,i);
        return partition(nums,p,r);
    }

    //Hoare partition
    public int hoare_partition(int[] nums, int p, int r) {
        int x = nums[p];
        int i = p;
        int j = r;
        while (i < j) {
            while (nums[j] > x)
                j--;
            while (nums[i] < x)
                i++;
            if (i < j)
                Utils.swap(nums, i, j);
        }
        return j;
    }

    public void quick_sort(int[] nums, int p, int r) {
        if (p < r) {
			int q=partition(nums,p,r);
            //int q = hoare_partition(nums, p, r);
            quick_sort(nums, p, q - 1);
            quick_sort(nums, q + 1, r);
        }
    }

    //尾递归，利用循环代替递归
    public void tail_quick_sort(int[] nums, int p, int r) {
        while (p < r) {
            int q = partition(nums, p, r);
            tail_quick_sort(nums, p, q - 1);
            p = q + 1;
        }
    }
}
