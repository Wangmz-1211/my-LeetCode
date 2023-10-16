class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;
        // check if the first column needs reset
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // check if the first row needs reset
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // project zeros to the first row/column
        for(int i = 1; i < m; i++) {
            for(int j= 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // reset the table according to first row/column
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                setRowZero(matrix, i);
            }
        }
        for(int i = 1; i < n; i++){
            if(matrix[0][i] == 0 ) {
                setColZero(matrix, i);
            }
        }
        // reset the first row/column
        if(firstColZero) setColZero(matrix, 0);
        if(firstRowZero) setRowZero(matrix, 0);
    }
    private void setColZero(int[][] matrix, int col) {
        int m = matrix.length;
        for(int i = 0; i < m; i ++){
            matrix[i][col] = 0;
        }
    }
    private void setRowZero(int[][] matrix, int row) {
        int n = matrix[0].length;
        for( int i=  0; i < n; i++ ){
            matrix[row][i] = 0;
        }

    }
}
