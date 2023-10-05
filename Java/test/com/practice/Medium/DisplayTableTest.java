package com.practice.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTableTest {

    DisplayTable sol = new DisplayTable();
    @Test
    void displayTable() {
        List<List<String>>expected, actual, orders = new ArrayList<>();
        orders.add(Arrays.asList("David","3","Ceviche"));
        orders.add(Arrays.asList("Corina","10","Beef Burrito"));
        orders.add(Arrays.asList("David","3","Fried Chicken"));
        orders.add(Arrays.asList("Carla","5","Water"));
        orders.add(Arrays.asList("Carla","5","Ceviche"));
        orders.add(Arrays.asList("Rous","3","Ceviche"));

        actual = sol.displayTable(orders);
        expected = new ArrayList<>();
        expected.add(Arrays.asList("Table","Beef Burrito","Ceviche","Fried Chicken","Water"));
        expected.add(Arrays.asList("3","0","2","1","0"));
        expected.add(Arrays.asList("5","0","1","0","1"));
        expected.add(Arrays.asList("10","1","0","0","0"));

        assertArrayEquals(expected.stream().toArray(), actual.stream().toArray());
    }
}