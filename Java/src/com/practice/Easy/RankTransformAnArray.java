package com.practice.Easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Rank Transform of an Array
 * Easy
 *
 * 680
 *
 * 45
 *
 * Add to List
 *
 * Share
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 *
 *
 * Example 1:
 *
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 * Example 2:
 *
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 * Example 3:
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 */
public class RankTransformAnArray {
    /**
     * a litle bit faster
     * @param arr
     * @return
     */
    public int[] arrayRankTransform_pq(int[] arr) {
        int[]res = new int[arr.length];

        Set<Integer> st = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        Queue<Integer> pq = new PriorityQueue<>();
        for(int n : st) pq.offer(n);

        Map<Integer, Integer> mp = new HashMap<>();
        int r = 1;
        while(!pq.isEmpty()){
            mp.put(pq.poll(), r++);
        }

        int i = 0;
        for(; i<arr.length; ++i) res[i] = mp.get(arr[i]);
        return res;
    }

    public int[] arrayRankTransform(int[] arr) {
        int[]res = new int[arr.length];

        Set<Integer> st = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int[] ia = st.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ia);
        Map<Integer, Integer> mp = new HashMap<>();

        for(int j = 0; j<ia.length; ++j) mp.put(ia[j], j+1);

        int i = 0;
        for(; i<arr.length; ++i) res[i] = mp.get(arr[i]);
        return res;
    }
}
