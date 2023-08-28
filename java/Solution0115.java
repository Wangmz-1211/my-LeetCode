class Solution {
    public int numDistinct(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        int ls = source.length, lt = target.length;
        // dp[x][y]: the most t[0:y] in s[0:x]
        int[][] dp = new int[ls+1][lt+1];
        // border: when lt = 1
        for (int x = 1; x <= ls; x++) {
            dp[x][1] = dp[x-1][1];
            if (source[x-1] == target[0]) {
                dp[x][1] ++;
            }
        }
        // dp start
        for (int y = 2; y <= lt; y++) {
            for (int x = y; x <= ls; x++) {
                dp[x][y] = dp[x-1][y];
                if (source[x-1] == target[y-1]) {
                    dp[x][y] += dp[x-1][y-1];
                }

            }
        }
        return dp[ls][lt];
    }
}