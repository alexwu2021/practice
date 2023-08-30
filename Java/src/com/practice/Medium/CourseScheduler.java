package com.practice.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 207. Course Schedule
 * Medium

 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseScheduler {

    /**
     * based on justjiayu's sol
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // r -> c : self --> pre
        int[] deg = new int[numCourses]; // in degree of a course
        for (int r = 0; r < prerequisites.length; ++r) {
            int self = prerequisites[r][0];
            int pre = prerequisites[r][1];
            deg[self]++;
            matrix[self][pre] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int r = 0; r < deg.length; ++r) {
            if (deg[r] == 0) q.offer(r);
        }

        int count = 0; // independent course count
        while (!q.isEmpty()) {
            count++;
            int curr = q.poll();
            for (int r = 0; r < numCourses; ++r) {
                if (matrix[r][curr] != 0) {
                    if (--deg[r] == 0)
                        q.offer(r);
                }
            }
        }
        return count == numCourses;
    }
}


