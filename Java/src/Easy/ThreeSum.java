package Easy;

import java.util.*;

public class ThreeSum {

    /** passed oj
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        if(nums == null || nums.length <= 2) return new ArrayList<>(st);
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; ++i){
            int j = i + 1, k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    st.add(Arrays.asList(new Integer[]{nums[i], nums[j++], nums[k--]}));
                }else if(sum > 0){
                    k--;
                } else{
                    j++;
                }
            }
        }
        return new ArrayList<>(st);
    }
}
