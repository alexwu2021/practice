package com.practice.Medium;

public class PathInGridTest {

    private static final char START = 'K';
    private static final char END = 'C';
    private static final char WALL = 'X';
    private static final char PASSABLE= '*';


//    @Test
//    public void isPathExistTest() {
//        char matrix[][] = {{WALL, PASSABLE, WALL, START},
//                {PASSABLE, WALL, PASSABLE, PASSABLE},
//                {END, PASSABLE, PASSABLE, PASSABLE},
//                {WALL, PASSABLE, PASSABLE, PASSABLE}};
//
//        boolean res = new PathInGrid().doesPathExist(matrix, 4);
//        assert(res);
//    }
//
//    @Test
//    public void findAllPathUsingStack() {
//        char matrix[][] = {{WALL, PASSABLE, WALL, START},
//                {PASSABLE, WALL, PASSABLE, PASSABLE},
//                {END, PASSABLE, PASSABLE, PASSABLE},
//                {WALL, PASSABLE, PASSABLE, PASSABLE}};
//
//        /* dfs search returns the following path
//        (0,3)
//        (1,3)
//        (1,2)
//        (2,2)
//        (2,1)
//        (2,0)
//         */
//
//        boolean res = new PathInGrid().findAPathUsingStack(matrix);
//        assert(res);
//    }
//
//
//    @Test
//    public void findAllPathUsingQueue() {
//        char matrix[][] = { {WALL,      PASSABLE,   WALL,       PASSABLE,   START},
//                            {PASSABLE,  WALL,       PASSABLE,   PASSABLE,   PASSABLE},
//                            {PASSABLE,  PASSABLE,   PASSABLE,   PASSABLE,   PASSABLE},
//                            {WALL,      PASSABLE,   PASSABLE,   END,        PASSABLE}};
//
//        /* the bfs search also returns the shortest
//        (0,3)
//        (1,3)
//        (2,3)
//        (2,2)
//        (2,1)
//        (2,0)
//         */
//
//
//        boolean res = new PathInGrid().findAPathUsingQueue(matrix);
//        assert(res);
//
//
//        boolean hasAPath;
//        PathInGrid instance = new PathInGrid();
//
//        // 4 by 4
//        char[][] grid = {   {WALL,      PASSABLE,   WALL,       START},
//                {PASSABLE,  WALL,       PASSABLE,   PASSABLE},
//                {END,       PASSABLE,   PASSABLE,   PASSABLE},
//                {WALL,      PASSABLE,   PASSABLE,   PASSABLE}    };
//
//
//        System.out.println("grid has " + grid.length + " rows, and " + grid[0].length + " columns.");
//        hasAPath = instance.findAPathUsingQueue(grid);
//        System.out.println("findAPathUsingQueue run result:" + hasAPath);
//
//        hasAPath = instance.findAPathUsingStack(grid);
//        System.out.println("findAPathUsingStack run result:" + hasAPath);
//
//
//        // 4 by 5
//        char[][] grid2 = { {WALL,      PASSABLE,   WALL,       PASSABLE,   START},
//                {PASSABLE,  WALL,       PASSABLE,   PASSABLE,   PASSABLE},
//                {PASSABLE,  PASSABLE,   PASSABLE,   PASSABLE,   PASSABLE},
//                {WALL,      PASSABLE,   PASSABLE,   END,        PASSABLE}};
//
//        System.out.println("grid2 has " + grid2.length + " rows, and " + grid2[0].length + " columns.");
//
//        hasAPath = instance.findAPathUsingQueue(grid2);
//        System.out.println("findAPathUsingQueue run result on grid2:" + hasAPath);
//
//        hasAPath = instance.findAPathUsingStack(grid2);
//        System.out.println("findAPathUsingStack run result on grid2:" + hasAPath);
//
//
//        // no END in the grid
//        char[][] grid3 = { {WALL,      PASSABLE,   PASSABLE,   START}};
//
//        System.out.println("grid3 has " + grid3.length + " rows, and " + grid3[0].length + " columns.");
//
//        hasAPath = instance.findAPathUsingQueue(grid3);
//        System.out.println("findAPathUsingQueue run result on grid3:" + hasAPath);
//
//        hasAPath = instance.findAPathUsingStack(grid3);
//        System.out.println("findAPathUsingStack run result on grid3:" + hasAPath);
//
//        // no END in the grid
//        char[][] grid4 = { {END,      WALL,   PASSABLE,   START}};
//
//        System.out.println("grid4 has " + grid4.length + " rows, and " + grid4[0].length + " columns.");
//
//        hasAPath = instance.findAPathUsingQueue(grid4);
//        System.out.println("findAPathUsingQueue run result on grid4:" + hasAPath);
//
//        hasAPath = instance.findAPathUsingStack(grid4);
//        System.out.println("findAPathUsingStack run result on grid4:" + hasAPath);
//    }


}