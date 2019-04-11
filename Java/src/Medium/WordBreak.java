package Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //    --->
    //    |
    //    |
    //

    /** passed oj
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        Set<String> st = new HashSet<>(wordDict);
        f[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                f[i] =  f[j] && st.contains(s.substring(j, i));
                if (f[i]) break;
            }
        }
        return f[n];
    }
}
