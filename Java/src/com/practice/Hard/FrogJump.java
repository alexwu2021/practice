package com.practice.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 403. Frog Jump
 *
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 */
public class FrogJump {

    static int size = 2000;
    int[][]dp = new int[size + 1][size + 1];
    Map<Integer, Integer> tracker = new HashMap<>();

    private boolean solve( int[] stones, int i, int prev) {
        if(i == stones.length-1) return true;

        if(dp[i][prev] != -1){
            return dp[i][prev] == 1;
        }

        boolean ans = false;
        for(int k = prev-1; k<= prev+1; k++){
            if(k > 0 && tracker.containsKey(stones[i] + k)){
                ans = ans || solve(stones, tracker.get(stones[i] + k), k);
            }
        }
        dp[i][prev] = (ans ? 1 :0); //TODO: this is the key line
        return ans;
    }

    public boolean canCross(int[] stones) {
        for(int i = 0; i< stones.length; ++i){
            tracker.put(stones[i], i);
        }
        for(int j=0; j<=size; ++j){
            Arrays.fill(dp[j], -1);
        }
        return solve(stones, 0, 0);
    }

}
