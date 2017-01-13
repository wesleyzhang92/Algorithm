package LeetCode;

/**
 * Power of Four
 * <p>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * <p>
 * KeyWords: Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode342_PowerofFour {

    public boolean isPowerOfFour(int num) {
        if (num == 1)
            return true;
        if (num <= 0)
            return false;
        if ((num & 0x03) != 0)
            return false;

        return isPowerOfFour(num / 4);

    }

    // No Recursion version
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    //Nice Idea but actually slow
    public boolean isPowerOfFour3(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
