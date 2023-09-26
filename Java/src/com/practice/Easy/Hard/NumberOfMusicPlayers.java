package com.practice.Easy.Hard;



/**
 * 920. Number of Music Playlists
 */
public class NumberOfMusicPlayers {

    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = 1_000_000_007;

        // dp[i][j]: i: the number of player list created so far; j: number of unique song so far used

        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1; // always have a way to create a player list with 0 unique song

        for (int i = 1; i <= goal; ++i) {
            for (int j = 1; j <= Math.min(i, n); ++j) { // at most n provided, though i is required
                dp[i][j] = (dp[i - 1][j - 1] * (n - j + 1)) % MOD; // as of now, we can pick from n-(j-1) new song, for dp[i-1][j-1] uses j-1 new song
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD;
                }
            }
        }
        return (int) dp[goal][n];
    }
}
