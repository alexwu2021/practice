package Medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SpiralMatrixTest {

    @Test
    public void spiralOrder() {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> res;
        StringBuilder sb;
        int[][] matrix;

//        matrix = new int[] []{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
//        res = spiralMatrix.spiralOrder(matrix);
//        assert (res != null && res.size() == matrix.length * matrix[0].length);
//        sb = new StringBuilder();
//        for(int i = 0; i<res.size(); i++)
//            sb.append(res.get(i)).append(",");
//        assert (sb.toString().equals("1,2,3,6,9,8,7,4,5,"));

        matrix = new int[] []{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}};
        res = spiralMatrix.spiralOrder(matrix);
        assert (res != null && res.size() == matrix.length * matrix[0].length);
        sb = new StringBuilder();
        for(int i = 0; i<res.size(); i++)
            sb.append(res.get(i)).append(",");
        assert (sb.toString().equals("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10,"));
                                    //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,7,11,10,9]
                                    //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,7,11,10,9]

    }
}