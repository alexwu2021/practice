package Hard;

import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {

    /** This treeset implementation is based on macrohard's solution
     *  tapping on the property TreeMap can remove arbitrary element in logarithmic time
     *
     *  thoughts: will splay tree work here?
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        TreeSet<Integer> left = getSet(nums);
        TreeSet<Integer> right = getSet(nums);
        for(int i = 0; i < nums.length; ++i) {
            int m;
            if(left.size() <= right.size()) {
                right.add(i);
                m = right.first();
                right.remove(m);
                left.add(m);
            } else {
                left.add(i);
                m = left.last();
                left.remove(m);
                right.add(m);
            }

            if(left.size() + right.size() == k) {
                double med;
                if(left.size() == right.size())
                    med = ((double)nums[left.last()] + nums[right.first()]) / 2;
                else if(left.size() < right.size())
                    med = nums[right.first()];
                else
                    med = nums[left.last()];

                // one at a time set up the ans
                int start = i - k + 1;
                ans[start] = med;
                if(!left.remove(start))
                    right.remove(start);
            }
        }
        return ans;
    }

    private static TreeSet<Integer> getSet(int[] nums) {
        return new TreeSet<>((a, b) -> (nums[a] == nums[b] ? a - b : nums[a] < nums[b] ? -1 : 1));
    }
}
