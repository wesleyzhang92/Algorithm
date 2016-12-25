package LeetCode;

import java.util.Stack;

/**
 * Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * KeyWords: Stack,String
 * Difficulty: Easy
 */
public class LeetCode020_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> astack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp=='('||tmp=='['||tmp=='{')
                astack.push(tmp);
            else{
                if(astack.empty())
                    return false;
                char tmp1=astack.pop();
                if(tmp==')'&&tmp1!='(')
                    return false;
                if(tmp==']'&&tmp1!='[')
                    return false;
                if(tmp=='}'&&tmp1!='{')
                    return false;
            }
        }
        return astack.empty();
    }


    //Better Solution:工整、去掉冗余代码
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}
