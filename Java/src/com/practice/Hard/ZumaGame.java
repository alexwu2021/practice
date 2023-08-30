package com.practice.Hard;

/**
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
 *
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.
 *
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.
 *
 * Examples:
 *
 * Input: "WRRBBW", "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 *
 * Input: "WWRRBBWW", "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 *
 * Input:"G", "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty
 *
 * Input: "RBYYBBRRB", "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 *
 * Note:
 * You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 * The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
 * The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 * Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 *
 *
 * you are allowed to do insert
 * remove those balls back if their number is 3+ and if they are of the same color
 *
 *
 */
public class ZumaGame {

    static final int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

    /**
     * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.
     *
     * the solution came from magtron_3, it has a great room for improvement
     *
     * this problem has some issues by design.
     * @param board
     * @param hand
     * @return
     */
    public int findMinStep(String board, String hand) {
        int[] colorCount = new int[26];
        for (int i = 0; i < hand.length(); ++i)
            ++colorCount[hand.charAt(i) - 'A'];
        int rs = helper(board + "#", colorCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
        return rs == MAXCOUNT ? -1 : rs;
    }
    private int helper(String s, int[] h) {
        s = removeConsecutiveColors(s);
        if (s.equals("#")) return 0;

        int res = MAXCOUNT, qualified = 0;

        // i holds, j runs
        for (int i = 0, j = 0 ; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            qualified = 3 - (j - i);     //balls need to be removed from current consecutive balls.
            if (h[s.charAt(i) - 'A'] >= qualified) {

                // update the global counter
                h[s.charAt(i) - 'A'] -= qualified;

                // problem reduction happens here
                res = Math.min(res, qualified + helper(s.substring(0, i) + s.substring(j), h));

                // tailspin compensation
                h[s.charAt(i) - 'A'] += qualified;
            }

            // catch up, maintaining the two pointers
            i = j;
        }
        return res;
    }

    private String removeConsecutiveColors(String board) {
        for (int i = 0, j = 0; j <= board.length(); ++j) {

            if (j < board.length() && board.charAt(j) == board.charAt(i))
                continue;

            if (j - i >= 3)
                return removeConsecutiveColors(board.substring(0, i) + board.substring(j));
            // yet another catch up
            i = j;
        }
        return board;
    }
}
