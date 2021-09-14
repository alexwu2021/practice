package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * * Example 1:
 *  *
 *  * Input: code = [5,7,1,4], k = 3
 *  * Output: [12,10,16,13]
 *  * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 *
 *  * Example 2:
 *  * Input: code = [1,2,3,4], k = 0
 *  * Output: [0,0,0,0]
 *  * Explanation: When k is zero, the numbers are replaced by 0.
 *  * Example 3:
 *  *
 *  * Input: code = [2,4,9,3], k = -2
 *  * Output: [12,5,6,13]
 *  * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 */
public class DiffuseTheBombTest {

    @Test
    public void decrypt() {
        DiffuseTheBomb sol = new DiffuseTheBomb();
        int[] code;
        int k;
        int[] actual;
        int[] expected;

//        code = new int[]{5,7,1,4};
//        k = 3;
//        expected = new int[] {12,10,16,13};
//        actual = sol.decrypt(code, k);
//        Assert.assertArrayEquals(expected, actual);
//
//
//        code = new int[]{1,2,3,4};
//        k = 0;
//        expected = new int []{0,0,0,0};
//        actual = sol.decrypt(code, k);
//        Assert.assertArrayEquals(expected, actual);

        code = new int[]{2,4,9,3};
        k = -2;
        expected = new int []{12,5,6,13};
        actual = sol.decrypt(code, k);
        Assert.assertArrayEquals(expected, actual);

    }

}