package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * for a given n, return 1, 11, 12, ..., 2, 20, 21, 22, ...
 */
public class LexicographicalNumbers {

    /** Runtime: 2 ms, faster than 95.41% of Java online submissions for Lexicographical Numbers.
     * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Lexicographical Numbers.
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer>res = new ArrayList<>();
        for(int i = 1; i< 10; ++i){
            dfs(i, n, res);
        }
        return res;
    }

    void dfs(int curr, int n, List<Integer> res){
        if(curr > n) return;
        res.add(curr);

        for(int i = 0; i< 10; ++i){
            int temp = curr * 10 + i;
            if(temp > n) return;
            dfs(temp, n, res);
        }
    }
}
