package com.practice.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {
    /** assume the origin is (0, 0)
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        List<int[]> ret = new ArrayList<>();

        PriorityQueue<int[]>pq = new PriorityQueue<>((b, a) -> ((b[0] * b[0] + b[1] * b[1])
                -  (a[0] * a[0] + a[1] * a[1])) );
        for(int[] p : points){
            pq.add(p);
        }
        int count = 0;
        while(count < K && !pq.isEmpty()){
            ret.add(pq.poll());
            count++;
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
