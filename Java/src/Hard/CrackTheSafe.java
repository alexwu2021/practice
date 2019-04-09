package Hard;

import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {

    /** passed oj, inspired by liqingfd
     *  in fact, find a Hamiltonian path of n node of k edges or De Bruijin sequence
     *
     *  complexity: O(k^n)
     *
     * @param n
     * @param k
     * @return
     */

    public String crackSafe(int n, int k) {
        final int TOTAL_LENGTH = (int) Math.pow(k, n) + n - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append("0");
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        if(dfs(visited, TOTAL_LENGTH, sb, n, k)) return sb.toString();
        return "";
    }

    public boolean dfs(Set<String> visited, final int TOTAL_LENGTH, StringBuilder sb, int n, int k) {
        if (sb.length() == TOTAL_LENGTH) return true;


        // here for a given string sb.toString(), we need to find out the prefix
        // which is sb.substring(sb.length() - n + 1)
        // and in this allowed space of leangth n - 1, we try all the k way extending

        // that is, for a given string sb.toString() like s...l[ a string of n -1]
        // we will reuse its prefix from start to left

        // and we will continue to do so such that we either reach the full length or exhaust the exploration
        // without any findings.

        String prev = sb.substring(sb.length() - n + 1);

        for (int i = 0; i < k; ++i) {
            String next = prev + i;
            if (visited.contains(next)) continue;
            visited.add(next);
            sb.append(i);
            if (dfs(visited, TOTAL_LENGTH, sb, n, k)) return true;
            sb.setLength(sb.length() - 1); // equivalent to sb.delete(sb.length() - 1, sb.length());
            visited.remove(next);
        }
        return false;
    }
}



//// Author: Huahua
//// Running time: 13 ms
//class Solution {
//    public:
//    string crackSafe(int n, int k) {
//        const int total_len = pow(k, n) + n - 1;
//        string node(n - 1, '0');
//        string ans;
//        unordered_set<string> visited;
//        dfs(node, k, visited, ans);
//        return ans + node;
//    }
//    private:
//    void dfs(const string& node, const int k, unordered_set<string>& visited, string& ans) {
//        for (char c = '0'; c < '0' + k; ++c) {
//            string next = node + c;
//            if (visited.count(next)) continue;
//            visited.insert(next);
//            dfs(next.substr(1), k, visited, ans);
//            ans.push_back(c);
//        }

//    }
//};

/* from Self_Learner
class Solution {
    public String crackSafe(int n, int k) {
        if (n == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(i);
            }
            return sb.toString();
        }
        List<String> passwords = new ArrayList<>();
        createPass(n - 1, k, new StringBuilder(), passwords);
        //create all the passwords contains n - 1 characters..

        //create the digraph...
        Map<String, List<String>> graph = new HashMap<>();
        for (String s : passwords) {
            graph.put(s, new LinkedList<>());
            String pre = s.substring(1);
            for (int i = 0; i < k; i++) {
                graph.get(s).add(pre + i);
            }
        }

        //find the Eulerian path...
        List<String> EulerPath = new LinkedList<>();
        String start = passwords.get(0);
        findEulerPath(start, EulerPath, graph);

        //take the first string... and take the last character of all remaining strings...
        StringBuilder sb = new StringBuilder();
        sb.append(EulerPath.get(0));
        for (int i = 1; i < EulerPath.size(); i++) {
            sb.append(EulerPath.get(i).charAt(n - 2));
            //n - 2... not n - 1...
        }
        return sb.toString();
    }

    private void findEulerPath(String v, List<String> list, Map<String, List<String>> graph) {

        while (graph.get(v).size() > 0) {
            String w = graph.get(v).remove(0);
            findEulerPath(w, list, graph);
        }
        list.add(0, v);
    }

    private void createPass(int n, int k, StringBuilder sb, List<String> list) {
        if (n == 0) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < k; i++) {
            sb.append(i);
            createPass(n - 1, k, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
*/