package Unclassified;

import org.junit.Test;

public class MaxSumSubSequenceTest {

    @Test
    public void findMaxSumSubSequence() {
        int [] nums = new int[] {3, 7, -15, 2, -3, 4, 0, 9};
        MaxSumSubSequence maxSumSubSequence = new MaxSumSubSequence();
        int ret = maxSumSubSequence.findMaxSumSubSequence(nums);
        assert(ret == 13);
    }

    @Test
    public void findMaxSumSubSequence2() {
        int [] nums = new int[] {3, 7, -15, 2, 4, 0, 9};
        MaxSumSubSequence maxSumSubSequence = new MaxSumSubSequence();
        int ret = maxSumSubSequence.findMaxSumSubSequence(nums);
        assert(ret == 15);
    }
}