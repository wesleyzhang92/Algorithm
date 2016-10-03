package sort;

import util.Utils;

import java.util.Arrays;

/**
 * Created by wesley on 2016/10/2.
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] nums = {6, 1, 4, 7, 3, 5, 2};
        int a = m.merge_sort_inva(nums, 0, nums.length - 1);
        int[] res = m.merge_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(a);
        Utils.printArray(res);

    }

    //使用∞作为哨兵,执行归并，先从nums中复制出数组到left和right中，然后比较大小，放回nums中
    public int[] merge(int nums[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = nums[p + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = nums[q + i + 1];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
        }
        return nums;
    }

    //不使用哨兵的归并，计算逆序数
    public int merge1(int nums[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int inva = 0;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = nums[p + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = nums[q + i + 1];
        }
        int i = 0, j = 0, k = p;
        //没有哨兵，需要进行循环的判断
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
                inva += (n1 - i);
            }
            k++;
        }
        if (i == n1) {
            for (; j < n2; j++) {
                nums[k] = right[j];
                k++;
            }
        }
        if (j == n2) {
            for (; i < n1; i++) {
                nums[k] = left[i];
                k++;
            }
        }
        return inva;
    }

    public int merge_sort_inva(int[] nums, int p, int r) {
        int inva = 0;
        if (p < r) {
            int mid = (p + r) / 2;
            inva += merge_sort_inva(nums, p, mid);
            inva += merge_sort_inva(nums, mid + 1, r);
            inva += merge1(nums, p, mid, r);
        }
        return inva;
    }

    public int[] merge_sort(int[] nums, int p, int r) {
        if (p < r) {
            int mid = (p + r) / 2;
            merge_sort(nums, p, mid);
            merge_sort(nums, mid + 1, r);
            merge(nums, p, mid, r);
        }
        return nums;
    }
}
