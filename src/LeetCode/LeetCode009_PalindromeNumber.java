package LeetCode;

/**
 * Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * <p>
 * KeyWords: Math
 * Difficulty: Easy
 */
public class LeetCode009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        String s = x + "";
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - i - 1])
                return false;
        }

        return true;
    }

    //Better Solution
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
