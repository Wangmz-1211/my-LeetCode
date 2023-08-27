class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] + chars1[i - 1];
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] + chars2[i - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + chars1[i-1],dp[i][j-1] + chars2[j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}