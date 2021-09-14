package Easy;

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
    public int[] decrypt(int[] code, int k) {
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

        int ret = 0, s, e;
        if(k > 0){
            s = (code.length + i + 1) % code.length;
            e = (code.length + i + 1 + k -1) % code.length;
        }else{
            s = (code.length + i -1 + k + 1) % code.length;
            e = (code.length + i -1) % code.length;
        }

        if(e > s){
            for(int p =s; p <= e; ++p)
                ret += code[p];
            return ret;
        }


        int q;
        for(q =s; q < code.length; ++q)
            ret += code[q];
        for(q =0; q <= e; ++q)
            ret += code[q];

        return ret;
    }
}
