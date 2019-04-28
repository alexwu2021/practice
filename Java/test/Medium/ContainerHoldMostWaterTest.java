package Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerHoldMostWaterTest {

    @Test
    public void maxArea() {

        ContainerHoldMostWater containerHoldMostWater = new ContainerHoldMostWater();
        int [] height;
        int actual, expected;
        height = new int [] {1, 3, 2, 5, 25, 24, 5};
        expected = 24;

        actual = containerHoldMostWater.maxArea(height);
        assert(expected == actual);
    }
}