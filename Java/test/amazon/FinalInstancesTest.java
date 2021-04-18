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

        initial = 5;
        utilization = new int[] {5
                ,6
                ,30
                ,5
                ,4
                ,8
                ,19
                ,89};
        expected = 3;
        actual = finalInstances.getFinalNumberOfInstances(initial, utilization);
        Assert.assertEquals(expected, actual);

        initial =  2;
        utilization = new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
        actual = finalInstances.getFinalNumberOfInstances(initial, utilization);
        Assert.assertEquals(expected, actual);

    }
}