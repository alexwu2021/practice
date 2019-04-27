package Easy;

import org.junit.Test;
import sun.security.krb5.internal.tools.Klist;

import static org.junit.Assert.*;

public class KthLargestTest {

    @Test
    public void add() {

        int [] nums = new int []{4, 5, 8, 2};
        int actual, expected, k = 3;
        KthLargest kthLargest = new KthLargest(k, nums);

        actual = kthLargest.add(3);
        expected = 4;
        assert(actual == expected);

        actual = kthLargest.add(5);
        expected = 5;
        assert(actual == expected);

        actual = kthLargest.add(10);
        expected = 5;
        assert(actual == expected);

        actual = kthLargest.add(9);
        expected = 8;
        assert(actual == expected);

        actual = kthLargest.add(4);
        expected = 8;
        assert(actual == expected);
    }
}