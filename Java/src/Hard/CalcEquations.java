package Hard;

import java.util.HashMap;
import java.util.Map;

public class CalcEquations {

    private Map<String, String> parents = new HashMap<>();  //<node, parents of the node>
    private Map<String, Double> ratios = new HashMap<>();   //<node, node / parents>

    /** passed oj
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; i++) union(equations[i][0], equations[i][1], values[i]);

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String s1 = queries[i][0], s2 = queries[i][1];
            if (!parents.containsKey(s1) || !parents.containsKey(s2) || !find(s1).equals(find(s2))) { //pay attention to this
                res[i] = -1.0;
            } else {
                res[i] = ratios.get(s1) / ratios.get(s2);
            }
        }
        return res;
    }

    private void union(String s1, String s2, double val) {
        if (!parents.containsKey(s1)) {
            parents.put(s1, s1);
            ratios.put(s1, 1.0);
        }
        if (!parents.containsKey(s2)) {
            parents.put(s2, s2);
            ratios.put(s2, 1.0);
        }
        String p1 = find(s1);
        String p2 = find(s2);
        parents.put(p1, p2);
        ratios.put(p1, val * ratios.get(s2) / ratios.get(s1));
    }

    private String find(String s) {
        if (s.equals(parents.get(s))) return s;
        String father = parents.get(s);
        String grandpa = find(father);
        parents.put(s, grandpa);
        ratios.put(s, ratios.get(s) * ratios.get(father));
        return grandpa;
    }

}
