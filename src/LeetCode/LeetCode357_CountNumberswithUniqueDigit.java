package LeetCode;

/**
 * Count Numbers with Unique Digit
 * <p>
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * Hint:
 * A direct way is to use the backtracking approach.
 * Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
 * <p>
 * KeyWords: Dynamic Programming, Backtracking, Math
 * Difficulty: Medium
 */
public class LeetCode357_CountNumberswithUniqueDigit {

    //Following the hint. Let f(n) = count of number with unique digits of length n.

    //        f(1) = 10. (0, 1, 2, 3, ...., 9)

    //f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.
    //f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij, we can pick k to form a 3 digit number ijk and there are 8 numbers that are different from i and j for k to choose from.
    //Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
    //any number with length > 10 couldn't be unique digits number.
    //The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + .. + f(n)

    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        if (n <= 10) {
            for (int i = 1; i <= n; i++) {
                int base = 9;
                for (int j = 0; j < i - 1; j++) {
                    base *= (9 - j);
                }
                sum += base;
            }
            sum++;//全0；
        }
        return sum;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
