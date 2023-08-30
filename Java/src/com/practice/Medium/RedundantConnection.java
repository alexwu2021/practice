package com.practice.Medium;

public class RedundantConnection {

    /**
     *  Borrowed from Grace Meng
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            // to avoid index out boundary, we started with this fashion, but not really understand it
            if (!disjointSet.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        throw new IllegalArgumentException();
    }

    static class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            if (n < 0) throw new IllegalArgumentException();
            parent = new int[n];
            rank = new int[n];
        }

        public int find(int x) {
            if (parent[x] == 0)
                return x;
            parent[x] = find(parent[x]); // Path compression by halving.
            return parent[x];
        }

        // Return false if x, y are connected.
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;

            // Make root of smaller rank point to root of larger rank.
            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }

//    def findRedundantConnection(self, edges):
//    parent = [0] * len(edges)
//
//    def find(x):
//            if parent[x] == 0:
//            return x
//    parent[x] = find(parent[x])
//      return parent[x]
//
//    def union(x, y):
//    rootX = find(x)
//    rootY = find(y)
//      if rootX == rootY:
//            return False
//    parent[rootX] = rootY
//      return True
//
//    for x, y in edges:
//            if not union(x - 1, y - 1):
//            return [x, y]
//
//    raise ValueError("Illegal input.")


    //from stefan pochmann
    //    def findRedundantConnection(self, edges):
    //    tree = ''.join(mp(chr, range(1001)))
    //            for u, v in edges:
    //            if tree[u] == tree[v]:
    //            return [u, v]
    //    tree = tree.replace(tree[u], tree[v])
}
