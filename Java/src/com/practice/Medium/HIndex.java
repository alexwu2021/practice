package com.practice.Medium;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {

    /**
     * This is my brute force solution, passed on the very first submission
     * 3 ms	 36 MB
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int ret = 0;
        Arrays.sort(citations);
        int startVal = 1, prevMax;
        do {
            prevMax = ret;
            int count = 0;
            int j = citations.length -1;
            while(count < startVal && j >= 0){
                if(citations[j--] >= startVal)
                    count++;
            }

            if(count >= startVal)
                ret = Math.max(ret, startVal);

            startVal++;
        }while(prevMax < ret);
        return ret;
    }


    /** Originally from tianyue_dup
     *
     * @param citations
     * @return
     */
    public int hIndex_better_byDefintion(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int len = citations.length;
        int hIndex = 0;
        for (int i = 0; i < len; ++i){

            // find the cut, and compare the value of the cell at i that has been cut with (len - i)
            // we get the hIndex if the inequality holds
            if(citations[i] >= len - i){
                hIndex = len - i;
                break;
            }
        }
        return hIndex;
    }
}
