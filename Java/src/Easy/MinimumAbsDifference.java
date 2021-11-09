package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 */
public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length <= 1) return res;
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; ++i){
            diff = Math.min(diff, arr[i] - arr[i-1]);
        }
        for(int i=0; i<arr.length-1; ++i){
            if(arr[i+1] - arr[i] <= diff){
                List<Integer>lst2 = new ArrayList<>();
                lst2.add(arr[i]);
                lst2.add(arr[i+1]);
                res.add(lst2);
            }
        }
        return res;
    }
}
