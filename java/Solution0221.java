class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxVolumn = 0;
        int[][] volumns = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == '0') {
                    volumns[i][j] = 0;
                    continue;
                }
                int volumn = findVolumn(matrix, m, n , i, j);
                volumns[i][j] = volumn;
                maxVolumn = maxVolumn > volumn? maxVolumn: volumn;
            }
        }
        return maxVolumn;
    }
    private int findVolumn(char[][] matrix,int m,int n,int i,int j) {
        int xm = m - 1 - i;
        int ym = n - 1 - j;
        int max = xm < ym ? xm : ym;
        int res = 1;
        for(int l = 1; l <= max; l ++) {
            // right bother
            for(int dy = 0; dy <= l; dy ++) {
                if (matrix[i+dy][j+l]== '0') return res*res;
            }
            // bottom bother
            for(int dx = 0; dx <= l; dx ++) {
                if (matrix[i+l][j+dx]== '0') return res*res;
            }
            res ++;
        }
        return res*res;
    }
}
