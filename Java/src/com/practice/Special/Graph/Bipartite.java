package com.practice.Special.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    /** passed oj
     * @param g
     * @return
     */
    public boolean isBipartite(int[][] g) {
        // each element of colors may take -1, 1, 0
        // with 0 indicating unvisited
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; ++i){
            if (colors[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int k = q.poll();
                for (int adj : g[k]){
                    if (colors[adj] == colors[k]) return false;
                    if (colors[adj] == 0) { // pay attention to this
                        q.add(adj);
                        colors[adj] = -1 * colors[k];
                    }
                }
            }
        }
        return true;
    }

    /** also passed oj
     * @param graph
     * @return
     */
    public boolean isBipartite_dfs(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 0 && !validColor(graph, colors, i, 1))
                return false;
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int node, int colorToSet) {
        if (colors[node] != 0) return colors[node] == colorToSet;
        colors[node] = colorToSet;
        for (int adj : graph[node]) {
            // pay attention to the following: we can not do
            // if (colors[adj] == 0 && !validColor(graph, colors, adj, -colorToSet)) return false;
            if (!validColor(graph, colors, adj, -colorToSet)) return false;
        }
        return true;
    }
}
