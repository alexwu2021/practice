package Medium;

import java.util.*;

/**
 *
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1 :
 *
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 * or an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible
 * rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 */
public class MinHeightTree {


    /**
     * completely borrowed from dietpepsi, no changes ever made but only some notes added
     *
     * similar to the BFS topological sort. Remove the leaves, update the degrees of
     * inner vertexes. Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left. What's left is our answer!
     *
     * The time complexity and space complexity are both O(n).
     * @param n, the total number of nodes, [0, 1, ..., n-1] are the node labels
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return Collections.singletonList(0);

        // each node --> each Set of edges going out from it
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // prepare the starting leads, which each has an out degree of 1
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);


        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            // do this till a layer is completely processed.
            for (int i : leaves) {

                // this is the amazing part!!
                int j = adj.get(i).iterator().next();

                adj.get(j).remove(i); //remove the forthcomign footprint

                // prepare for future relay
                if (adj.get(j).size() == 1)
                    newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;

    }

    /**
     *  from self_learner, a good reference
     * @param n
     * @param edges
     * @return
     */
    public  List<Integer> findMinHeightTrees2(int n, int[][] edges){
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;
        if (n == 1) {
            res.add(0);
            return res;
        }

        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] indegree = new int[n];
        int cnt = n;
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indegree[i] = graph[i].size();
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }
        while (cnt > 2) {
            int size = leaves.size();
            cnt -= size;
            for (int i = 0; i < size; i++) {
                int v = leaves.poll();
                for (int w : graph[v]) {
                    indegree[w]--;
                    if (indegree[w] == 1) {
                        leaves.add(w);
                    }
                }
            }
        }
        res.addAll(leaves);
        return res;
    }

}
