package LeetCode;

import java.security.PublicKey;

/**
 * Count and Say
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * KeyWords: String
 * Difficulty: Easy
 */
public class LeetCode038_CountandSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++)
            s = countAndSay(s);
        return s;
    }
    static String countAndSay(String str) {
        String say = "";
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) count++;
            else {
                say  += count + "" + str.charAt(i);
                count = 1;
            }
        }
        say  += count + "" + str.charAt(str.length() - 1);
        return say;
    }


    //Better Solution
    public String countAndSay2(int n) {
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }
}
