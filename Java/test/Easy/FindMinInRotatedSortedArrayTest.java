package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMinInRotatedSortedArrayTest {

    @Test
    public void findMin() {

        FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
        int actual, expected;
        int [] nums;

//        nums = new int [] {4,5,6,7,0,1,2};
//        actual = findMinInRotatedSortedArray.findMin(nums);
//        expected = 0;
//        assert(actual == expected);


        nums = new int [] {3,4,5,1,2};
        actual = findMinInRotatedSortedArray.findMin(nums);
        expected = 1;
        assert(actual == expected);




    }
}