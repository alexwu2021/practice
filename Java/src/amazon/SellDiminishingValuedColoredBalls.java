package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class SellDiminishingValuedColoredBalls {
    private static int MOD = 1000_000_000 + 7;
    public int maxProfit(int[] inv, int m){
        Arrays.sort(inv);
        int ci = inv.length - 1, cv = inv[ci];
        long ans = 0;
        while (m > 0) {
            while (ci >= 0 && inv[ci] == cv) { ci--;}
            int nextValue = ci < 0 ? 0 : inv[ci];
            int numSameColor = inv.length - 1 - ci;
            int n = (cv - nextValue) * numSameColor;
            if (m >= n) { // buy all items
                ans += (long)(cv + nextValue + 1) * (cv - nextValue) / 2 * numSameColor;
            } else { // m left is less than the number of items to buy
                int numFullRow = m / numSameColor, rem = m % numSameColor;
                ans += (long)(cv + cv - numFullRow + 1) * numFullRow / 2 * numSameColor;
                ans += (long)(cv - numFullRow) * rem;
            }
            m -= n;
            ans = ans % MOD;
            
            cv = nextValue;
        }
        return (int)ans;
    }


    /**
     * This is mine, which can only pass 7 test cases, will lead to TLE
     * @param inv
     * @param m
     * @return
     */
    public int maxProfit2(int[] inv, int m) {
        int ans = 0;
        List<Integer> lst = new ArrayList<>();
        while(m > 0){
            lst.clear();
            int[] mx = max(inv, lst);
            int first = mx[0], second = mx[1];
            if((first-second) * lst.size() <= m){
                m -= (first-second) * lst.size();
                int temp = 0;
                temp = moduloMult(first  , (first + 1)) / 2 - moduloMult(second , (second+1)) /2;
                ans = (ans + (temp) * lst.size()) % MOD;
                for(int index: lst)
                    inv[index] = second;
            }else{
                while(m > 0 && lst.size() > 0){
                    inv[lst.get(0)] = mx[0]-1;
                    lst.remove(0);
                    ans = (ans + mx[0]) % MOD;
                    m--;
                }
            }
        }
        return ans;
    }

    int moduloMult(int a, int b) {
        int res = 0;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) > 0) res = (res + a) % MOD;
            a = (2 * a) % MOD;
            b >>= 1; // b = b / 2
        }
        return res;
    }

    private int[] max(int[] arr, List<Integer>st){
        int first = arr[0], second = 0;
        int i = 1;
        while(i < arr.length){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }
            i++;
        }
        for(int j=0; j<arr.length; ++j) {
            if (arr[j] == first) st.add(j);
            if (arr[j] != first && arr[j] > second) {
                second = arr[j];
            }
        }
        return new int[]{first,second};
    }
}
