class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] sub = new int[length];
        if(length ==1) return nums[0];
        sub[0] = nums[0];
        sub[1] = nums[0]>nums[1]? nums[0]: nums[1];
        for(int i= 2 ; i< length; i++){
            int v1 = nums[i] + sub[i-2];
            int v2 = sub[i-1];
            sub[i] = v1 > v2 ? v1: v2; 
        }
        return sub[length-1];
    }
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        // only 1 house to rob
        if(len == 1) return nums[0];
        // steel from 0th house to the last house
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (nums[1] > nums[0]) {
            dp[1] = nums[1];
        } else dp[1] = dp[0];
        // calculate max value of every place
        for(int i=2; i< len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];

    }
}
