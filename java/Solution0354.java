import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // timeout
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        for (int[] envelope : envelopes) {
            System.out.println(Arrays.toString(envelope));
        }
        int n = envelopes.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(envelopes[j][1] < envelopes[i][1]) max = Math.max(dp[j], max);
            }
            dp[i] = max + 1;
            res = Math.max(dp[i], res);
        }
        return res;
    }
}