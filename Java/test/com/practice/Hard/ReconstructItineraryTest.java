package com.practice.Hard;

import com.practice.Easy.Hard.ReconstructItinerary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructItineraryTest {

    @Test
    public void findItinerary() {
        List<List<String>>tickets = new ArrayList<>();
        tickets.add(Arrays.asList(new String[]{"MUC","LHR"}));
        tickets.add(Arrays.asList(new String[]{"SFO","SJC"}));
        tickets.add(Arrays.asList(new String[]{"LHR","SFO"}));
        List<String>actual, expected;

        ReconstructItinerary sol = new ReconstructItinerary();
        actual = sol.findItinerary(tickets);

    }
}