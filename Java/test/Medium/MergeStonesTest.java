package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeStonesTest {

    @Test
    public void mergeStones() {
        MergeStones sol = new MergeStones();
        int[] stones;
        int k;
        int actual, expected;

//        stones = new int[]{3,2,4,1};
//        k = 2;
//        expected = 20;
//        actual = sol.mergeStones(stones, k);
//        Assert.assertEquals(expected, actual);
//
//        stones = new int[]{3,2,4,1};
//        k = 3;
//        expected = -1;
//        actual = sol.mergeStones(stones, k);
//        Assert.assertEquals(expected, actual);

        stones = new int[]{3,5,1,2,6};
        k = 3;
        expected = 25;
        actual = sol.mergeStones(stones, k);
        Assert.assertEquals(expected, actual);

        stones = new int[]{6, 4,4, 6};
        k = 2;
        expected = 40;
        actual = sol.mergeStones(stones, k);
        Assert.assertEquals(expected, actual);


    }
}