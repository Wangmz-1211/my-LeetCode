class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        // the lowest cost to arrive the position
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        // calculate the lowest cost to arrive every position
        for (int i = 2; i < len+1; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[len];
    }
}
