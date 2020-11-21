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



    public List<List<Integer>> threeSum_wl(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                //两个指针,并且头指针从i + 1开始，防止加入重复的元素
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //元素相同要后移，防止加入重复的 list
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
