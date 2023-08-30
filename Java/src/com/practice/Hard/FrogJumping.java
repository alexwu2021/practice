package com.practice.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumping {

    /** passed oj
     *  still dp but the solution is directly from the question
     *  A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
     *
     * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
     *
     * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        if( stones == null || stones.length == 0 || stones[0] != 0 || stones[1] !=1 ){
            return false;
        }

        if( stones[stones.length - 1] > (stones.length * (stones.length - 1)) / 2) //too far off
            return false;

        Map<Integer, Set<Integer>> mp = new HashMap<>(stones.length);
        for (int stone: stones) mp.put(stone, new HashSet<>() );

        //give the initial push
        mp.get(0).add(1);

        for (int stone: stones) {
            for (int step : mp.get(stone)) {
                int reach = step + stone;

                if (reach == stones[stones.length - 1]) return true;
                Set<Integer> set = mp.get(reach);
                if (set != null) {
                    //all the three choices
                    set.add(step);
                    set.add(step + 1);
                    if (step - 1 > 0) set.add(step - 1);
                }
            }
        }
        return false;
    }
}
