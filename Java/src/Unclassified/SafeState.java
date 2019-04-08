package Unclassified;

import java.util.ArrayList;
import java.util.List;

public class SafeState {

    private static final int UNKNOWN = 0;  // unknown.
    private static final int UNSAFE = 1;   // unsafe
    private static final int SAFE   = 2;   // safe

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer>ret = new ArrayList<>();

        // this is tricky: if the first element in graph could be just empty list,
        // so testing if graph[0].length is unncessary and error prone!!
        if(graph == null || graph.length <= 0)
            return ret;

        int N = graph.length;
        int[] states = new int[N];
        for (int i = 0; i < N; ++i) {
            if(dfs(graph, i, states))
                ret.add(i);
        }
        return ret;
    }

    private boolean dfs(int[][] graph, int idx, int[] states) {
        // already visited? OK, everything now is depending on stats[idx]
        // if it is a safe state, then the source is also safe
        if(states[idx] != UNKNOWN)
            return states[idx] == SAFE;

        states[idx] = UNSAFE;
        for(int node: graph[idx]) {
            if(!dfs(graph, node, states))
                return false;
        }
        // no cycle or end of cyle
        states[idx] = SAFE;
        return true;
    }
}
