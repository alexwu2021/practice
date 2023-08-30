package com.practice.amazon;

import java.util.*;

public class FriendCircle {

    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }


    // this is my bad implementation
    // try to coin the data structure on the fly
    int findCircleNum(List<List<Integer>>M) {
        Map<Integer, Set<Integer>> idToSet = new HashMap<>();

        for(int r = 0; r< M.size(); ++r){
            for(int c = 0; c< M.get(0).size(); ++c){
                if(M.get(r).get(c) == 1){
                    if(idToSet.containsKey(r)){
                        idToSet.get(r).add(c);
                    }else{
                        boolean treated = false;
                        for(Integer key : idToSet.keySet()){
                            if(idToSet.get(key).contains(r)){
                                idToSet.get(key).add(c);
                                treated = true;
                                break;
                            }else if(idToSet.get(key).contains(c)){
                                if(idToSet.get(key).contains(r)){
                                    treated = true;
                                    break;
                                }
                            }
                        }

                        if(!treated){
                            Set<Integer> temp = new HashSet<>();
                            temp.add(r);
                            temp.add(c);
                            idToSet.put(r, temp);
                        }
                    }
                }
            }
        }
        return idToSet.size();
    }
}
