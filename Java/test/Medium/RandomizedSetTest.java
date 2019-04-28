package Medium;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class RandomizedSetTest {

    @Test
    public void getRandom() {
        RandomizedSet obj = new RandomizedSet();
        int val;
        boolean bActual, bExpected;
        int iActual;
        Set<Integer> iExpected = new HashSet<Integer>();;

        bExpected = true;
        val = 1;
        bActual = obj.insert(val);
        assert (bActual == bExpected);


        bExpected = false;
        val = 2;
        bActual = obj.remove(val);
        assert (bActual == bExpected);

        bExpected = true;
        val = 2;
        bActual = obj.insert(val);
        assert (bActual == bExpected);


        iExpected.clear();
        iExpected.add(1);
        iExpected.add(2);
        iActual = obj.getRandom();
        assert (iExpected.contains(iActual));


        bExpected = true;
        val = 1;
        bActual = obj.remove(val);
        assert (bActual == bExpected);


        // 2 was already in the set, so return false.
        bExpected = false;
        val = 2;
        bActual = obj.insert(val);
        assert (bActual == bExpected);


        // Since 2 is the only number in the set, getRandom always return 2.
        iExpected.clear();
        iExpected.add(2);
        iActual = obj.getRandom();
        assert (iExpected.contains(iActual));


    }
}