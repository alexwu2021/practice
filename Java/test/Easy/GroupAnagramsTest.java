package Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    @Test
    public void groupAnagrams() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] src = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> actual = groupAnagrams.groupAnagrams(src);

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"ate", "eat", "tea"}));
        expected.add(Arrays.asList(new String[]{"nat", "tan"}));
        expected.add(Arrays.asList(new String[]{"bat"}));

        // how to do this nicely?
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}