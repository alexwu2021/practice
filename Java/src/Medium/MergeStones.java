package Medium;

public class MergeStones {

    private int K;
    private int[] preSum; // preSum[i] is sum of stones[0] to stones[i].
    private int[][][] memo;

    public int mergeStones(int[] stones, int K) {
        if (stones.length == 1) return 0;
        this.K = K;
        memo = new int[stones.length + 1][stones.length + 1][K + 1];
        buildPreSum(stones, K);
        int result = dfs(1, stones.length, 1, stones);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void buildPreSum(int[] stones, int K) {
        preSum = new int[stones.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; ++i)
            preSum[i] = preSum[i - 1] + stones[i - 1];
    }

    // Minimum cost merging piles from i to j into target number of piles.
    public int dfs(int i, int j, int tgt, int[] stones) {
        // caching
        if (memo[i][j][tgt] > 0) return memo[i][j][tgt];

        // base cases
        if (j - i + 1 < tgt) return Integer.MAX_VALUE;
        if (i == j) return (tgt == 1) ? 0 : Integer.MAX_VALUE;
        if (tgt == 1) {
            int subMinCost = dfs(i, j, K, stones);
            if (subMinCost != Integer.MAX_VALUE) {
                memo[i][j][tgt] = preSum[j] - preSum[i - 1] + subMinCost;
            }
            else{
                memo[i][j][tgt] = subMinCost;
            }
            return memo[i][j][tgt];
        }

        // recursive part
        int mn = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; ++k) {
            int left = dfs(i, k, tgt - 1, stones);
            if (left == Integer.MAX_VALUE) continue;

            int right = dfs(k + 1, j, 1, stones);
            if (right == Integer.MAX_VALUE) continue;

            mn = Math.min(mn, left + right);
        }
        memo[i][j][tgt] = mn;
        return mn;
    }

    //greedy approach, failed

//    public int mergeStones(int[] stones, int k) {
//        List<Integer> lst = new ArrayList<>(), newList = new ArrayList<>();
//        int totalCost = 0;
//        for(int stone: stones) lst.add(stone);
//        do{
//            int start = -1, mx = Integer.MAX_VALUE;
//            for(int i=0; i<=lst.size() -k; ++i){
//                int temp = 0;
//                for(int j= i; j <i+ k; ++j){
//                    temp += lst.get(j);
//                }
//                if(temp < mx){
//                    mx = temp;
//                    start = i;
//                }
//            }
//            int r;
//            for(r = 0; r<start; ++r)
//                newList.add(lst.get(r));
//            int tempSum = 0;
//            for(r = start; r<start+k; ++r)
//                tempSum += lst.get(r);
//            System.out.print("merged with cost of " + tempSum);
//            newList.add(tempSum);
//            totalCost += tempSum;
//            for(r = start+k; r<lst.size(); ++r)
//                newList.add(lst.get(r));
//            lst.clear();
//            lst.addAll(newList);
//            newList.clear();
//        }while(lst.size() >= k );
//
//        if(lst.size() >1) return -1;
//        return totalCost;
//    }
}
