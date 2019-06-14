package Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LabelPartitionTest {

    @Test
    public void partitionLabels() {

        LabelPartition labelPartition = new LabelPartition();
        String S = "ababcbacadefegdehijhklij";
        List<Integer> actual, expected;
        expected = new ArrayList<>();
        actual = labelPartition.partitionLabels(S);
        assertNotNull(actual);
        assertArrayEquals(actual.toArray(), expected.toArray());



        //TODO: FIX THIS CASE
        //113 / 116 test cases passed.
        //failed on this one, with output as [11,1,1,1,1]

        S = "qiejxqfnqceocmy";
        expected = Arrays.asList(13, 1, 1);
        actual = labelPartition.partitionLabels(S);
        assertNotNull(actual);
        assertArrayEquals(actual.toArray(), expected.toArray());

    }
}