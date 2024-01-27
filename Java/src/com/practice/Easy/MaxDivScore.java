package com.practice.Easy;

import java.util.*;

public class MaxDivScore {

    public int maxDivScore(int[] nums, int[] divisors) {
        int score, mx = 0;
        Map<Integer, List<Integer>>mp = new HashMap<>();
        for(int d: divisors){
            score = 0;
            for(int n: nums){
                if(n % d == 0){
                    score++;
                }
            }
            if(score >= mx){
                mx = score;
                mp.computeIfAbsent(mx, x->new ArrayList<>()).add(d);
            }
        }
        List<Integer>candidates = mp.get(mx);
        Collections.sort(candidates);
        return candidates.get(0);
    }
}
