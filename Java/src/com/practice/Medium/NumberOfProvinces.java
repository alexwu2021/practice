package com.practice.Medium;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 */
public class NumberOfProvinces {

    /**
     * @param A : the adjacency list where A[i][j] means i and j are connected
     *
     * beat 83% in speed
     * @return
     */
    public int findCircleNum(int[][] A) {
        int n  = A[0].length;
        int[]v = new int[n];
        int count = 0;
        for(int i = 0; i<n; ++i){
            if(v[i] == 0){ // only if not visited
                dfs(A, v, i);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][]A, int[]v, int c){
        if(c >= A[0].length) return;
        for(int r = 0; r<A.length; ++r){
            if(A[r][c] == 1 && v[r] == 0){
                v[c] = 1;
                dfs(A, v, r); //shift towards the other direction
            }
        }
    }
}
