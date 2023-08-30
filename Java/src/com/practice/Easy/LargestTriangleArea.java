package com.practice.Easy;

/**
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 *
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 *
 *
 * Notes:
 *
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 *  -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 *
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] p) {
        double res = 0;
        for (int[] i: p){
            for (int[] j: p) {
                for (int[] k : p) {
                    // for segment AB and AC
                    // initially we have Area = 0.5 * | (Xb - Xa, Yb - Ya) x (Xc - Xa, Yc - Ya)|
                    // = 0.5 * | (Xb - Xa) (Yc - Ya)  - (Xc - Xa) (Yb - Ya) |
                    // = 0.5 * | (XaYb + XbYc + XcYa) - (XbYa + XcYb + XaYc ) |

                    // X --> 0, Y --> 1

                    // a -- > i;   b -- > j; c -- > k;
                    // Xa --> i[0], Xb --> j[0], Xc --> k[0]
                    // Ya --> i[1], Yb --> j[1], Yc --> k[1]

                    res = Math.max(res, 0.5 * Math.abs(
                            i[0] * j[1] + j[0] * k[1] + k[0] * i[1] // XaYb + XbYc + XcYa
                            - i[0] * k[1] - k[0] * j[1] - j[0] * i[1] // XaYc + XcYc + XbYa
                    ));
                }
            }
        }

        return res;
    }

    /*
    def largestTriangleArea(self, p):
            return max(0.5 * abs(xa * yb + xb * yc + xc * ya - xb * ya - xc * yb - xa * yc)
                   for (xa, ya), (xb, yb), (xc, yc) in itertools.combinations(p, 3))


     */
}
