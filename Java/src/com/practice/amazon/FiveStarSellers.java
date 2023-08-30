package com.practice.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


//class IntegerArrayComparator implements Comparator<int[]> {
//
//    // Overriding compare()method of Comparator
//    // for descending order of cgpa
//    public int compare(int[] s1, int[] s2) {
//        if (((float)s1[0])/s1[1] > ((float)s2[0])/s2[1])
//            return -1;
//        else if (((float)s1[0])/s1[1] < ((float)s2[0])/s2[1])
//            return 1;
//        else{
//            if (s1[0] < s2[0])
//                return -1;
//            else if (s1[0] > s2[0])
//                return 1;
//            else {
//                return 0;
//            }
//        }
//    }
//}


/**
 * find out the number of minimal number of 5 star reviews to add
 * such that the the simple average of reviews for the compnay's product will reach the threshold
 */
public class FiveStarSellers {
    int fiveStartReviews(int[][] productRatings, int ratingsThreshold){
        int ret = 0;

        while(getRatings(productRatings) < ((float)ratingsThreshold/100) ){
            int index = -1;
            float max = 0;
            for(int i = 0; i < productRatings.length; ++i){
                int[] pr = productRatings[i];
                if(pr[0] == pr[1]) continue;

                float after = ((float)(pr[0] + 1)) / (pr[1] + 1);
                float before = ((float)(pr[0])) / (pr[1] );
                if(max < after - before){
                    max = after - before;
                    index = i;
                }

            }
            productRatings[index][0] += 1;
            productRatings[index][1] += 1;
            ret ++;
        }
       return ret;
    }

    private float getRatings(int[][] arrs) {
        float fval = 0;
        for(int[] arr : arrs) {
            float temp = ((float)arr[0])/arr[1];
            fval += temp;
        }
        return fval/arrs.length;
    }
}
