package LeetCode;

/**
 * Plus One
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * KeyWords: Array,Math
 * Difficulty: Easy
 */
public class LeetCode066 {
    public int[] plusOne(int[] digits) {
        if(digits.length==0)
            return null;
        int size=digits.length-1;
        int[] ret = new int[size+2];
        digits[size]+=1;
        while(size>0&&digits[size]==10){
            digits[size]=0;
            digits[--size]+=1;
        }
        if(digits[0]==10){
            ret[0]=1;
            for(int i=1;i<ret.length;i++){
                ret[i]=0;
            }
            return ret;
        }
        return digits;

    }

    public int[] plusOne2(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
