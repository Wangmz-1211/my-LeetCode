class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if(length == 1) return s;
        int max= 1;
        int ml=0,mr=0;
        int[][] dp = new int[length][length];
        for(int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        // enumerating the gap:
        //  gap = pr - pl 
        for(int gap = 1; gap < length; gap ++) {
            // enumerating the left of the sliding window
            for(int pl = 0; pl < length; pl ++) {
                // calculate the right of the sliding window
                int pr = pl + gap;
                // stop sliding this pl when pr outbound
                if (pr >= length) break;
                int tmp;
                if (chars[pl] == chars[pr] && 
                (dp[pl+1][pr-1] != 0 || pl+2 > pr )) tmp = (dp[pl][pr] = pr - pl + 1);
                else continue;
                if ( pr - pl + 1 > max) {
                    max =  pr - pl + 1;
                    ml = pl;
                    mr = pr;
                }
            }
        }
        char[] res = new char[max];
        s.getChars(ml,mr+1,res,0);
        return new String(res);
    }
}
