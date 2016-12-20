package LeetCode;

/**
 * Created by wesley on 2016/12/20.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * KeyWords: Two Pointers, String
 * Difficulty: Easy
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        // StringBuilder sb = new StringBuilder();
        if(s==null)
            return false;
        if(s.length()==1)//边界条件检查
            return true;
        char left=' ',right=' ';
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            while(i<j&&!isChar(s.charAt(i))){//边界条件
                i++;
            }
            left=Character.toLowerCase(s.charAt(i));
            //System.out.println(left+" l");
            while(j>i&&!isChar(s.charAt(j))){
                j--;
            }
            right=Character.toLowerCase(s.charAt(j));
            //System.out.println(right+" r");
            if(left!=right){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
    public boolean isChar(char a){
        if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || a >= '0' && a <= '9')
            return true;
        return false;
    }


    //Use Character function
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
