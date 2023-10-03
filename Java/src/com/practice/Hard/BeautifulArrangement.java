package com.practice.Hard;


/**
 *  The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 */
public class BeautifulArrangement {

//    int count = 0;
//
//    public int countArrangement_OJPassed(int N) {
//        if (N == 0) return 0;
//        helper(N, 1, new int[N + 1]);
//        return count;
//    }
//
//    private void helper(int N, int pos, int[] used) {
//        if (pos > N) {
//            count++;
//            return;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
//                used[i] = 1;
//                helper(N, pos + 1, used);
//                used[i] = 0;
//            }
//        }
//    }


    /** best algo I think
     * @param N
     * @return
     */
    public int countArrangement(int N) {
        dfs(N, N, new boolean[N + 1]);
        return count;
    }

    int count = 0;

    void dfs(int N, int k, boolean[] visited) {
        if (k < 2) {
            count++;
            return;
        }
        for (int i = 1; i <= N; ++i) {
            if (visited[i] || k % i != 0 && i % k != 0) {
                continue;
            }
            visited[i] = true;
            dfs(N, k - 1, visited);
            visited[i] = false;
        }
    }

    //from CanDong, not tried on OJ
//    public int countArrangement(int N) {
//        char[] currState = new char[N + 1];
//        Arrays.fill(currState, 'f');  // f means not selected, t means selected
//        return helper(new HashMap<String, Integer>(), currState, 1);
//    }
//
//    int helper(Map<String, Integer> mp, char[] currState, int index) {
//        if(index == currState.length) return 1;
//        String key = String.valueOf(currState);
//        if(mp.containsKey(key)) return mp.get(key);
//        int count = 0;
//        for(int i = 1; i < currState.length; i++) {
//            if(currState[i] == 'f' && (i % index == 0 || index % i == 0)) {
//                currState[i] = 't';
//                count += helper(mp, currState, index + 1);
//                currState[i] = 'f';
//            }
//        }
//        mp.put(key, count);
//        return count;
//    }
}
