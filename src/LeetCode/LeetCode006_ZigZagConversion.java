package LeetCode;

/**
 * ZigZag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * KeyWords: String，Logic
 * Difficulty: Easy
 */
public class LeetCode006_ZigZagConversion {
    public String convert(String s, int numRows) {
        String result = "";
        if (numRows <= 1)
            return s;
        for (int i = 0; i < s.length(); ) {
            result = result + s.charAt(i);
            i += (2 * numRows - 2);
        }
        int intval1 = 2 * numRows - 4;
        int intval2 = 2;
        for (int i = 1; i < numRows - 1; i++) {
            int count = 0;
            for (int j = i; j < s.length(); ) {
                if (count % 2 == 0) {
                    //System.out.println(intval1+ " ");
                    result = result + s.charAt(j);
                    j += intval1;
                    count++;
                } else {
                    result = result + s.charAt(j);
                    j += intval2;
                    count++;
                }
            }
            intval1 -= 2;
            intval2 += 2;
        }
        for (int i = numRows - 1; i < s.length(); ) {
            result = result + s.charAt(i);
            i += (2 * numRows - 2);
        }

        return result;
    }


    //Better Solution
    public String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }


    /* In order to get the final string, we need to scan from the left to right row by row.
     * For the first and last row, the difference between every two is 2 * nRow – 2, and
     * For the middle say i-th rows, the difference between every two is either 2 * nRow – 2 – 2 * i or 2 * i in turn.
     */
    public String convert3(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0)
            return "";
        if (nRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length())
                    res.append(s.charAt(j + size - 2 * i));
            }
        }
        return res.toString();
    }
}

