package Hard;

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

    public int findIntegers(int num) {
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
}
