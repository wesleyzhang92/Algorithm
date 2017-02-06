package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by
 * the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops
 * endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * KeyWords: Hash Table, Math
 * Difficulty: Easy
 */
public class LeetCode202_HappyNumber {
    // The idea is to use one IntroductiontoAlgorithm.hash set to record sum of every digit square of every number occurred. Once the current sum
    // cannot be added to set, return false; once the current sum equals 1, return true;
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }

    //My Solution
    public boolean isHappy2(int n) {
        int tmp = 0, m = 0;
        if (n < 0) {
            return false;
        }
        if (n < 10) {
            if (n == 1 || n == 7)
                return true;
            else
                return false;
        } else {
            while (n != 0) {
                tmp = n % 10;
                m += tmp * tmp;
                n = n / 10;
            }
            return isHappy2(m);
        }
    }
}
