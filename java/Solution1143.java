class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        // dp[i][j]: the longest substr in text1[0:i] and text2[0:j]
        int[][] dp = new int[m+1][n+1];
        // start dp
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j++) {
                if(chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }
}
