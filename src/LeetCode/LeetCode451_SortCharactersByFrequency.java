package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sort Characters By Frequency
 * <p>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * <p>
 * KeyWords: HashTable, Heap
 * Difficulty: Medium
 */
public class LeetCode451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap();
        char[] charArray = s.toCharArray();
        int max = 0;
        for (Character c : charArray) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            max = Math.max(max, map.get(c));
        }

        List<Character>[] array = buildArray(map, max);

        return buildString(array);
    }

    private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
        List<Character>[] array = new List[maxCount + 1];
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (array[count] == null) {
                array[count] = new ArrayList();
            }
            array[count].add(c);
        }
        return array;
    }

    private String buildString(List<Character>[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            List<Character> list = array[i];
            if (list != null) {
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    //Bucket Sort
    public String frequencySort2(String s) {
        if (s.length() < 3)
            return s;
        int max = 0;
        int[] map = new int[256];
        for (char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max, map[ch]);
        }
        String[] buckets = new String[max + 1]; // create max buckets
        for (int i = 0; i < 256; i++) { // join chars in the same bucket
            String str = buckets[map[i]];
            if (map[i] > 0)
                buckets[map[i]] = (str == null) ? "" + (char) i : (str + (char) i);
        }
        StringBuilder strb = new StringBuilder();
        for (int i = max; i >= 0; i--) { // create string for each bucket.
            if (buckets[i] != null)
                for (char ch : buckets[i].toCharArray())
                    for (int j = 0; j < i; j++)
                        strb.append(ch);
        }
        return strb.toString();
    }
}
