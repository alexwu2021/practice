package com.practice.Easy;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 * Accepted
 * 101,097
 * Submissions
 * 186,801
 */
public class KokoEatsBanana {

    public int minEatingSpeed(int[] piles, int H) {
        int hi = Integer.MIN_VALUE;
        for(int p: piles) hi = Math.max(hi, p);
        int lo = 1;
        while(lo <= hi){ // the equal is a must, the last test case verifies this point
            int k = lo + ((hi - lo) >> 1); // the bracket is necessary
            if (canFinish(piles, k, H))
                hi = k-1;
            else
                lo = k+1;
        }
        return lo;
    }

    private boolean canFinish(int[] piles, int exp, int h){
        int hn = 0;
        for(int p: piles) hn +=  (int)Math.ceil((double)p/exp);
        return hn <= h;
    }
}
