package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * KeyWords: Backtracking,String,DFS
 * Difficulty: Medium
 */
public class LeetCode022_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }

    public static void main(String[] args){
        LeetCode022_GenerateParenthesis Solution = new LeetCode022_GenerateParenthesis();
        List<String> res=Solution.generateParenthesis(3);
        System.out.println(res);
    }

    /**
     * Integer to String
     * <p>
     * Given an integer, convert it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * KeyWords: Math,String
     * Difficulty: Easy
     */
    public static class LeetCode012 {
        public static String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    sb.append(strs[i]);
                }
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            String result;
            result = intToRoman(2199);
            System.out.println(result);
        }
    }
}
