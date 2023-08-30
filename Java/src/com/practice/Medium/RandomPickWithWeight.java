package com.practice.Medium;

import java.util.Random;
import java.util.TreeMap;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function
 * pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 */
public class RandomPickWithWeight {

    int count = 0;
    TreeMap<Integer, Integer> mp = new TreeMap<>();
    Random rand = new Random();
    public RandomPickWithWeight(int[] w) {
        for (int i = 0; i < w.length; ++i){
            count += w[i];
            mp.put(count, i);
        }
    }

    public int pickIndex() {
        // also can try ceilingKey(rand.nextInt(count)+1)
        int key = mp.higherKey(rand.nextInt(count));
        return mp.get(key);
    }
}
