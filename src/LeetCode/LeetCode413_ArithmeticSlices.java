package LeetCode;

/**
 * Arithmetic Slices
 * <p>
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * <p>
 * Difficulty: Medium
 */
public class LeetCode413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length - 1; i++) {
            A[i] = A[i + 1] - A[i];
        }
        int j = 0;
        while (j < A.length - 1) {
            int count = 0;
            while (j < A.length - 2 && A[j] == A[j + 1]) {
                count++;
                j++;
            }
            if (count < 2 && count != 0) {
                result += 1;
            } else if (count >= 2) {
                count++;
                result += (count * count - count) / 2;
            }
            j++;
        }

        return result;

    }

    //Elegant way
    public int numberOfArithmeticSlices2(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode413_ArithmeticSlices ls = new LeetCode413_ArithmeticSlices();
        int[] a = {1, 2, 3};
        int ans = ls.numberOfArithmeticSlices(a);
        System.out.print(ans);
    }
}
