class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i < target; i++){
            for(int num: nums) {
                int flag = i + num;
                if( flag > target) continue;
                dp[flag] += dp[i];
            }
        }
        return dp[target];
    }
}
