package LeetCode;

/**
 * Roman to Integer
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * KeyWords: Math,String
 * Difficulty: Easy
 */
public class LeetCode013 {
    public static int romanToInt(String s) {
        int lastBigNum = charToInt(s.charAt(s.length() - 1));
        int num = lastBigNum;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (charToInt(s.charAt(i)) >= lastBigNum) {
                num += charToInt(s.charAt(i));
                lastBigNum = charToInt(s.charAt(i));
            } else {
                num -= charToInt(s.charAt(i));
            }
        }
        return num;
    }

    private static int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        int result;
        result = LeetCode013.romanToInt("MMCXCIX");
        System.out.println(result + "");
        int j = 123321;
        String s = j + "";
        char[] c = s.toCharArray();
        System.out.println(c.length);
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - i])
                System.out.println("false");
        }
    }

    //Better Solution:Easy to Understand
    public int romanToInt2(String s) {
        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum + nums[nums.length - 1];
    }
}
