package com.practice.Easy;

import java.util.Arrays;

/**
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 *
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 *
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 *
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 */
public class DiffuseTheBomb {


    /**
     * largely borrowed from kevinw300 but changed post increment to pre increment
     *
     * using post increment
     * Runtime: 7 ms, faster than 5.99% of Java online submissions for Defuse the Bomb.
     * Memory Usage: 39.9 MB, less than 6.94% of Java online submissions for Defuse the Bomb.
     *
     * using preincrement
     * Runtime: 2 ms, faster than 40.06% of Java online submissions for Defuse the Bomb.
     * Memory Usage: 39.9 MB, less than 6.94% of Java online submissions for Defuse the Bomb.
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt(int[] code, int k){
        int len = code.length;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            int start = (k > 0) ? i + 1 : i + k;
            int end = (k > 0) ? i + k : i - 1;
            for (; start <= end; ++start) {
                res[i] += code[(start + len) % len];
            }
        }
        return res;
    }


    /**
     * Even this brute force implementation passed oj with the following stats:
     * Runtime: 1 ms, faster than 64.98% of Java online submissions for Defuse the Bomb.
     * Memory Usage: 39 MB, less than 62.78% of Java online submissions for Defuse the Bomb.
     *
     *
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt_initial_attempt(int[] code, int k) {
        int [] ret = new int[code.length];
        for(int i=0; i<code.length; ++i){
            int sum = GetSum(code, i, k);
            ret[i] = sum;
        }
        return ret;
    }

    private int GetSum(int[] code, int i, int k) {
        if(k == 0)
            return 0;

        int n = code.length;
        int ret = 0, s, e;
        if(k > 0){
            s = (n + i + 1) % n;
            e = (n + i + 1 + k -1) % n;
        }else{
            s = (n + i -1 + k + 1) % n;
            e = (n + i -1) % n;
        }

        if(e >= s){
            for(int p =s; p <= e; ++p)
                ret += code[p];
            return ret;
        }

        // 2 step summation
        int q;
        for(q =s; q < n; ++q)
            ret += code[q];
        for(q =0; q <= e; ++q)
            ret += code[q];

        return ret;
    }
}
