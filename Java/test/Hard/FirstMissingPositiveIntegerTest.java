package Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveIntegerTest {

    @Test
    public void firstMissingPositive() {
        FirstMissingPositiveInteger firstMissingPositiveInteger = new FirstMissingPositiveInteger();
        int [] nums;
        int actual, expected;

        nums = new int[]{1,2,0};
        actual = firstMissingPositiveInteger.firstMissingPositive(nums);
        expected = 3;
        assert (actual == expected);

        nums = new int[]{3, 4, -1, 1};
        actual = firstMissingPositiveInteger.firstMissingPositive(nums);
        expected = 2;
        assert (actual == expected);


        nums = new int[]{7, 8, 9, 11, 12};
        actual = firstMissingPositiveInteger.firstMissingPositive(nums);
        expected = 1;
        assert (actual == expected);


    }
}