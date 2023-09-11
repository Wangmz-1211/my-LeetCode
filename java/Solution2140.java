class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        long res = 0;
        for(int i = n-1; i >= 0; i --){
            // bound
            if(i + questions[i][1] + 1 >= n){
                // choice 1: skip until get the max number
                // choice 2: take this as the last question
                res = Math.max(res, questions[i][0]);
                dp[i] = res;
            } else {
                // choice 1: skip until get the max number
                // choice 2: take this question
                res = Math.max(
                    res,
                    questions[i][0] + dp[i+ questions[i][1]+1]
                );
                dp[i] = res;
            }
        }
        return res;
    }
}
