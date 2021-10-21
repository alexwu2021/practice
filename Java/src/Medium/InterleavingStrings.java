package Medium;

public class InterleavingStrings {


    /**
     * a dp solution
     * @param sCol
     * @param sRow
     * @param s3
     * @return
     */
    public boolean isInterleave(String sCol, String sRow, String s3) {
        int rows = sRow.length();
        int cols = sCol.length();
        if ((cols+rows)!=s3.length()) return false;

        boolean[][] matrix = new boolean[rows+1][cols+1]; //(i, j) -> {up to index of i in sRow, up to index of j in sCol}
        matrix[0][0] = true;
        for (int i = 1; i < cols + 1; ++i)
            matrix[0][i] = matrix[0][i-1]&&(sCol.charAt(i-1)==s3.charAt(i-1));

        for (int i = 1; i < rows+1; ++i)
            matrix[i][0] = matrix[i-1][0]&&(sRow.charAt(i-1)==s3.charAt(i-1));

        for (int i = 1; i < rows+1; i++){
            for (int j = 1; j < cols + 1; j++){
                matrix[i][j] = (matrix[i-1][j]&&(sRow.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(sCol.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        return matrix[sRow.length()][cols];
    }
}
