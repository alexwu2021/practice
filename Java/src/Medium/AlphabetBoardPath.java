package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
 *
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 *
 *
 *
 * We may make the following moves:
 *
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the board;
 * 'L' moves our position left one column, if the position exists on the board;
 * 'R' moves our position right one column, if the position exists on the board;
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * (Here, the only positions that exist on the board are positions with letters on them.)
 *
 * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
 *
 *
 */
public class AlphabetBoardPath {


    /** from TumeiCoding, very close to my thinking
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Alphabet Board Path.
     * Memory Usage: 37 MB, less than 86.26% of Java online submissions for Alphabet Board Path.
     * looks like a better sol
     * @param target
     * @return
     */
    public String alphabetBoardPath(String target) {
        if(target == null) return "";
        char[] chs = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        int previ = 0, prevj = 0;
        for(int i = 0; i < chs.length; ++i) {
            int curi = (chs[i] - 'a') / 5;
            int curj = (chs[i] - 'a') % 5;
            if(curi == previ && curj == prevj) {
                sb.append("!");
            } else {
                printPath(sb, previ, prevj, curi, curj);
                sb.append("!");
                previ = curi; prevj = curj;
            }
        }
        return sb.toString();
    }


    private void printPath(StringBuilder sb, int previ, int prevj, int curi, int curj) {
        while(curi < previ) {
            sb.append("U"); curi++;
        }
        while(curj > prevj) {
            sb.append("R"); curj--;
        }
        while(curj < prevj) {
            sb.append("L"); curj++;
        }
        while(curi > previ) {
            sb.append("D"); curi--;
        }
    }

    /** from votrubac
     * Runtime: 9 ms
     * Memory Usage: 39.2 MB
     * Submitted: 11 minutes ago
     * @param target
     * @return
     */
    public String alphabetBoardPath_smarty_passed_oj(String target) {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            int x1 = (ch - 'a') % 5, y1 = (ch - 'a') / 5;
            sb.append(String.join("", Collections.nCopies(Math.max(0, y - y1), "U")) +
                    String.join("", Collections.nCopies(Math.max(0, x1 - x), "R")) +
                    String.join("", Collections.nCopies(Math.max(0, x - x1), "L")) +
                    String.join("", Collections.nCopies(Math.max(0, y1 - y), "D")) + "!");
            x = x1;
            y = y1;
        }
        return sb.toString();
    }

//
//    private void helper(char[][] board, int[] pos, char[] sa, int index, StringBuffer sb) {
//        if(index >= sa.length)
//            return;
//
//        int rows = board.length;
//        int cols = board[0].length;
//        int r = pos[0],c=pos[1];
//        if(r <0 || r >= rows || c<0 || c>= cols)
//            return;
//
//        char curr = board[r][c];
//        int diff = sa[index] - curr;
//        int hang = diff / 5;
//        if (diff > 0 ){
//            if (hang > 0){
//                sb.append('D');
//                helper(board, new int[]{r+1, c}, sa, index, sb);
//            }else{
//                // what if r == rows -1
//                if(c+1 <cols){
//                    sb.append('R');
//                    helper(board, new int[]{r, c+1}, sa, index, sb);
//                }
//                else{
//                    sb.append('D');
//                    helper(board, new int[]{r+1, c}, sa, index, sb);
//                }
//            }
//        } else if (diff < 0 ){
//            if (hang < 0){
//                sb.append('U');
//                helper(board, new int[]{r-1, c}, sa, index, sb);
//            }else{
//                if(c-1 >0){
//                    sb.append('L');
//                    helper(board, new int[]{r, c-1}, sa, index, sb);
//                }else{
//                    sb.append('U');
//                    helper(board, new int[]{r-1, c}, sa, index, sb);
//                }
//            }
//
//
//        } else{
//            sb.append('!');
//            helper(board, pos, sa,index+1, sb);
//        }
//    }
//
//
//    public String alphabetBoardPath_naive_buggy(String target) {
//        char[][] board = new char[6][5];
//        int j = 0;
//        board[j++] = new char[]{'a','b','c','d','e'};
//        board[j++] = new char[]{'f','g','h','i','j'};
//        board[j++] = new char[]{'k','l','m','n','o'};
//        board[j++] = new char[]{'p','q','r','s','t'};
//        board[j++] = new char[]{'u','v','w','x','y'};
//        board[j] =new char[]{'z'} ;//, '{', '|','}','_'};
//
//        StringBuffer sb = new StringBuffer();
//        char[] sa = target.toCharArray();
//        int[] pos = new int[]{0, 0};
//
//        helper(board, pos, sa, 0, sb);
//
//        return String.valueOf(sb);
//    }
}
