import java.util.Arrays;
// 54 ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] res= new int[len];
        // initial
        Arrays.fill(dp, 1);
        Arrays.fill(res, 1);
        // dp
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j >=0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[i] > res[i-1]) break;
                }
            }
            res[i] = Math.max(res[i-1], dp[i]);
        }
        return res[len-1];
    }
}
// 68 ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max == min) return 1;
        int len = max - min + 1;
        int[] dp = new int[len];
        int bias = min;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[ nums[i] - bias ] == 0 ) dp[ nums[i] - bias ] = 1;
            for (int j = nums[i] - 1; j >= bias; j--) {
                dp[nums[i] -bias] = Math.max(dp[nums[i]-bias], dp[j - bias] + 1);
                res = Math.max(res, dp[nums[i] - bias ]);
            }
        }
        return res;
    }
}