package com.practice.Easy;
import java.util.*;
public class NumPrimeArrangement {
    /**
     *
     *  Total_cnt = prime_cnt! * (N - prime_cnt)!
     *
     *     For example:
     *     -----------
     *
     *         [1, 2, 3, 4, 5]
     *             _  _     _
     *
     *         prime_cnt -> 3 {Underlined indices are prime indices}
     *         and also number at those indices are prime numbers.
     *
     *         non_prime_cnt -> (N - prime_cnt) -> (5 - 3) -> 2
     *
     *         Total valid permutations : 3! * 2! -> 6 * 2 -> 12
     *
     * @param n
     * @return
     */
    public int numPrimeArrangements(int n) {
        int MOD = (int) (1e9 + 7), cnt = 0;

        // sieve
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n+1, true);

        for(int i=2; i * i <= n; ++i) {
            if (!prime[i])  continue;
            for(int j = i*i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        long ret = 1;
        for (boolean b : prime)  cnt += (b ? 1 : 0);

        // factorial
        for (int i=2; i <= cnt; ++i)  ret = (ret * i) % MOD;
        for (int i=2; i <= n - cnt; ++i) ret = (ret * i) % MOD;

        return (int) ret;
    }
}
