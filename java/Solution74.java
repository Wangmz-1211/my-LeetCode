class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0], max = matrix[m-1][n-1];
        if(target < min|| target>max) return false;
        int pl = 0, pr = m-1;
        int col = 0;
        while(pr > pl){
            col = pl + (pr - pl)/2;
            if( matrix[col][0] >= target) {
                pr = col; continue;
            }
            if( matrix[col][n-1] < target) {
                pl = ++col; continue;
            }
            break;
        }
        pl = 0; pr = n-1;
        while(pr - pl > 1){
            int row = pl + (pr - pl +1)/2;
            if(matrix[col][row] > target) pr = row;
            else pl = row;
        }
        return matrix[col][pl] == target || matrix[col][pr] == target;
    }
}
