//
// Created by alex wu on 11/21/23.
//

#include "CircularMaxSubarraySum.h"



    int CircularMaxSubarraySum::maxSubarraySumCircular(vector<int>& A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int& a : A) {
            curMax = max(curMax + a, a);
            maxSum = max(maxSum, curMax);
            curMin = min(curMin + a, a);
            minSum = min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? max(maxSum, total - minSum) : maxSum;
    }



//    static int minS(int x, int y) { return x < y ? x : y ; }
//    static int maxS(int x, int y) { return x > y ? x : y ; }
//
//    int Kadane( int l , int r , vector<int>& v , function<int(int, int)> comp){
//        //can be used to find maxSubarray sum and also , minSubarray sum , by changing the comp function.
//        int g = v[l] ;
//        int s = v[l] ;
//        for(int i =  l + 1 ; i <= r ; ++i){
//            s = comp( s + v[i] , v[i] ) ;
//            g = comp( s , g ) ;
//        }
//        return g ;
//    }
//
//    int maxSubarraySumCircular_easy_to_understand(vector<int>& nums) {
//        int n = nums.size() , sum = 0 ;
//        bool allNegative = true ;
//        for(auto &x : nums){
//            sum += x ;
//            if(x >= 0 ) allNegative = false ;
//        }
//
//        int maxSubarraySum = Kadane( 0 , n-1 , nums , &maxS ) ;
//        if( allNegative ) return maxSubarraySum ;
//
//        int maxSubarrayCircularSum = sum - Kadane(0 , n-1 , nums , &minS ) ;
//        return max( maxSubarraySum , maxSubarrayCircularSum ) ;
//    }


