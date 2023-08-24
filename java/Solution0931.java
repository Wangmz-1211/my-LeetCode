class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int size = matrix.length;
        for(int i = 1; i < size; i ++) {
            // on the left column (2 connections)
            matrix[i][0] +=  matrix[i-1][0]< matrix[i-1][1] ? matrix[i-1][0]: matrix[i-1][1];
            // in the bulk (3 connections)
            for(int j = 1; j < size-1; j++) {
                matrix[i][j] += 
                min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1]);
            }
            // on the right column (2 connections)
            matrix[i][size-1] += matrix[i-1][size-2]< matrix[i-1][size-1]? matrix[i-1][size-2]: matrix[i-1][size-1];
        }
        // finding res in the last row
        int res = matrix[size-1][0];
        for (int i = 1; i < size;i  ++){
            res = matrix[size-1][i] < res?matrix[size-1][i] : res;
        }
        return res;
    }
    private int min(int a, int b, int c) {
        int res = a;
        res = b < res ? b : res ;
        return c < res ? c : res;
    }
}
