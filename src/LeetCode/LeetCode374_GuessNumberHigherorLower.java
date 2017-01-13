package LeetCode;

/**
 * Guess Number Higher or Lower
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 * <p>
 * KeyWords: Binary Search
 * Difficulty: Easy
 */
public class LeetCode374_GuessNumberHigherorLower {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
    private int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i <= j) {
            int m = i + (j - i) / 2;
            int g = guess(m);
            if (g == 0) return m;
            if (g == -1) j = m - 1;
            else i = m + 1;
        }
        return i;
    }
}
