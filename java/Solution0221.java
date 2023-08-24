// 2321ms
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

// 40ms
// Start from down right corner.
// 1. Fill the down and right border of the dp matrix.
// 2. Checking every cell in the matrix from right to left, down to up.
// 3. When checking a '1' cell, first check the cell connected to it's down right corner:
//      - if that cell is '0', the largest triangle can this cell form is 1.
//      - otherwise, check the new border of the triangle. Whenever the right and below is '1',
//        this cell could form a larger triangle. And the largest triangle can this cell form is
//        as large as the size of the down-right cell plus 1.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxLen = 0;
        int[][] volumns = new int[m][n];
        // fill the right border
        for (int i = 0; i < m; i ++) {
            int tmp = matrix[i][n-1] - '0';
            volumns[i][n-1] = tmp;
            maxLen = maxLen < tmp ? tmp : maxLen;
        }
        // fill the bottom border 
        for (int j = 0; j < n; j ++) {
            int tmp =  matrix[m-1][j] - '0';
            volumns[m-1][j] = tmp;
            maxLen = maxLen < tmp ? tmp : maxLen;
        }
        for (int i = m-2; i >=0; i--) {
            // checking a cell
            for (int j = n-2; j >=0; j--) {
                // encode the char to integer
                int tmp = matrix[i][j] - '0';
                volumns[i][j] = tmp;
                // ensure the maxLen is up to date
                maxLen = maxLen > tmp ? maxLen: tmp;
                // ensure this is a '1' cell
                if (volumns[i][j] == 0) continue;
                // checking the corner cell value
                int corner = volumns[i+1][j+1];
                if( corner == 0) continue;
                for(int d = 1; d <= corner; d++) {
                    // checking the largest triangle can this cell form
                    if( volumns[i+d][j] == 0
                        ||
                        volumns[i][j+d] == 0 ) break;
                    volumns[i][j] ++;
                }
                // update the result
                maxLen = maxLen > volumns[i][j]? maxLen: volumns[i][j];
            }
        }
        // output the volumn instead of length
        return maxLen * maxLen;
    }
}
