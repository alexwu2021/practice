package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumUnitsOnATruckTest {

    @Test
    public void maximumUnits() {
        MaximumUnitsOnATruck sol = new MaximumUnitsOnATruck();

        int[][] quantUnitPairs;
        int truckSize, actual, expected;

        quantUnitPairs = new int[][]{new int[]{1,3},new int[]{2,2},new int[]{3,1}};
        truckSize = 4;
        expected = 8;
        actual = sol.maximumUnits(quantUnitPairs, truckSize);
        Assert.assertEquals(expected, actual);


        quantUnitPairs = new int[][]{new int[]{5,10},new int[]{2,5},new int[]{4,7}, new int[]{3,9}};
        truckSize = 10;
        expected = 91;
        actual = sol.maximumUnits(quantUnitPairs, truckSize);
        Assert.assertEquals(expected, actual);

        quantUnitPairs = new int[][]{
                new int[]{2,1},
                new int[]{4,4},
                new int[]{3,1},
                new int[]{4,1},
                new int[]{2,4},
                new int[]{3,4},
                new int[]{1,3},
                new int[]{4,3},
                new int[]{5,3},
                new int[]{5,3}
        };
        truckSize = 13;
        expected = 48;

        actual = sol.maximumUnits(quantUnitPairs, truckSize);
        Assert.assertEquals(expected, actual);

    }
}