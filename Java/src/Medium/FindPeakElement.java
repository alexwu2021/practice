package Medium;

public class FindPeakElement {

    public int findPeakElement_O_N(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        int curr = 0, i = 1;
        while( i < nums.length) {
            if(nums[i] < nums[curr]) {
                if(curr == 0){
                    return curr;
                }
                if (curr > 0 && nums[curr -1] < nums[curr]){
                    return curr;
                }
            }
            curr = i;
            i++;
        }
        return curr;
    }


    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {

            // here we can not do: int mid = left + (right - left) >> 1;
            // other wise, we will hit Time Limit Exceeded
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] > nums[right] ? left : right;
    }
}
