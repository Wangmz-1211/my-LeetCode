class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len == 1 ) return 1;
        // dp matrix
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // enumerating the window:
        // gap = r - l
        for(int gap = 1; gap < len ; gap ++) {
            for (int l = 0; l < len; l ++) {
                // [l, r] is a sliding window, checking the symmetry
                int r = gap + l;
                // outbound
                if (r >= len) break;
                // core logic
                if( chars[l] == chars[r]){
                    dp[l][r] = dp[l+1][r-1] +2;
                } else {
                    dp[l][r] = Math.max(dp[l+1][r],dp[l][r-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}