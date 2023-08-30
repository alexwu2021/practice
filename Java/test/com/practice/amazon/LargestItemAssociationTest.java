package com.practice.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestItemAssociationTest {

    @Test
    public void largestItemAssociation() {
        LargestItemAssociation largestKAssociation = new LargestItemAssociation();

        List<PairString> src = new ArrayList<>();
        src.clear();
        src.add(new PairString("a1", "a2"));
        src.add(new PairString("a3", "a4"));
        src.add(new PairString("a4", "a5"));
        List<String> expected = new ArrayList<>();
        expected.clear();
        expected.addAll(Arrays.asList(new String[]{"a3", "a4", "a5"}));

        List<String> actual = largestKAssociation.largestItemAssociation(src);
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));
    }


    @Test
    public void largestItemAssociation2() {
        LargestItemAssociation s = new LargestItemAssociation();
        List<PairString> input = Arrays.asList(
                new PairString[]{
                        new PairString("item1", "item2"),
                        new PairString("item3", "item4"),
                        new PairString("item4", "item5")
                }
        );

        List<String> actual = s.largestItemAssociation_someones(input);
        List<String> expected = new ArrayList<>();

        expected.add("item3");
        expected.add("item4");
        expected.add("item5");
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));

        List<PairString> input2 =  Arrays.asList(
                new PairString[] {
                        new PairString("item1","item2"),
                        new PairString("item2","item3"),
                        new PairString("item4","item5"),
                        new PairString("item6","item7"),
                        new PairString("item5","item6"),
                        new PairString("item3","item7")
                }
        );
        actual = s.largestItemAssociation_someones(input2);
        expected = new ArrayList<>();
        expected.add("item1");
        expected.add("item2");
        expected.add("item3");
//        expected.add("item4");
//        expected.add("item5");
//        expected.add("item6");
        expected.add("item7");
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));

        List<PairString> input3 =  Arrays.asList(
                new PairString[] {
                        new PairString("item1","item2"),
                        new PairString("item1","item3"),
                        new PairString("item2","item7"),
                        new PairString("item3","item7"),
                        new PairString("item5","item6"),
                        new PairString("item3","item7")
                }
        );

        actual = s.largestItemAssociation_someones(input3);
        expected = new ArrayList<>();

        expected.add("item1");
        expected.add("item2");
        expected.add("item3");
        expected.add("item7");
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));


    }
}