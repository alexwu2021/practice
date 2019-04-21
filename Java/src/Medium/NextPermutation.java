package Medium;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 0) return;
        int len = nums.length;

        // locate i, i is the index of the first element that breaks the descending order
        int i = len - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;

        // locate j, j points the elemnt that is good for swap
        if(i >= 0){
            int j = len -1;
            while(nums[j] <= nums[i]){
                j--;
            }
            // till nums[j] > nums[i]

            swap(nums, i, j);
            // after swapping, we have these properties;
            // 1) nums[i] > nums[j]
            // 2) in the section from i + 1 to len -1, there exists a smaller element pointed by j
        }

        // from i+1 to len -1, after reverse,
        reverse(nums, i+1, len-1);
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
