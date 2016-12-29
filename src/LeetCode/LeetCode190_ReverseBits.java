package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverse bits
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * <p>
 * KeyWords: Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode190_ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
            int temp = n & 0x01;
            n = n >> 1;

            result = (result << 1) | temp;
            i++;
        }
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    //How to optimize if this function is called multiple times? We can divide an int into 4 bytes, and reverse
    //each byte then combine into an int. For each byte, we can use cache to improve performance.无符号右移的规则只记住一点：
    // 忽略了符号位扩展，0补最高位  无符号右移运算符>>> 只是对32位和64位的值有意义
    // cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits3(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) // convert int into 4 bytes
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3)
                result <<= 8;
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b); // first look up from cache
        if (value != null)
            return value;
        value = 0;
        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
}
