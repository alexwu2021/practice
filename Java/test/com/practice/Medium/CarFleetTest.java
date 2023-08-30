package com.practice.Medium;

import Medium.CarFleet;
import org.junit.Test;

public class CarFleetTest {

    @Test
    public void carFleet() {
        int target = 12;
        int[]position = new int[]{10,8,0,5,3};
        int[]speed = new int []{2,4,1,1,3};
        try {
            CarFleet carFleet = new CarFleet();
            int ret = carFleet.carFleet(target, position, speed);
            assert (ret == 3);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}