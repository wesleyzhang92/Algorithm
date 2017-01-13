package LeetCode;

/**
 * Bulls and Cows
 * <p>
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * For example:
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class LeetCode299_BullsandCows {
    public String getHint(String secret, String guess) {
        char[] c1 = secret.toCharArray();
        char[] c2 = guess.toCharArray();
        int count = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[i]) {
                count++;
                c1[i] = ' ';
                c2[i] = ' ';
            }
        }
        int other = 0;
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == ' ' || c2[j] == ' ')
                    continue;
                if (c1[i] == c2[j]) {
                    other++;
                    c1[i] = ' ';
                    c2[j] = ' ';
                }
            }
        }
        return count + "A" + other + "B";
    }

    //The idea is to iterate over the numbers in secret and in guess and count all bulls right away. For cows maintain an
    // array that stores count of the number appearances in secret and in guess. Increment cows when either number from
    // secret was already seen in guest or vice versa.
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
