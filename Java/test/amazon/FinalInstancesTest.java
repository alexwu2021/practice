package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalInstancesTest {

    @Test
    public void getFinalNumberOfInstances() {
        FinalInstances finalInstances = new FinalInstances();
        int initial, actual, expected;
        int[] utilization;

        initial = 1;
        utilization = new int[] {1, 3, 5, 10, 80};
        expected = 2;
        actual = finalInstances.getFinalNumberOfInstances(initial, utilization);
        Assert.assertEquals(expected, actual);

        initial =  2;
        utilization = new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
        actual = finalInstances.getFinalNumberOfInstances(initial, utilization);
        Assert.assertEquals(expected, actual);

    }
}