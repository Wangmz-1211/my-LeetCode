class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int p = 0;
        int[] dp = new int[366];
        for(int i = 1; i < 366; i++) {
            // travelled all plan
            if(p == n) return dp[i-1];
            // didn't reach the next plan day
            if(i != days[p]) {
                dp[i] = dp[i-1];
                continue;
            }
            // choose the cheapest way
            dp[i] = Math.min(
                Math.min(
                    // one-day ticket
                    dp[i-1] + costs[0],
                    // 7-days ticket
                    costs[1] + (i - 7 >= 0? dp[i-7] : 0)
                    ),
                // 30-days ticket
                costs[2] + (i - 30 >= 0? dp[i-30]: 0)
                );
            p++;
        }
        return dp[365];
    }
}
