package Hard;

import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {

    /** passed oj, inspired by liqingfd
     * @param n
     * @param k
     * @return
     */
    public String crackSafe(int n, int k) {
        int totalLength = (int) Math.pow(k, n) + n - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append("0");
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        if(dfs(visited, totalLength, sb, n, k)) return sb.toString();
        return "";
    }

    public boolean dfs(Set<String> visited, int totalLength, StringBuilder sb, int n, int k) {
        if (sb.length() == totalLength) return true;
        String prev = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; ++i) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(visited, totalLength, sb, n, k))
                    return true;
                sb.setLength(sb.length()-1);
                visited.remove(next);
            }
        }
        return false;
    }
}
