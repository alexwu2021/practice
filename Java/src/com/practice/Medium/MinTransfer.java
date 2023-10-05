package com.practice.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class MinTransfer {

    public int minTransfers(int[][] A) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int[] tx : A) {
            graph.put(tx[0], graph.getOrDefault(tx[0], 0) - tx[2]);
            graph.put(tx[1], graph.getOrDefault(tx[1], 0) + tx[2]);
        }
        List<Integer> balances = graph.values().stream().filter(v -> v != 0).collect(Collectors.toList());
        int n = balances.size();
        final int MAX_SIZE = 1 << n;
        int[] dp = new int[MAX_SIZE];
        int[] sums = new int[MAX_SIZE]; // the sum for each group size
        for (int groupSize = 0; groupSize < MAX_SIZE; ++groupSize) { // the size of subgroup whose sum is zero, [0, 2^n-1]
            int setBit = 1;
            for(int bal: balances){
                if ((groupSize & setBit) == 0) {
                    int next = groupSize | setBit;

                    sums[next] = sums[groupSize] + bal;
                    if (sums[next] == 0) {
                        dp[next] = Math.max(dp[next], dp[groupSize] + 1);
                    } else {
                        dp[next] = Math.max(dp[next], dp[groupSize]);
                    }
                }
                setBit <<= 1;
            }
        }
        return n - dp[dp.length - 1];
    }


}
