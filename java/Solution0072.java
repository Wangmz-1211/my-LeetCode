class Solution {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int l1 = chars1.length, l2 = chars2.length;
        // dp[x][y]: min operation to convert words1[0:x] to words2[0:y]
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        // dynamic programming
        for (int x = 1; x <= l1; x++) {
            for (int y = 1; y <= l2; y++) {
                if (chars1[x-1] == chars2[y-1]) {
                    dp[x][y] = dp[x-1][y-1];
                } else {
                    dp[x][y] = 1 + min(dp[x-1][y], dp[x][y-1], dp[x-1][y-1]);
                }
            }
        }
        return dp[l1][l2];
    }

    private int min(int a , int b , int c) {
        int res = a < b ? a : b;
        return res < c ? res : c;
    }
}