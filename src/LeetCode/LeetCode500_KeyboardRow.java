package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Keyboard Row
 * <p>
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * <p>
 * <p>
 * American keyboard
 * <p>
 * <p>
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * <p>
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode500_KeyboardRow {
    public String[] findWords(String[] words) {
        if (words == null)
            return new String[0];
        String[] r = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> rets = new ArrayList<String>();
        for (String ws : words) {
            String w = ws.toLowerCase();
            char first = w.charAt(0);
            int in = 0;
            while (in < 3) {
                if (r[in].contains(first + ""))
                    break;
                in++;
            }
            boolean all = true;
            for (int i = 1; i < w.length(); i++) {
                if (!r[in].contains(w.charAt(i) + "")) {
                    all = false;
                    break;
                }
            }
            if (all) {
                rets.add(ws);
            }
        }
        return rets.toArray(new String[0]);
    }
}
