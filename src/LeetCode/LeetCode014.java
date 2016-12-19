package LeetCode;

/**
 * Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * 关键词：String
 * 难度：Easy
 */
public class LeetCode014 {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        Out://跳出多重循环的标签
        for(int i=0;i<strs[0].length();i++){
            char tmp= strs[0].charAt(i);
            System.out.println("tmp"+tmp+"");
            for(int j=1;j<strs.length;j++){
                System.out.println(strs[j].charAt(i));
                if(strs[j].length()<=i||strs[j].charAt(i)!=tmp){
                    System.out.println("Inside");
                    break Out; //跳出循环
                }
            }
            sb.append(tmp+"");
            System.out.println("sb "+sb+"");
        }

        return sb.toString();
    }


    //Better Solution:找到和每一个的最长公共子序列，继续向前找
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }


    public static void main(String[] args){
        String[] strs={"aaac","aacb","aabb"};
        System.out.println(longestCommonPrefix(strs));

    }
}
