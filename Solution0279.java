class Solution {
    public int numSquares(int n) {
        // find the upper bound
        int upper = (int)Math.sqrt(n) + 1;
        int[] dp = new int[n+1];
        // start dp
        for(int i = 1; i <= n; i++) {
            // perfect square
            int square = (int) Math.sqrt(i);
            if(square*square == i) {
                dp[i] = 1;
                continue;
            }
            // enumerating j
            int res = Integer.MAX_VALUE;
            for(int j = 1; j <= square; j++) {
                res = Math.min(res, 1 + dp[i - j*j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
