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

}
