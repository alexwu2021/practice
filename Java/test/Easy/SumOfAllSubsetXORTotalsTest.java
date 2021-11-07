package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfAllSubsetXORTotalsTest {

    @Test
    public void subsetXORSum() {
        SumOfAllSubsetXORTotals dol = new SumOfAllSubsetXORTotals();
        int [] nums;
        int actual, expected;

        nums = new int[]{5, 1, 6};
        actual = dol.subsetXORSum(nums);
        expected = 28;
        Assert.assertEquals(actual, expected);
    }
}