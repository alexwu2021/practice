package com.practice.Easy;

/**
 * 1534. Count Good Triplets
 * Easy
 *
 * 341
 *
 * 770
 *
 * Add to List
 *
 * Share
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
 *
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 *
 * Return the number of good triplets.
 */
public class CountGoodTriplets {

    public int countGoodTriplets_bruteForce(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;
        for(int i=0; i<n-2; ++i){
            for(int j=i+1; j<n-1; ++j){
                for(int k=j+1; k<n; ++k){
                    if(Math.abs(arr[i] - arr[j]) > a) continue;
                    if(Math.abs(arr[j] - arr[k]) > b) continue;
                    if(Math.abs(arr[i] - arr[k]) > c) continue;
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 10 ms, faster than 95.91% of Java online submissions for Count Good Triplets.
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) > b) continue;
                    if (Math.abs(arr[k] - arr[i]) > c) continue;
                    res++;
                }
            }
        }
        return res;
    }
}
