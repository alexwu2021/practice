package com.practice.Easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TwoListsTest {

    @Test
    public void findNodesWithZeroAndOneParents() {
        TwoLists twoLists = new TwoLists();
        List<int[]> src;

        src = new ArrayList<>();
        List<Integer>[] actual, expected;

        src.clear();
        src.add(new int[]{1, 3}); //parent child pair
        src.add(new int[]{2, 3});
        src.add(new int[]{3, 6});
        src.add(new int[]{5, 6});
        src.add(new int[]{5, 7});
        src.add(new int[]{4, 5});
        src.add(new int[]{4, 8});
        src.add(new int[]{8, 10});
        expected = new List[2];

        int i = 0;
        expected[i] = Arrays.asList(1, 2, 4);
        i++;
        expected[i] = Arrays.asList(5, 7, 8, 10);

        actual = twoLists.findNodesWithZeroAndOneParents(src);
        assert(actual != null && actual.length == 2);

        for(int j = 0; j <= 1; ++j){
            assert(actual[j].containsAll(expected[j]) && expected[j].containsAll(actual[j]));
        }

    }
}