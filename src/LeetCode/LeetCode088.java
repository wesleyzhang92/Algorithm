package LeetCode;

/**
 * Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from
 * nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * KeyWords: Array,Two Pointers
 * Difficulty:Easy
 */
public class LeetCode088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while(k >= 0) {
            if(i<0) {
                nums1[k--]= nums2[j--]; //如果A的已经比较完了，就把剩余B的元素赋到A中
                continue;
            }
            if(j<0) {
                nums1[k--]= nums1[i--]; //如果B的已经比较完了，就把剩余A的元素赋到A中
                continue;
            }
            //将大的元素赋给A[k]
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }
    }


    //Elegant Solution
    public void merge2(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        while (j>-1)         A[k--]=B[j--];
    }
}
