package com.practice.Medium;

public class NthUgliestNumber {

    /** passed oj
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] curr = new int[primes.length];

        for(int i = 1; i<n; ++i) {
            res[i] = Integer.MAX_VALUE;

            // we try to test the value res[i-1]
            // it must be a res[i-1] because the current one is MAX_VALUE
            // to see if it can be expressed in {the current prime,
            // and the corresponding resulting value for the current prime
            for(int j= 0; j<primes.length; ++j){
                if(res[i-1] == res[curr[j]] * primes[j])
                    curr[j]++;
                res[i] = Math.min(res[i], res[curr[j]] * primes[j]);
            }

        }
        return res[n-1];
    }
}
