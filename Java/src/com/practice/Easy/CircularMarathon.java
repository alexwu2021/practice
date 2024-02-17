package com.practice.Easy;

import java.util.List;
import java.util.stream.*;

//# Input: n = 4, rounds = [1,3,1,2]
//        Output: [1,2]
//        Explanation: The marathon starts at sector 1. The order of the visited sectors is as follows:
//        1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)

//round 1: from 1 to 3 inclusively, so we have [1, 2, 3]
//round 2: from 3 to 1 inclusively, so we have [3, 4, 1]
//round 3: from 1 to 2 inclusively, so we have [1, 2]
//
//frequence of 1: 3
//frequence of 2: 2

//        We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors. Sectors 3 and 4 are visited only once.
//        Example 2:
//
//        Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
//        Output: [2]
//        Example 3:
//
//        Input: n = 7, rounds = [1,3,5,7]
//        Output: [1,2,3,4,5,6,7]

/**
 * Given an integer n and an integer array rounds. We have a circular track which consists of n sectors labeled from 1 to n. A marathon will be held on this track, the marathon consists of m rounds. The ith round starts at sector rounds[i - 1] and ends at sector rounds[i]. For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]
 *
 * Return an array of the most visited sectors sorted in ascending order.
 *
 * Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction (See the first example).
 *
 * anti-clockwise
 */
public class CircularMarathon {
    public List<Integer> mostVisited(int n, int[] rounds){
        if (rounds[rounds.length - 1] >= rounds[0]){
            return IntStream.range(rounds[0], rounds[rounds.length - 1] + 1).boxed().collect(Collectors.toList());
        }
        IntStream base = IntStream.range(1, rounds[rounds.length - 1] + 1), extra = IntStream.range(rounds[0], n + 1);
        return IntStream.concat( base, extra).boxed().collect(Collectors.toList());
    }
}
