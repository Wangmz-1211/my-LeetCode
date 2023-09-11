class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] - minimum coin number to make up amount of i
        int[] dp = new int[amount+1];
        for(int i = 1; i <= amount; i++){
            int tmp = Integer.MAX_VALUE;
            // check every coin
            for(int coin: coins){
                // can NOT make up by this coin
                if(i - coin < 0 || dp[i-coin] == -1) continue;
                // can make up by this coin, take the min one
                tmp = Math.min(tmp, 1 + dp[i-coin]);
            }
            if(tmp != Integer.MAX_VALUE) dp[i] = tmp;
            else dp[i] = -1;
        }
        return dp[amount];

    }
}
