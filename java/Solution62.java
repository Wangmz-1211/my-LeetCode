class Solution {
    public int uniquePaths(int m, int n) {
        // mxn matrix
        int[][] dp = new int[m][n];
        // fill the first row with 1
        for (int i = 0; i < n; i ++) {
            dp[0][i] = 1;
        }
        // fill the first column with 1
        for (int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        // calculate every value in matrix
        for (int x = 1; x < m ; x ++) {
            for (int y = 1; y < n; y++) {
                dp[x][y] = dp[x-1][y] + dp[x][y-1];
            }
        }
        // output
        return dp[m-1][n-1];
    }
}
