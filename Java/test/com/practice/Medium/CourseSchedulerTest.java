package com.practice.Medium;

import Medium.CourseScheduler;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseSchedulerTest {

    @Test
    public void canFinish() {
        CourseScheduler courseScheduler = new CourseScheduler();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{new int []{1,0}};
        boolean ret = courseScheduler.canFinish(numCourses, prerequisites);
//        assertTrue(ret);
//
//        numCourses = 2;
//        prerequisites = new int[][]{new int []{1,0}, new int []{0,1}};
//        ret = courseScheduler.canFinish(numCourses, prerequisites);
//        assertFalse(ret);
//
//        numCourses = 3;
//        prerequisites = new int[][]{new int []{1,0}, new int []{1,2}, new int[]{0, 1}};
//        ret = courseScheduler.canFinish(numCourses, prerequisites);
//        assertFalse(ret);
//
//
//        numCourses = 3;
//        prerequisites = new int[][]{new int []{0, 1}, new int []{0,2}, new int[]{1, 2}};
//        ret = courseScheduler.canFinish(numCourses, prerequisites);
//        assertTrue(ret);

        numCourses = 8;
        prerequisites = new int[][]{new int []{1, 0}, new int []{2,6}, new int[]{1, 7} ,
                new int []{6, 4}, new int []{7,0}, new int[]{0, 5}      };
        ret = courseScheduler.canFinish(numCourses, prerequisites);
        assertTrue(ret);

    }
}