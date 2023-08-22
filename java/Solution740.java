class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n-1];
        int len = max - min + 1;
        // store sum of every nums[i] at sums[nums[i]-min]
        int[] sums = new int[len];        
        for (int i = 0; i < n; i ++) {
            sums[ nums[i]-min ] += nums[i];
        }
        // classical dp algo (rob)
        if (len == 1) return sums[0];
        int[] dp = new int[len];
        dp[0] = sums[0];
        dp[1] = Math.max(sums[1], sums[0]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2]+sums[i],dp[i-1]);
        }
        return dp[len-1];
    }
}
