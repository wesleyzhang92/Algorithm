package LeetCode;

/**
 * Count Primes
 * <p>
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 * Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any
 * number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers
 * up to n would be O(n2). Could we do better?
 * <p>
 * KeyWords: HashTable, Math
 * Difficulty: Easy
 */
public class LeetCode204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    //My Solution
    public int countPrimes2(int n) {
        int count = 0;
        if (n == 0)
            return 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
