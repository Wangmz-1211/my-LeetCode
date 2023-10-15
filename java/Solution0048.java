class Solution {
    /**
     * ori: row, col
     * 2nd: col, n-row-1
     * 3rd: n-row-1, n-col-1
     * 4th: n-col-1, col
     * ori: row, col
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rowRange = n/2, colRange = n/2 +( n/2*2==n ? 0 : 1);
        int prev = 0, tmp = 0;
        for(int row  = 0 ; row < rowRange; row ++){
            for(int col = 0; col < colRange; col ++) {
                // get the ori
                prev = matrix[row][col];
                // handle 2nd place
                tmp = matrix[col][n-row-1];
                matrix[col][n-row-1] = prev;
                prev = tmp;
                // handle 3rd place
                tmp = matrix[n-row-1][n-col-1];
                matrix[n-row-1][n-col-1] = prev;
                prev = tmp;
                // handle 4th place
                tmp = matrix[n-col-1][row];
                matrix[n-col-1][row] = prev;
                prev = tmp;
                // handle ori
                matrix[row][col] = prev;
            }
        }
    }
}
