class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int d;
        int profit = 0;
        for(int i = 0; i < n-1; i ++){
            if((d = prices[i+1] - prices[i]) > 0) profit += d;
        }
        return profit;
    }
}
