package Medium;

import java.util.*;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the
 * sequence of gray code. A gray code sequence must begin with 0.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 *
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode {


    /** borrowed from yuyibestman
     *
     *  00,01,11,10 -> (000,001,011,010 ) (110,111,101,100).
     *
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        for (int i = 0; i < n; ++i) {
            int size = ans.size();
            for (int k = size - 1; k >= 0; k--){
                ans.add(ans.get(k) | 1 << i);
            }
        }
        return ans;
    }



    // Note: use random as driver is an impasse
    /*

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
         ans.add(0);
        if(n == 0) return ans;


        List<Integer> last = new ArrayList<>();
        Set<String>done = new HashSet<>();
        for(int i = 0; i < n; ++i) last.add(0);

        done.add(convert2String(last));

        int expectedRounds = (int)Math.pow(2, n) ;
        int index = 0;
        do{
            List<Integer>clone = new ArrayList<>(last);
            index = ++index % n;
            clone.set(index, clone.get(index) == 0 ? 1 : 0);
            String testValue = convert2String(clone);
            if(done.contains(testValue)) continue;
            done.add(testValue);
            last = new ArrayList<>(clone);

            int temp = 0;
            int k = n - 1, r = 0;
            while(k >= 0){
                temp +=  clone.get(k--) * Math.pow(2, r++);
            }
            ans.add(temp);

        }while(ans.size() < expectedRounds);
        return ans;
    }

    String convert2String(List<Integer>list){
        StringBuilder strbul  = new StringBuilder();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext())
        {
            strbul.append(iter.next());
            if(iter.hasNext()){
                strbul.append(",");
            }
        }
        return strbul.toString();
    }
     */

}
