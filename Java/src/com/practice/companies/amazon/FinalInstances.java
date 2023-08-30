package com.practice.companies.amazon;

/**
 * no action in the next 10 seconds
 * > 60%, double till to limit 2*power(10, 8)
 * < 25%, half if number of instance is greater than 1
 */
public class FinalInstances {

    static final int LIMIT = 100000;

    int getFinalNumberOfInstances(int initail, int[] averageUtil){
        int ret = initail;

        int n = averageUtil.length -1;
        int i = 0;
        boolean taken = false;
        while(i <= n){
            if(averageUtil[i] > 60){
                if(ret < LIMIT){
                    ret *= 2 ;
                    taken = true;
                }
            }else if(averageUtil[i] < 25){
                if(ret > 1){
                    ret = (int)Math.round(Math.ceil((double)ret / 2)) ;
                    taken = true;
                }
            }
            if(taken){
                i += 10;
                taken = false;
            }
            else{
                i++;
            }
        }
        return ret;
    }
}
