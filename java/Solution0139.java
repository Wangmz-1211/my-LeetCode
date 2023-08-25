import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int r = 1; r <= length; r++) {
            for (int l = 0; l < r; l++) {
                if (dp[l] && words.contains(s.substring(l, r))) dp[r] = true;
            }
        }
        return dp[length];
    }
}