class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // fill the first row
        for (int i = 1; i < n; i ++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        // fill the first column
        for (int i = 1; i < m; i ++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // fill every place
        for (int x = 1; x < m; x ++) {
            for (int y = 1; y < n ; y ++) {
                dp[x][y] = Math.min(dp[x-1][y], dp[x][y-1]) + grid[x][y];
            }
        }
        // output
        return dp[m-1][n-1];        
    }
}
