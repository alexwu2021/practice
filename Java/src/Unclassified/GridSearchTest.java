//package Unclassified;
//
//
//public class GridSearchTest {
//
//    @Test
//    public void findInGrid() {
//
//        GridSearch gridSearch = new GridSearch();
//        GridSearch.Position res;
//
//
//        // trivia case 1.1: one-dimension grid, horizontal
//        int nullGrid[][] = null;
//        res = gridSearch.findInGrid(nullGrid, 100);
//        assert(res.i == -1 && res.j == -1);
//
//        // trivia case 1.2: one-dimension grid, horizontal
//        int nullGrid2[][] = {{}};
//        res = gridSearch.findInGrid(nullGrid2, 100);
//        assert(res.i == -1 && res.j == -1);
//
//
//
//        // trivia case 1.3: one-dimension grid, horizontal
//        int trivialGrid[][] = {{1, 3, 7, 11, 15}};
//        res = gridSearch.findInGrid(trivialGrid, 6);
//        assert(res.i == -1 && res.j == -1);
//
//        res = gridSearch.findInGrid(trivialGrid, 3);
//        assert(res.i == 0 && res.j == 1);
//
//
//        res = gridSearch.findInGrid(trivialGrid, 15);
//        assert(res.i == 0 && res.j == 4);
//
//        // trivia case 1.4: one-dimension grid, vertical
//        int trivialGrid2[][] = {{1}, {8}, {19}, {20}};
//        res = gridSearch.findInGrid(trivialGrid2, 10);
//        assert(res.i == -1 && res.j == -1);
//
//        res = gridSearch.findInGrid(trivialGrid2, 19);
//        assert(res.i == 2 && res.j == 0);
//
//
//        res = gridSearch.findInGrid(trivialGrid2, 20);
//        assert(res.i == 3 && res.j == 0);
//
//
//        // normal case: a 4 by 5 grid
//        int grid[][] = { {1,    3,      7,      11,     15  },
//                        {12,    17,     19,     23,     26  },
//                        {13,    18,     36,     38,     57  },
//                        {101,   135,    137,    149,    150 }};
//
//        res = gridSearch.findInGrid(grid, 6);
//        assert(res.i == -1 && res.j == -1);
//
//        res = gridSearch.findInGrid(grid, 15);
//        assert(res.i == 0 && res.j == 4);
//
//
//        res = gridSearch.findInGrid(grid, 36);
//        assert(res.i == 2 && res.j == 2);
//
//        res = gridSearch.findInGrid(grid, 38);
//        assert(res.i == 2 && res.j == 3);
//
//        res = gridSearch.findInGrid(grid, 149);
//        assert(res.i == 3 && res.j == 3);
//
//
//        res = gridSearch.findInGrid(grid, 150);
//        assert(res.i == 3 && res.j == 4);
//
//
//    }
//
//    @Test
//    public void findInGrid_TwoPointers() {
//
//        GridSearch gridSearch = new GridSearch();
//        GridSearch.Position res;
//
//
//        // trivia case 1.1: one-dimension grid, horizontal
//        int nullGrid[][] = null;
//        res = gridSearch.findInGrid_TwoPointers(nullGrid, 100);
//        assert(res.i == -1 && res.j == -1);
//
//        // trivia case 1.2: one-dimension grid, horizontal
//        int nullGrid2[][] = {{}};
//        res = gridSearch.findInGrid_TwoPointers(nullGrid2, 100);
//        assert(res.i == -1 && res.j == -1);
//
//
//
//        // trivia case 1.3: one-dimension grid, horizontal
//        int trivialGrid[][] = {{1, 3, 7, 11, 15}};
//        res = gridSearch.findInGrid_TwoPointers(trivialGrid, 6);
//        assert(res.i == -1 && res.j == -1);
//
//        res = gridSearch.findInGrid_TwoPointers(trivialGrid, 3);
//        assert(res.i == 0 && res.j == 1);
//
//
//        res = gridSearch.findInGrid_TwoPointers(trivialGrid, 15);
//        assert(res.i == 0 && res.j == 4);
//
//        // trivia case 1.4: one-dimension grid, vertical
//        int trivialGrid2[][] = {{1}, {8}, {19}, {20}};
//        res = gridSearch.findInGrid_TwoPointers(trivialGrid2, 10);
//        assert(res.i == -1 && res.j == -1);
//
//        res = gridSearch.findInGrid_TwoPointers(trivialGrid2, 19);
//        assert(res.i == 2 && res.j == 0);
//
//
//        res = gridSearch.findInGrid_TwoPointers(trivialGrid2, 20);
//        assert(res.i == 3 && res.j == 0);
//
//
//        // normal case: a 4 by 5 grid
//        int grid[][] = { {1,    3,      7,      11,     15  },
//                {12,    17,     19,     23,     26  },
//                {13,    18,     36,     38,     57  },
//                {101,   135,    137,    149,    150 }};
//
//        res = gridSearch.findInGrid_TwoPointers(grid, 6);
//        assert(res.i == -1 && res.j == -1);
//
//        res = gridSearch.findInGrid_TwoPointers(grid, 15);
//        assert(res.i == 0 && res.j == 4);
//
//
//        res = gridSearch.findInGrid_TwoPointers(grid, 36);
//        assert(res.i == 2 && res.j == 2);
//
//        res = gridSearch.findInGrid_TwoPointers(grid, 38);
//        assert(res.i == 2 && res.j == 3);
//
//        res = gridSearch.findInGrid_TwoPointers(grid, 149);
//        assert(res.i == 3 && res.j == 3);
//
//
//        res = gridSearch.findInGrid_TwoPointers(grid, 150);
//        assert(res.i == 3 && res.j == 4);
//
//    }
//
//
//    /** To prove the results from the two method are the same
//     *
//     */
//    @Test
//    public void findInGrid_EquivalenceTest() {
//        GridSearch gridSearch = new GridSearch();
//        GridSearch.Position res, resTwoPointers;
//
//        Random random = new Random(System.currentTimeMillis());
//        int[][] grid;
//        int searchTarget, numRow, numCol;
//        int numTests = random.nextInt(1000);
//
//        // do side by side comparison for random number of tess
//        for(int i = 0; i < numTests; ++i){
//            searchTarget = random.nextInt(100);
//            numRow = 1 + random.nextInt(10);
//            numCol = 1 + random.nextInt(10);
//            grid = generateARandomGrid(numRow, numCol);
//            res = gridSearch.findInGrid(grid, searchTarget);
//            resTwoPointers = gridSearch.findInGrid_TwoPointers(grid, searchTarget);
//            assert(res.i == resTwoPointers.i && res.j == resTwoPointers.j);
//        }
//    }
//
//
//    /** To prove the results from the two method are the same
//     *
//     */
//    @Test
//    public void findInGrid_PerformanceTest() {
//        // generate a random grid
//        Random random = new Random(System.currentTimeMillis());
//        int numRow = 10000 + random.nextInt(10000);
//        int numCol = 10000 + random.nextInt(10000);
//        int searchTarget = random.nextInt(100000);
//        int[][] grid = generateARandomGrid(numRow, numCol);
//        long start, finish, timeElapsed, timeElapsed_TwoPointers;
//
//        GridSearch gridSearch = new GridSearch();
//        GridSearch.Position res, resTwoPointers;
//
//        // do side by side comparison
//        int numTests = random.nextInt(5);
//        for(int i= 0; i<numTests; ++i){
//            start = System.currentTimeMillis();
//            res = gridSearch.findInGrid(grid, searchTarget);
//            finish = System.currentTimeMillis();
//            timeElapsed = finish - start;
//
//            start = System.currentTimeMillis();
//            resTwoPointers = gridSearch.findInGrid_TwoPointers(grid, searchTarget);
//            finish = System.currentTimeMillis();
//            timeElapsed_TwoPointers = finish - start;
//
//            assert(res.i == resTwoPointers.i && res.j == resTwoPointers.j);
//
//            // assert the algo I submitted  always uses less time
//            assert(timeElapsed <= timeElapsed_TwoPointers);
//        }
//    }
//
//
//    /** generate a random grid
//     * @return
//     */
//    private int[][] generateARandomGrid(int numRow, int numCol) {
//        Random random = new Random(System.currentTimeMillis());
//        int[][] grid = new int[numRow][numCol];
//        for(int i= 0; i<numRow; i++){
//            for(int j= 0; j<numCol; j++){
//                grid[i][j] = random.nextInt(100);
//            }
//        }
//        return grid;
//    }
//}