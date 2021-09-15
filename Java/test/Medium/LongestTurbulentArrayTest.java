package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestTurbulentArrayTest {

    @Test
    public void maxTurbulenceSize() {
        LongestTurbulentArray sol = new LongestTurbulentArray();
        int[] arr;
        int actual, expected;

        arr = new int[]{};
        expected = 0;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);

        arr = new int[]{100};
        expected =  1;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);


        arr = new int[]{9,4,2,10,7,8,8,1,9};
        expected =  5;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);


        arr = new int[]{4,8,12,16};
        expected =  2;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);


        arr = new int[]{2,0,2,4,2,5,0,1,2,3};
        expected =  6;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);

        arr = new int[]{2,2};
        expected =  1;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);

        arr = new int[]{2,2, 2};
        expected =  1;
        actual = sol.maxTurbulenceSize(arr);
        Assert.assertEquals(expected, actual);

    }
}