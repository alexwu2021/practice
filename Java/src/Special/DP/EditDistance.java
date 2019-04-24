package Special.DP;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class EditDistance {

    /**
     * f(i, j) := minimum cost of converting source [0, i] to target [0, j]
     *
     * Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
     *
     * f(i, j) = f(i - 1, j - 1)
     *
     * Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
     *
     * f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
     *
     * f(i, j - 1) represents insert operation
     * f(i - 1, j) represents delete operation
     * f(i - 1, j - 1) represents replace operation
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int [][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; ++i)cost[i][0] = i;
        for(int i = 0; i <= n; ++i)cost[0][i] = i;

        // calc (i+1, j+1)
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(word1.charAt(i) == word2.charAt(j)){
                    cost[i+1][j+1] = cost[i][j];
                } else{
                    cost[i+1][j+1]  = 1
                            + Math.min(cost[i][j], // replacement
                            Math.min(cost[i+1][j],  // insertion
                                    cost[i][j+1])); // deletion
                }
            }
        }
        return cost[m][n];
    }
}
