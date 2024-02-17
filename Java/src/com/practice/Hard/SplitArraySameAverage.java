package com.practice.Hard;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class SplitArraySameAverage {

    public boolean splitArraySameAverage(int[] A) {

        int length = A.length, half = length / 2, total = Arrays.stream(A).sum();

        Set<Integer>[] hashSets = new HashSet[half + 1]; // [0, 1, ..., half] --> [Set(), Set(), ..., Set()]
        for(int i = 0; i < hashSets.length; ++i) {
            hashSets[i] = new HashSet<>();
        }
        hashSets[0].add(0);

        for(int n : A) {
            for(int i = half; i >= 1; --i) {
                for(int knapSum : hashSets[i - 1]) {
                    int sumUpToI = knapSum + n; // try each val from stage i-1
                    if(sumUpToI * (length - i) == (total - sumUpToI) *i)  // sumUpToI / i === (total - sumUpToI ) / (length -i)
                        return true;

                    hashSets[i].add(sumUpToI);
                }
            }
        }
        return false;
    }

}
