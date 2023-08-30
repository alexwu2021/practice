package com.practice.Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class CapacityToShipPackagesWithinDDaysTest {

    @Test
    public void shipWithinDays() {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        int[] weight;
        int D, actual, expected;

        weight = new int[]{1,2,3,4,5,6,7,8,9,10};
        D = 5;
        expected = 15;
        actual = capacityToShipPackagesWithinDDays.shipWithinDays(weight, D);
        assertEquals(expected, actual);


        weight = new int[]{3,2,2,4,1,4};
        D = 3;
        expected = 6;
        actual = capacityToShipPackagesWithinDDays.shipWithinDays(weight, D);
        assertEquals(expected, actual);


        weight = new int[]{1,2,3,1,1};
        D = 4;
        expected = 3;
        actual = capacityToShipPackagesWithinDDays.shipWithinDays(weight, D);
        assertEquals(expected, actual);
    }
}