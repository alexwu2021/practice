package Special;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ProteinSynthesisTest {

    @Test
    public void getMutated() {
        ProteinSynthesis sol = new ProteinSynthesis();
        int n, k;
        String proteins, actual, expected;
        Map<String, Character> mp = new HashMap<>();


//            A   B   C   D
//        _   _   _   _
//        A|  A   B   C   D
//        B|  B   A   D   C
//        C|  C   D   A   B
//        D|  D   C   B   A
//
//        ROW 1
        mp.put("AA", 'A');
        mp.put("AB", 'B');
        mp.put("AC", 'C');
        mp.put("AD", 'D');

//        ROW 2
        mp.put("BA", 'B');
        mp.put("BB", 'A');
        mp.put("BC", 'D');
        mp.put("BD", 'C');

//        ROW 3
        mp.put("CA", 'C');
        mp.put("CB", 'D');
        mp.put("CC", 'A');
        mp.put("CD", 'B');

//        ROW 4
        mp.put("DA", 'D');
        mp.put("DB", 'C');
        mp.put("DC", 'B');
        mp.put("DD", 'A');


        n = 5;
        k = 15;
        proteins = "AAAAD";
        expected = "DDDDA";
        actual = sol.GetMutated(n, k, proteins, mp);
        Assert.assertEquals(expected, actual);
    }
}