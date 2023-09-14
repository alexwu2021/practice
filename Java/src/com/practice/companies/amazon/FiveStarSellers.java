package com.practice.companies.amazon;


/**
 * find out the number of minimal number of 5 star reviews to add
 * such that the simple average of reviews for the compnay's product will reach the threshold
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
