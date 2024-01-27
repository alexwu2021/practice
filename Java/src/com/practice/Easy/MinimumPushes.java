package com.practice.Easy;

import java.util.PriorityQueue;

/**
 * You are given a string word containing distinct lowercase English letters.
 *
 * Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
 *
 * It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
 *
 * Return the minimum number of pushes needed to type word after remapping the keys.
 *
 * An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.
 */
public class MinimumPushes {

    // a greedy algo: try to use the first batch of 8 cells, with a cost of 1
    // then use the next batch of 8, with cost of 2
    // so on
    public int minimumPushes(String word) {
        int ans = 0;
        int cost = 1;
        for(int i=0;i < word.length(); ++i){
            if(i > 0 && i % 8 == 0){ // need figure the correct value for the cost of pushing a char successfully
                cost++;
            }
            ans += cost;
        }
        return ans;
    }

    public int minimumPushes_TheClumsyWay(String word) {
        int pushCount = 0;

        int[] freq = new int[26];
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->(b[1]-a[1]));
        for(int i =0; i< freq.length; ++i){
            if(freq[i] > 0)
                pq.offer(new int[]{i, freq[i]});
        }

        int round = 0, capacity = 8;
        while(!pq.isEmpty()) {
            int[] front = pq.poll();
            int times = front[1];
            if (capacity > 0) {
                capacity--;
            } else {
                capacity = 7;
                round++;
            }
            int val = round + 1;
            pushCount += times * val;
        }
        return pushCount;

    }

}
