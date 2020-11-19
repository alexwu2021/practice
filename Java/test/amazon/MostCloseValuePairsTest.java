package amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MostCloseValuePairsTest {

    @Test
    public void getPairs() {
        MostCloseValuePairs mostCloseValuePairs = new MostCloseValuePairs();
        List<int[]> a, b, ret, expected;
        int target;

        a = new ArrayList<int[]>();
        b = new ArrayList<int[]>();
        expected = new ArrayList<int[]>();

        a.add(new int[]{1, 2});
        a.add(new int[]{2, 4});
        a.add(new int[]{3, 6});

        b.add(new int[]{1, 2});
        target = 7;
        expected.clear();
        expected.add(new int[]{2, 1});
        ret = mostCloseValuePairs.getPairs(a, b, target);
        //interestingly, we can not use assertEqual to resolve it, because each element in the two lists is an array
        //not an integer
        //Assert.assertEquals(ret, expected);
        Assert.assertArrayEquals(ret.toArray(), expected.toArray());


        a.clear();
        a.add(new int[]{1, 3});
        a.add(new int[]{2, 5});
        a.add(new int[]{3, 7});
        a.add(new int[]{4, 10});

        b.clear();
        b.add(new int[]{1, 2});
        b.add(new int[]{2, 3});
        b.add(new int[]{3, 4});
        b.add(new int[]{4, 5});

        target = 10;

        expected.clear();
        expected.add(new int[]{2, 4});
        expected.add(new int[]{3, 2});

        ret = mostCloseValuePairs.getPairs(a, b, target);
        Assert.assertArrayEquals(ret.toArray(), expected.toArray());



        //example 4
//        a = [[1, 8], [2, 15], [3, 9]]
//        b = [[1, 8], [2, 11], [3, 12]]
//        target = 20
//
//        Output: [[1, 3], [3, 2]]

        a.clear();
        a.add(new int[]{1, 8});
        a.add(new int[]{2, 15});
        a.add(new int[]{3, 9});

        b.clear();
        b.add(new int[]{1, 8});
        b.add(new int[]{2, 11});
        b.add(new int[]{3, 12});

        target = 20;

        expected.clear();
        expected.add(new int[]{1, 3});
        expected.add(new int[]{3, 2});

        ret = mostCloseValuePairs.getPairs(a, b, target);
        Assert.assertArrayEquals(ret.toArray(), expected.toArray());

    }
}