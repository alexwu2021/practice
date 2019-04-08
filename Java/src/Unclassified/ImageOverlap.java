package Unclassified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 */
public class ImageOverlap {

    /** Borrowed from kaiyuan3
     *
     * @param A
     * @param B
     * @return
     */
    public int largestOverlap(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>(); // two lists to save pixel coordinates
        for (int r = 0; r<rows; r++)
            for (int c = 0; c<cols; c++){
                if (A[r][c] == 1) la.add(new int[]{r,c}); // save the pixel coordinates
                if (B[r][c] == 1) lb.add(new int[]{r,c});
            }
        Map<String, Integer> map = new HashMap<>(); // map to map the vector (from a pixel in A to a pixel in B) to its count
        for (int[] pa : la)
            for (int[] pb : lb) {
                String s = (pa[0] - pb[0]) + " " + (pa[1]-pb[1]); // get the vector from a pixel in A to a pixel in B
                map.put(s, map.getOrDefault(s, 0) + 1); // count the number of same vectors
            }
        int max = 0;
        for (int count : map.values())
            max = Math.max(max, count);
        return max;
    }

}
