package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 */
public class ArithmeticSlices2 {


    public int numberOfArithmeticSlices_dp(int[] nums) {
        int ret = 0;

        int n = nums.length;
        // setting the key as Long is because we might have test case like [0,2000000000,-294967296]
        // under that circumstance we would see overflow if using Integer as the type for the keys

        // dp[i] stores the map up to and including the current index i, from which we can draw the conclusion.
        // dp[i] could totally different from dp[i -1], it is not a copy forward
        // dp[i] records all the frequencies for all the possible keys
        // the keys are depending on the diff, which is calculated consistently by nums[i] - nums[j] where i > j
        // so even if there are blocks between the head part and the body part of a slice, the calculation is still valid

        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i)
            dp[i] = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - (long)nums[j];
                int count = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);

                // this is valid because we starts from i == 1
                // and because any addition to the current frequency count means another valid slice
                ret += count;
            }
        }
        return ret;
    }


    //------------------- this is not a generic solution -----------------------

    public int numberOfArithmeticSlices_plain(int[] nums) {
        int ret = 0;
        int n = nums.length;
        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 3; i<=n; ++i){
            for(int j = 0; j<n; ++j){
                int temp =numberOfArithmeticSlicesHelper(nums, i, j, lst);
                ret += temp;
//                ret += numberOfArithmeticSlicesHelper(nums, i, j);
            }
        }
        return ret;
    }

    /**
     * @param nums
     * @param i the length of a slice
     * @param j starting index
     * @return
     */
    private int numberOfArithmeticSlicesHelper(int[] nums, int i, int j,  List<List<Integer>> lst)
    {
        int n = nums.length;
        if(j >= n || j + i > n)
            return 0;

        int ret = 0;
        int x1 = nums[j];

        for(int k = 1; k < n; ++k){
            List<Integer> ll = new ArrayList<>();
            int r = j + k;
            if(r >= n){
                break;
            }

            int x2 = nums[r];
            int diff = x2 - x1;
            int count = 2;
            ll.add(x1);
            ll.add(x2);

            while(r < n){
                r += k;
                if(r >= n && count < i){
                    break;
                }
                if(nums[r] - x2 != diff){
                    ll.clear();
                    break;
                }
                else{
                    count++;
                    x2 = nums[r];
                    ll.add(x2);
                    if(count == i){
                        ret += 1;
                        lst.add(ll);
                        break;
                    }
                }
            }
        }
        return ret;
    }
}
