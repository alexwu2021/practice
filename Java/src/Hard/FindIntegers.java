package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary
 * representations do NOT contain consecutive ones.
 *
 * Example 1:
 * Input: 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 * Note: 1 <= n <= 109
 */
public class FindIntegers {

    public int findIntegers_plain(int num) {
        int count = 0;
        while(num >= 0){
            char[] baNum = Integer.toBinaryString(num).toCharArray();
            boolean isValid = true;
            for(int i = 1; i < baNum.length; ++i){
                if(baNum[i] == '1' && baNum[i -1] == '1'){
                    isValid = false;
                    break;
                }
            }
            if(isValid) count++;
            num--;
        }
        return count;
    }

    public int findIntegers(int num) {
     return findIntegers(num, new HashMap<>());
    }

    private int findIntegers(int num, Map<Integer, Integer> mp) {
        if(num <= 2)
            return num + 1;

        if(mp.containsKey(num))
            return mp.get(num);

        int msb = 31 - Integer.numberOfLeadingZeros(num); // retrieve index of most significant bit
        int stem = 1 << msb;
        int subNum = stem - 1;

        int subNum2 = ~(stem) & num;

        // If there is consecutive one after the most significant bit, set subNum2 as subNum >> 1
        // to consider the next bit as 0
        if (subNum2 >= (stem - 1) ) {
            subNum2 = subNum >> 1;
        }

        // there is no guarantee that subNum + subNum2 == num

        int count = findIntegers(subNum, mp) + findIntegers(subNum2, mp);
        mp.put(num, count);
        return count;
    }
}
