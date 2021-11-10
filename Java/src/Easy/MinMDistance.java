package Easy;

/**
 * 1779. Find Nearest Point That Has the Same X or Y Coordinate
 * Easy
 *
 * 191
 *
 * 35
 *
 * Add to List
 *
 * Share
 * You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y). You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi). A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.
 *
 * Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location. If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.
 *
 * The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).
 */
public class MinMDistance {
    public int nearestValidPoint(int x, int y, int[][] points) {
        if(points == null || points.length <= 0) return -1;
        int index = -1, d = Integer.MAX_VALUE;
        for(int i= 0; i<points.length; ++i){
            int dx = points[i][0] - x, dy = points[i][1] - y;
            if(dx * dy == 0 ){
                int temp = Math.abs(dx) + Math.abs(dy);
                if(temp < d){
                    d = temp;
                    index = i;
                }
            }
        }
        return index;
    }
}
