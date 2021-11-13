package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class NumberOfDiceRollsWithTargetSum {
    int ans = 0;
    Set<int[]> st = new HashSet<>();
    int MOD = 1000000007;
    public int numRollsToTarget2(int d, int f, int target) {
        for(int i=d; i>=0; --i){
            dfs(i, target, f);
        }

        return ans;
    }

    void dfs(int d, int t, int f){
        if(d <=0 || t <= 0) return;

        int[] key = new int[]{d, t};
        if(st.contains(key)) return;
        st.add(key);

        if(d == 1){
            for(int k =1; k<=f; ++k){
                if(t == k){
                    ans = (ans + 1) % MOD;
                    break;
                }
            }
            return;
        }

        for(int j =1; j<=f; ++j){
            if(j == t){
                ans = (ans + 1) % MOD;
            }else{
                dfs(d-1, t-j, f);
            }
        }
    }


    //int MOD = 1000000000 + 7;
    Map<String, Integer> memo = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d == 0 || target == 0) {
            return 0;
        }
        String str = d + " " + target;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }
        memo.put(str, res);
        return res;
    }
}
