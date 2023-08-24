class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // fill the first row
        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        // fill the first column
        for (int i = 0; i < m; i ++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        // dp
        for (int x = 1; x < m; x ++) {
            for (int y = 1; y < n; y ++) {
                if (obstacleGrid[x][y] == 1) continue;
                dp[x][y] = dp[x-1][y] + dp[x][y-1];
            }
        }
        // output
        return dp[m-1][n-1];
    }
}
