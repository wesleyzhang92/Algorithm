package LeetCode;

/**
 * Detect Capital
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * <p>
 * Difficulty: Easy
 * KeyWords: String
 */
public class LeetCode520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] c = word.toCharArray();
        if (c.length <= 1)
            return true;
        boolean iCap = false;
        if (isCap(c[1])) {
            if (isCap(c[0])) {
                iCap = true;
            } else {
                return false;
            }
        }
        for (int i = 2; i < c.length; i++) {
            if (iCap && !isCap(c[i])) {
                return false;
            }
            if (!iCap && isCap(c[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isCap(char c) {
        if (c >= 65 && c <= 90)
            return true;
        return false;
    }
}
