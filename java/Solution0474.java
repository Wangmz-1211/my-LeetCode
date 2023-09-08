import java.util.Arrays;
import java.util.Comparator;

// unpassed
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // record the configuration of each string
        // the number of 0 in i-th str: conf[i-1][0]
        // the number of 1 in i-th str: conf[i-1][1]
        int[][] conf = new int[strs.length][2];
        char[] chars;
        for(int i = 0; i < strs.length; i++) {
            chars = strs[i].toCharArray();
            for(char c: chars) conf[i-1][c-'0']++;
        }
        Arrays.sort(conf, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0] != 0 ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        // dp[i][0]: 0 number in largest subset
        // dp[i][1]: 1 number in largest subset
        // dp[i][2]: size of largest subset
        int[][] dp = new int[strs.length][3];
        if (conf[0][0] <= m && conf[0][1] <= n) {
            dp[0][0] = conf[0][0];
            dp[0][1] = conf[0][1];
            dp[0][2] = 1;
        }
        for(int i = 1; i < strs.length; i++){
            for(int j = 0; j < i; j++){
                if (conf[i][0] + dp[j][0] <= m && conf[i][1] + dp[j][1] <= n) {
                    dp[i][0] = conf[i][0] + dp[j][0];
                    dp[i][1] = conf[i][1] + dp[j][1];
                    dp[i][2] = dp[j][2] + 1;
                }
            }
        }
        return dp[strs.length-1][2];
    }
}