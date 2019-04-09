package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindAnagramMappingsTest {

    @Test
    public void anagramMappings() {
        FindAnagramMappings findAnagramMappings = new FindAnagramMappings();
        int [] A = new int[]{12,28,46,32,50};
        int [] B = new int[]{50,12,32,46,28};
        int[] res;

//        res = findAnagramMappings.anagramMappings(A, B);
//        assert(res[0] == 1 && res[1] ==4 && res[2] == 3 && res[3] == 2 && res[4] == 0);

        A = new int[]{21,5,74,5,74,21};
        B = new int[]{21,5,74,74,5,21};
        res = findAnagramMappings.anagramMappings(A, B);


        //[5,4,3,4,3,5]
        assert(res[0] == 5 && res[1] ==4 && res[2] == 3 && res[3] == 4 && res[4] == 3 && res[5] == 5);
    }
}