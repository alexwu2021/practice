package com.practice.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ReplaceWithRightLargest {
    public List<Integer> replaceElements(List<Integer> arr) {
        int n = arr.size();
        int[]ans = new int[n];

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(int i=1; i<n; ++i){
            pq.add(new int[]{arr.get(i), i});
        }

        int[] top = pq.poll();
        for(int j = 0; j<= n-2; ++j){

            while (top[1] <= j && !pq.isEmpty()){
                top = pq.poll();
            }
            ans[j] = top[0];
        }
        ans[n-1] = -1;

        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i<ans.length; ++i){
            ret.add(ans[i]);
        }
        return ret;
    }
    public static void main(String[] args){
        ReplaceWithRightLargest sol = new ReplaceWithRightLargest();
        List<Integer> actual, arr;
//        arr = [17,18,5,4,6,1]
//        Output: [18,6,6,6,1,-1]

        arr = Arrays.asList(new Integer[]{17,18,5,4,6,1});

        actual = sol.replaceElements(arr);

    }
}
