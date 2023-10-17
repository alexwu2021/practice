package com.practice.Hard;


import java.util.*;

/**
 * There are n cars traveling at different speeds in the same direction along a one-lane road.
  * You are given an array cars of length n, where cars[i] = [positioni, speedi] represents:
 *
 * positioni is the distance between the ith car and the beginning of the road in meters. It is guaranteed
 * that positioni < positioni+1.
 *
 * speedi is the initial speed of the ith car in meters per second.
 * For simplicity, cars can be considered as points moving along the number line.
 * Two cars collide when they occupy the same position. Once a car collides with another car, they unite
 * and form a single car fleet. The cars in the formed fleet will have the same position and the same speed,
 * which is the initial speed of the slowest car in the fleet.
 *
 * Return an array answer, where answer[i] is the time, in seconds, at which the ith car collides with
 * the next car, or -1 if the car does not collide with the next car. Answers within 10-5 of the actual answers
 * are accepted.
 */
public class CarFleetII {

    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        for(int i= 0; i<n; ++i) ans[i] = -1;
        List<int[]> lst = Arrays.asList(cars);

        boolean changed;
        do{
            changed = false;
            double secNeeded = Double.MAX_VALUE;
            int begin = -1, end = -1;
            for(int i=lst.size()-1; i>= 1; --i){
                if(lst.get(i)[0] == -1) continue;
                int j = i-1;
                if(lst.get(j)[1] > lst.get(i)[1]) {
                    secNeeded = Math.min(secNeeded, (double)(lst.get(i)[0] - lst.get(j)[0]) / (lst.get(j)[1] - lst.get(i)[1]));
                    begin = j;
                    end = i;
                }
            }

            if(begin != -1 && end != -1 && secNeeded > 0){
                lst.set(end, new int[]{-1, -1});
                ans[begin] = secNeeded;
                for (int i = 0; i < lst.size(); i++) {
                    if(lst.get(i)[0] != -1)
                        lst.set(i, new int[]{lst.get(i)[0] + (int)secNeeded, lst.get(i)[1]});
                }
                changed = true;
            }
        }while(changed);

        return ans;
    }

}
