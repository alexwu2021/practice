package Medium;

import java.util.Arrays;

/**
 * There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.
 *
 * Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,
 *
 * The cost is the sum of the connections' costs used.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 *
 *
 * Input: n = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation: There is no way to connect all cities
 */
public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] conns) {
        int[] roots = new int[N+1];
        for(int i=0; i <= N; ++i) roots[i] = i;
        Arrays.sort(conns);
        int ans = 0;
        for(int[] c : conns){
            int r1 = find(roots, c[0]);
            int r2 = find(roots, c[1]);
            if(r1 != r2) {
                ans += c[2];
                roots[r1] = r2;
                N--;
            }
        }
        return N ==1 ? ans : -1;
    }
    int find(int[] root, int id) {
        while(root[id] != id) {
            root[id] = root[root[id]];
            id = root[id];
        }
        return id;
    }
}
