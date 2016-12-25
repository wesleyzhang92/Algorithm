package LeetCode;

/**
 * Remove Element
 * <p>
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * KeyWords: Array,Two pointer
 * Difficulty: Easy
 */
public class LeetCode027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == val) {
                    while (nums[j] == val) {
                        if (j < nums.length - 1)
                            j++;
                        else
                            break;
                    }
                    nums[i] = nums[j];
                    nums[j] = val;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                count++;
            else
                break;
        }
        return count;
    }


    //Better Soluion 采用了头尾两个指针进行统计
    public int removeElement2(int[] nums, int val) {
        //遍历数字是否为val
        int head = 0;
        //指向数组底部待换数字。
        int tail = nums.length - 1;
        //重复个数
        int count = 0;
        //要用等号，防止数组长度为1，且value为val的情况。
        while (head <= tail) {
            //tail是val的情况，则tail需要往前挪
            if (nums[tail] == val) {
                tail--;
                count++;
            }
            //head遍历到val的时候，和tail交换，并更新count。
            else if (nums[head] == val) {
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
                head++;
                tail--;
                count++;
            }
            //nums[head]不为count的情况。
            else {
                head++;
            }
        }
        return nums.length - count;
    }

    //Better Solution
    public int removeElement3(int[] A, int elem) {
        int m = 0;
        for (int i = 0; i < A.length; i++) {

            if (A[i] != elem) {
                A[m] = A[i];
                m++;
            }
        }

        return m;
    }
}
