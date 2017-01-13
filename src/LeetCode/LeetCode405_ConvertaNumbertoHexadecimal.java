package LeetCode;

/**
 * Convert a Number to Hexadecimal
 * <p>
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 * KeyWords: Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode405_ConvertaNumbertoHexadecimal {

    /*Basic idea: each time we take a look at the last four digits of
            binary version of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.*/

    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

    //To deal with negative number, the number is masked against long data type. This process will convert it to a
    // positive long number. A simple while loop is then use to extract each base digit until number becomes `0`.
    //For Integer.MAX_VALUE or Integer.MIN_VALUE or any input with 8 Hexadecimal characters where the iterations would
    //last the longest. For Integer.MAX_VALUE the algorithm will run for at most `ceil(log_16 (2^31 - 1) + 1) = 8` times.
    public String toHex2(int num) {
        long n = num & 0x00000000ffffffffL;
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, map[(int) (n % 16)]);
            n = n / 16;
        }
        return num == 0 ? "0" : sb.toString();
    }
}
